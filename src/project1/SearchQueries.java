package project1;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.similarities.BM25Similarity;
import org.apache.lucene.search.similarities.Similarity;
import org.apache.lucene.store.FSDirectory;
import txtparsing.TXTParsing;
import utils.IO;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class SearchQueries {
   private String queriesFile =  "docs//queries.txt";

    public SearchQueries(){
        try{
            String indexLocation = ("index"); //define where the index is stored
            String field = "text"; //define which field will be searched

            //Access the index using indexReaderFSDirectory.open(Paths.get(index))
            //IndexReader is an abstract class, providing an interface for accessing an index.
            IndexReader indexReader = DirectoryReader.open(FSDirectory.open(Paths.get(indexLocation)));

            //Creates a searcher searching the provided index, Implements search over a single IndexReader.
            Analyzer analyzer = new EnglishAnalyzer();
            IndexSearcher indexSearcher = new IndexSearcher(indexReader);
            indexSearcher.setSimilarity(new BM25Similarity());
            // define which analyzer to use for the normalization of user's query

            // create a query parser on the field "contents"
            QueryParser parser = new QueryParser(field, analyzer);
            String[] queries = TXTParsing.parseQueries(queriesFile);

            /**query-number    Q0  document-id rank    score   Exp*/
            String results  = "";
            for (int i=0; i<queries.length; i++){
                // parse the query according to QueryParser
                Query query = parser.parse(queries[i]);
                // search the index using the indexSearcher for k top searchers
                TopDocs queryResults = indexSearcher.search(query, 20);

                ScoreDoc[] hits = queryResults.scoreDocs;
                long numTotalHits = queryResults.totalHits;
                //String docID = indexSearcher.doc();

                for(int j=0; j<hits.length; j++){
                    Document hitDoc = indexSearcher.doc(hits[j].doc);
                    int docID = hits[j].doc;
                    //System.out.println("\tScore "+hits[i].score +"\ttitle="+hitDoc.get("title")/*+"\tcaption:"+hitDoc.get("caption")+"\tmesh:"+hitDoc.get("mesh")*/);
                    //System.out.println("Q"+ i + "\tQ0 " + "\t"+hitDoc.get("title") + "\t0" + "\t"+hits[j].score + "\t Lucene");
                    results = results.concat("Q"+ (i+1) + "\tQ0 " + "\t"+hitDoc.get("title") + "\t0" + "\t"+hits[j].score + "\t Lucene\n");
                    System.out.println(hitDoc.get("text"));
                    System.out.println("\n");
                }
            }
            IO.WriteToFile(results, "docs//results_file.txt", "C://Users//Elvis//Desktop//Anaktish//trec_eval//results_file.txt");

            //Close indexReader
            indexReader.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        SearchQueries searcherDemo = new SearchQueries();
    }
}
