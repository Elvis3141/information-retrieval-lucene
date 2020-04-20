package txtparsing;

import utils.IO;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author  Tonia Kyriakopoulou
 */
public class TXTParsing {

/*    public static void main(String args[] ) throws FileNotFoundException {
        String txtfile =  "docs//documents.txt";
        String queriesFile =  "docs//queries.txt";


        String[] str = parseQueries(queriesFile);
        *//*String txt_file = IO.ReadEntireFileIntoAString(txtfile);

        String[] docs = txt_file.split("///");

        for(int i=0; i<docs.length; i++){
            String[] line = docs[i].split("\n");
            if(i == 0){
                MyDoc mydoc = new MyDoc(line[0],docs[0]);
                //System.out.println(mydoc);
            }else {
                MyDoc mydoc = new MyDoc(line[1],docs[i]);
                System.out.println(mydoc);
            }
        }*//*
    }*/

    public static String[] parseQueries(String file) throws FileNotFoundException {
        String txt_file = IO.ReadEntireFileIntoAString(file);
        String[] docs = txt_file.split("///");
        String[] queries = new String[10];

        for (int i = 0; i<docs.length; i++ ){
            String[] line = docs[i].split("\n");
            if(i == 0){
                queries[i] = line[1];
            }else {
                queries[i] = line[2];
            }
        }
        return queries;
    }


    public static List<MyDoc> parse(String file) throws Exception {
        try{
            //Parse txt file
            String txt_file = IO.ReadEntireFileIntoAString(file);
            String[] docs = txt_file.split("///");
            //System.out.println("Read: "+docs.length + " docs");

            //Parse each document from the txt file
            List<MyDoc> parsed_docs= new ArrayList<MyDoc>();

            for(int i=0; i<docs.length; i++){
                String[] line = docs[i].split("\n");
                if(i == 0){
                    MyDoc mydoc = new MyDoc(line[0],docs[0]);
                    //System.out.println(line[0]);

                    parsed_docs.add(mydoc);
                }else {
                    MyDoc mydoc = new MyDoc(line[1],docs[i]);
                    //System.out.println(line[1]);
                    parsed_docs.add(mydoc);
                }
            }

            return parsed_docs;
        } catch (Throwable err) {
            err.printStackTrace();
            return null;
        }
        
    }

}
