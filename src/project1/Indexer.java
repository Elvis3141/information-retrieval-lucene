package project1;
// tested for lucene 7.7.2 and jdk13

        import org.apache.lucene.analysis.Analyzer;
        import org.apache.lucene.analysis.en.EnglishAnalyzer;
        import org.apache.lucene.analysis.standard.StandardAnalyzer;
        import org.apache.lucene.document.Document;
        import org.apache.lucene.document.Field;
        import org.apache.lucene.document.StoredField;
        import org.apache.lucene.document.TextField;
        import org.apache.lucene.index.IndexWriter;
        import org.apache.lucene.index.IndexWriterConfig;
        import org.apache.lucene.index.IndexWriterConfig.OpenMode;
        import org.apache.lucene.search.similarities.BM25Similarity;
        import org.apache.lucene.search.similarities.Similarity;
        import org.apache.lucene.store.Directory;
        import org.apache.lucene.store.FSDirectory;

        import java.io.IOException;
        import java.nio.file.Paths;
        import java.util.Date;
        import java.util.List;

        import org.apache.lucene.util.Version;
        import txtparsing.*;

public class Indexer {

    /**
     * Configures IndexWriter.
     * Creates a lucene's inverted index.
     **/

    public Indexer() throws Exception{

        //txt file to be parsed and indexed, it contains one document per line
        String txtFile =  "docs//documents.txt";
        String indexLocation = ("index"); //define were to store the index

        Date start = new Date();
        try {
            // System.out.println("Indexing to directory '" + indexLocation + "'...");

            Directory dir = FSDirectory.open(Paths.get(indexLocation));
            // define which analyzer to use for the normalization of documents
            Analyzer analyzer = new EnglishAnalyzer();

            // Create a new index in the directory, removing any
            // previously indexed documents:
            IndexWriterConfig iwc = new IndexWriterConfig(analyzer);

            iwc.setSimilarity(new BM25Similarity());

            iwc.setOpenMode(OpenMode.CREATE);

            // create the IndexWriter with the configuration as above
            IndexWriter indexWriter = null;

            // parse txt document using TXT parser and index it
            List<MyDoc> docs = TXTParsing.parse2(txtFile);

            for (MyDoc doc : docs){
                indexDoc(indexWriter, doc);
            }

            indexWriter.close();

            Date end = new Date();
            //System.out.println(end.getTime() - start.getTime() + " total milliseconds");

        } catch (IOException e) {
            //System.out.println(" caught a " + e.getClass() +
            //        "\n with message: " + e.getMessage());
        }


    }

    /**
     * Creates a Document by adding Fields in it and
     * indexes the Document with the IndexWriter
     *
     * @param indexWriter the indexWriter that will index Documents
     * @param mydoc the document to be indexed
     **/
        
    private void indexDoc(IndexWriter indexWriter, MyDoc mydoc){

        try {

            // make a new, empty document
            Document doc = new Document();
            // create the fields of the document and add them to the document
            StoredField title = new StoredField("title", mydoc.getTitle());
            doc.add(title);

            String fullSearchableText = mydoc.getText();
            TextField contents = new TextField("text", fullSearchableText, Field.Store.NO);
            doc.add(contents);
            Analyzer analyzer = new EnglishAnalyzer();

            if (indexWriter.getConfig().getOpenMode() == OpenMode.CREATE) {
                // New index, so we just add the document (no old document can be there):
                //System.out.println("adding " + mydoc);
                indexWriter.addDocument(doc);
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Initializes an IndexerDemo
     */

    public static void main(String[] args) {
        try {
            Indexer indexerDemo = new Indexer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
