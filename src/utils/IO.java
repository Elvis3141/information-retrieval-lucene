package utils;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Tonia Kyriakopoulou
 */
public class IO {

    /**
     * List all the files under a directory
     *
     * @param directoryName to be listed 
     * @return File[]
     */
    public static File[] listFiles(String directoryName) {

        File directory = new File(directoryName);

        //get all the files from a directory
        File[] fList = directory.listFiles();

        return fList;
    }

    /**
     * Reads entire file into a string
     *
     * @param file to be read 
     * @return String
     */    
    public static String ReadEntireFileIntoAString(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter("\\A"); //\\A stands for :start of a string
        String entireFileText = scanner.next();
        return entireFileText;
    }
    
    /**
     * Reads file line by line
     *
     * @param file to be read 
     * @return StringBuffer
     */   
    public static StringBuffer ReadFileIntoAStringLineByLine(String file) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line).append("\n");
        }
        return stringBuffer;
    }

    /**
     * Reads file char by char
     *
     * @param file to be read 
     * @return String
     */      
    public String ReadEntireFileIntoAStringCharByChar(String file) throws IOException {

        FileReader fileReader = new FileReader(file);

        String fileContents = "";

        int i;

        while ((i = fileReader.read()) != -1) {
            char ch = (char) i;

            fileContents = fileContents + ch;
        }
        return fileContents;
    }


    public static void WriteToFile(String text, String fileName) throws IOException {
        File file = new File(fileName);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        out.println(text);
        out.flush();
        out.close();
    }

    public static void WriteToFile(String text, String fileName1, String fileName2) throws IOException {
        String[] fileNames = {fileName1, fileName2};
        BufferedWriter writer = null;
        for (int i = 0; i < fileNames.length; i++) {

            writer = new BufferedWriter(new FileWriter(fileNames[i]));
            writer.write(text);
            writer.close();
        }
    }

}





















