/*
package utils;

import java.io.*;

import utils.IO;
import parsing.HTML;
import parsing.Text;
import tokenization.Tokenizers;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

*/
/**
 *
 * @author Tonia Kyriakopoulou
 *//*


public class Exercise1 {

    private final static String READ_DIR = "aueb\\html\\";
    private final static String WRITE_DIR = "aueb\\plaintext";

    */
/**
     * read an html file and remove html tags
     * write a new file only plain txt
     *//*

    */
/*public void html2txt() {
        
        //List all the files under a directory
        File[] files = IO.listFiles(READ_DIR);

        //remove html tags from each file found
        for (File file : files) {
            if (file.isFile()) {

                BufferedWriter writer = null;
                try {
                    System.out.println("Converting file " + file.getName() + " to plain txt...");
                    //reads the html file                    
                    StringBuffer html_file = IO.ReadFileIntoAStringLineByLine(READ_DIR + "\\" + file.getName());
                    //removes html tags from html file
                    String clean_html_file = HTML.cleanHTMLtagsWithRegExpr(html_file.toString());
                    //String clean_html_file = HTML.cleanHTMLtagsWithJsoup(html_file.toString());
                    //creates the corresponding txt file with no html tags
                    writer = new BufferedWriter(new FileWriter(WRITE_DIR + "\\" + file.getName()));
                    writer.write(clean_html_file);

                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                } finally {
                    try {
                        writer.close();
                    } catch (Exception e) {
                    }
                }
            }
        }
    }*//*


    */
/**
     * read a file check for emails calling extractEmails 
     * and print emails and corresponding lines
     *//*

    public void printEmails() {
        //List all the files under a directory
        File[] files = IO.listFiles(WRITE_DIR);

        System.out.println("Extracting emails with snippets...");

        for (File file : files) {
            if (file.isFile()) {

                try {
                    //reads the html file without the tags
                    String html_file = IO.ReadEntireFileIntoAString(WRITE_DIR + "\\" + file.getName());
                    String before;
                    String after;
                    //find emails for each file and print them along with the text before and after the email
                    System.out.println(file.getName() + ": ");
                    
                    String[] emails = Text.extractEmails(html_file);
                    
                    for (String email : emails) {
                        int position = html_file.indexOf(email);
                        
                        if (position-70 >= 0) {
                            before = html_file.substring(position - 70, position);
                        }
                        else {
                            before = html_file.substring(0, position);
                        }
                        
                        if (position+ email.length() + 70 <= html_file.length()) {
                            after = html_file.substring(position + email.length(), position + email.length() + 70);
                        }
                        else {
                            after = html_file.substring(position + email.length(), html_file.length());
                        }
                        
                        System.out.println(before + " " + email + " " + after);
                    }
                    System.out.println();
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }
        }
    }
    
    */
/**
     * read a file, normalize and print
     *//*

    public void normalize() throws IOException {
        
        System.out.println("Text normalization...");
        
        //List all the files under a directory
        File[] files = IO.listFiles(WRITE_DIR);

        for (File file : files) {
            if (file.isFile()) {

                try {
                    //reads the html file without the tags
                    String html_file = IO.ReadEntireFileIntoAString(WRITE_DIR + "\\" + file.getName());
                    //tokenize and print contents
                    System.out.println(file.getName() + ": ");
                    //String[] tokens = Tokenizers.tokenizeWithSplit(html_file);
                    //String[] tokens = Tokenizers.tokenizeWithStringTokenizer(html_file);
                    String[] tokens = Tokenizers.tokenizeWithStreamTokenizer(html_file);
                    for (int i = 0; i < tokens.length; i++) {
                        System.out.print(tokens[i] + " ");
                    }  

                    System.out.println();
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }
        }
    }    

    */
/**
     * read a file, normalize and print
     *//*

    public void extractHTMLLinks() throws IOException {
        
        
        Elements[] elements = HTML.listLinks("http://www.aueb.gr");
        
        Elements links = elements[0];
        Elements media = elements[1];
        Elements imports = elements[2];        

        System.out.println("\nMedia: " + media.size());
        for (Element src : media) {
            if (src.tagName().equals("img")) {
                System.out.println(" * " + src.tagName() + ": <" + src.attr("abs:src") + "> " + src.attr("width") + "x" + src.attr("height") +  "(" + src.attr("height") + ")");
            } else {
                System.out.println(" * " + src.tagName() + ": <" + src.attr("abs:src") + ">");
            }
        }

        System.out.println("\nImports: " + imports.size());
        for (Element link : imports) {
            System.out.println(" * " + link.tagName() + " <" + link.attr("abs:href") + "> (" + link.attr("rel") +")");
        }

        System.out.println("\nLinks: " + links.size());
        for (Element link : links) {
            System.out.println(" * a: <" + link.attr("abs:href") + ">  (" + link.text() + ")");
        }        
        
    }    
    
    public static void main(String[] args) throws IOException {
        Exercise1 ex1 = new Exercise1();
        ex1.html2txt();
        //ex1.printEmails();
        //ex1.normalize();
        //ex1.extractHTMLLinks();
    }
}
*/
