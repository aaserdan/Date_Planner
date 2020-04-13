package Database;

/**
 * Database Adapter class used to make calls to the Database 
 * Last updated April 13, 2020
 * @Author Arturo
 */

import java.io.File;
import java.io.IOException;

public class DatabaseAdapter {
    
    /**
     * Calls the writes from the Database class
     * @param _stringIn string passed to write in
     * @param _file file to where it data will be stored
     */
    public static void writeIn(String [] _stringIn, File _file){
        // Creates a new instance for the writer from Database class
        Database write = new Database();
        // Passes the Array String and the file location to the writer to be written
        write.writeIn(_stringIn, _file);
    }
    
    /**
     * Calls readFile from Database class
     * @param _file file to be read from
     * @return fullSize String containing all data from file
     * @throws IOException 
     */
    public static String readFile(File _file) throws IOException{
        String fullFile = "";
        // Creates a new instance of the readFile from Database class
        Database readFile = new Database();

        // Passes the file to read from
        fullFile = readFile.readFile(_file);
        return fullFile;
    }
    
    /**
     * Calls getSizeFile to get the number of elements in file
     * @param _file file to be read from 
     * @return size The size/elements of the file
     * @throws IOException 
     */
    public static int getSizeFile(File _file) throws IOException{
        int size;
        // Creates a new instance of the getSizeFile from Database class
        Database getSizeFile = new Database();

        // Passes the file to read from
        size = getSizeFile.getSizFile(_file);
        return size;
    }
    
    /**
     * Calls getLastElements to get the last "x" elements from file
     * @param _file Elements extracted from 
     * @param _numElmtsReturn Number of elements to return
     * @return elmtsInFile Array String with last data elements from file
     * @throws IOException 
     */
    public static String [] getLastElements(File _file, int _numElmtsReturn) throws IOException{
        String [] elmtsInFile = new String [_numElmtsReturn];
        //Creates a new instance of getLastElements from Database class
        Database getLastElement = new Database();
        //Passes _file and _numElmtsReturn to method in Database
        elmtsInFile = getLastElement.getLastElements(_file, _numElmtsReturn);
        return elmtsInFile;
    }
}
