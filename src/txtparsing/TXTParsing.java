package txtparsing;

import utils.IO;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author  Tonia Kyriakopoulou
 */
public class TXTParsing {

    /*public static void main(String args[] ) throws FileNotFoundException {
        String txtfile =  "docs//documents.txt";
        String queriesFile =  "docs//queries.txt";


        String[] str = parseQueries(queriesFile);
        String txt_file = IO.ReadEntireFileIntoAString(txtfile);
        //System.out.println("Read: "+txt_file + " docs");

        String[] docs = txt_file.split("///");
        //String[] line = docs[0].split("^[0-9]{6}$");




        *//*for (String doc : docs){
            String[] line = doc.split("\n");
            StringBuilder sb = new StringBuilder();
            String txtList[] = new String[2];
            for (String text : line) {
                if(text.matches("^[0-9]{6}$")){
                    txtList[0] = text;
                    //System.out.println(text);
                }else {
                    sb.append(text);
                }
            }
            txtList[1] = sb.toString();
            System.out.println(txtList[1]);
        }*//*


        //System.out.println(docs[2]);
       *//* for(int i=0; i<docs.length; i++){
            String[] line = docs[i].split("\n");
            //List<String> itemList = Arrays.asList(line);
            List<String> itemList = new ArrayList<String>(Arrays.asList(line));
            System.out.println("el 1 "+itemList.get(0));

            itemList.remove(0);
            System.out.println("el 2 "+itemList.get(0));
            //System.out.println(itemList.toString());


            if(i == 0){
                itemList.remove(0);
                MyDoc mydoc = new MyDoc(line[0],itemList.toString());
                //System.out.println(itemList.toString());
            }else {
                itemList.remove(0);
                MyDoc mydoc = new MyDoc(line[1],itemList.toString());
                //System.out.println(mydoc);
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

    public static List<MyDoc> parse2(String file) throws Exception {
        try{
            //Parse txt file
            String txt_file = IO.ReadEntireFileIntoAString(file);

            String[] docs = txt_file.split("///");
            System.out.println("lenght "+docs.length);
            //Parse each document from the txt file
            List<MyDoc> parsed_docs= new ArrayList<MyDoc>();

            for (String doc : docs){
                String[] line = doc.split("\n");
                StringBuilder sb = new StringBuilder();
               // String txtList[] = new String[2];
                String title = "";
                //String text = "";
                for (String txt : line) {
                    if(txt.matches("^[0-9]{6}$")){
                        title = txt;
                        //System.out.println(text);
                    }else {
                        sb.append(txt);
                    }
                }
                //txtList[1] = sb.toString();

                MyDoc mydoc = new MyDoc(title,sb.toString());
                parsed_docs.add(mydoc);
                //System.out.println(mydoc.getCaption());
            }


          /*  for(int i=0; i<docs.length; i++){
                String[] line = docs[i].split("\n");
                List<String> itemList = new ArrayList<String>(Arrays.asList(line));


                if(i == 0){
                    itemList.remove(0);
                    MyDoc mydoc = new MyDoc(line[0],itemList.toString());
                    //System.out.println("CAPTION :"+itemList.toString());

                    parsed_docs.add(mydoc);
                }else {
                    itemList.remove(0);
                    itemList.remove(0);
                    //System.out.println("CAPTION :"+itemList.get(1));
                    //itemList.remove(0);
                    MyDoc mydoc = new MyDoc(line[1],itemList.toString());
                    //System.out.println(line[1]);
                    parsed_docs.add(mydoc);
                }
            }*/

            return parsed_docs;
        } catch (Throwable err) {
            err.printStackTrace();
            return null;
        }

    }


    public static List<MyDoc> parse(String file) throws Exception {
        try{
            //Parse txt file
            String txt_file = IO.ReadEntireFileIntoAString(file);

            String[] docs = txt_file.split("///");

            //Parse each document from the txt file
            List<MyDoc> parsed_docs= new ArrayList<MyDoc>();

            for(int i=0; i<docs.length; i++){
                String[] line = docs[i].split("\n");
                List<String> itemList = new ArrayList<String>(Arrays.asList(line));


                if(i == 0){
                    itemList.remove(0);
                    MyDoc mydoc = new MyDoc(line[0],itemList.toString());
                    //System.out.println("CAPTION :"+itemList.toString());

                    parsed_docs.add(mydoc);
                }else {
                    itemList.remove(0);
                    itemList.remove(0);
                    //System.out.println("CAPTION :"+itemList.get(1));
                    //itemList.remove(0);
                    MyDoc mydoc = new MyDoc(line[1],itemList.toString());
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
