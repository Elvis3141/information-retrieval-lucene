/*
package utils;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

*/
/**
 *
 * @author Tonia Kyriakopoulou
 *//*

public class Tokenizers {

    */
/**
     * Tokenizers using SPLIT Removes punctuation and numbers
     *
     * @param String text to be tokenized
     * @return String[] array of tokens
     *//*

    public static String[] tokenizeWithSplit(String text) {
        text = text.toLowerCase();

        Pattern punctuation = Pattern.compile("\\/|\\(|\\)|@|\\||:|\\?|!|-|,|\\.|\\+|[0-9]"); //("[^a-z]"); //create object Pattern based on regex, it doesn't work for greek
        Matcher matcher = punctuation.matcher(text); //scan text to find the pattern
        String plainText = matcher.replaceAll(" "); //returns string with all pattern matches replaced by " ".

        String[] tokens = plainText.split("\\s+"); //tokenize using space delimiter (one or more spaces)
        return tokens;
    }

    */
/**
     * Tokenizers using StringTokenizer Removes punctuation and numbers
     *
     * @param String text to be tokenized
     * @return String[] array of tokens
     *//*

    public static String[] tokenizeWithStringTokenizer(String text) {
        text = text.toLowerCase();

        Pattern punctuation = Pattern.compile("\\/|\\(|\\)|@|\\||:|\\?|!|-|,|\\.|\\+|[0-9]"); //create object Pattern based on regex 
        Matcher matcher = punctuation.matcher(text); //scan text to find the pattern
        String plainText = matcher.replaceAll(" "); //returns string with all pattern matches replaced by "".

        StringTokenizer st = new StringTokenizer(plainText, " ");

        int N = st.countTokens();
        String[] tokens = new String[N];

        int i = 0;
        while (st.hasMoreElements()) {
            tokens[i] = st.nextElement().toString();
            i++;
        }
        return tokens;
    }
    
    */
/**
     * Tokenizers using StreamTokenizer Removes punctuation and numbers (doesn't remove dots)
     *
     * @param String text to be tokenized
     * @return String[] array of tokens
     *//*

    public static String[] tokenizeWithStreamTokenizer(String text) throws IOException{
        text = text.toLowerCase();

        List<String> tokens = new ArrayList<String>();

        StreamTokenizer st = new StreamTokenizer(new StringReader(text));

        while(st.nextToken() != StreamTokenizer.TT_EOF) { //till the end of file is reached
            if (st.ttype == StreamTokenizer.TT_WORD) { //if the token returned is a word
                tokens.add(st.sval);
            } 
        } 
        return tokens.toArray(new String[0]);
    }    
}
*/
