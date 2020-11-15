package project1;

import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceTokenizerFactory;
import org.apache.lucene.analysis.custom.CustomAnalyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.synonym.SynonymGraphFilterFactory;
import org.apache.lucene.analysis.synonym.SynonymMap;
import org.apache.lucene.analysis.synonym.WordnetSynonymParser;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class WordNet {

    public static void main(String[]args) throws IOException, ParseException {
        File file = new File("WordNet/wn_s.pl");
        InputStream stream = new FileInputStream(file);
        Reader rulesReader = new InputStreamReader(stream);
        SynonymMap.Builder parser = null;
        parser = new WordnetSynonymParser(true, true, new WhitespaceAnalyzer());
        ((WordnetSynonymParser) parser).parse(rulesReader);
        SynonymMap synonymMap = parser.build();
    }

}
