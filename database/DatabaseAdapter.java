package database;

/**
 * Database Adapter class used to make calls to the Database 
 * Last updated May 2, 2020
 * @Author Arturo
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
     * Finds the data in a file based on the UUID, returns a string containing the data
     * @param _file file to be read from
     * @param _uuid UUID String
     * @return element Returns the data contained at the location of the UUID
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String findText(File _file, String _uuid) throws FileNotFoundException, IOException{
        // String where the elements found will be stored
        String element = "";
        // Instanciates findText method from Database, then calls method in Database
        Database findText = new Database();
        element = findText.findText(_file, _uuid);
        return element;
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
    
    /**
     * This method creates a temporal file, then passes all the data from the original file to the temporary file
     * except for the element that is wished to be deleted, then deletes the "original" and renames the temporary as 
     * the original.
     * @param _file the file from which an element will be deleted
     * @param _UUID UUID String
     * @throws IOException 
     */
    public static void removeRecordByUUID(File _file, String _UUID) throws IOException{
        //Creates a new instance of removeRecordByUUID from Database class
        Database removeRecordByUUID = new Database();
        //Passes _file and _UUID to method in Database
        removeRecordByUUID.removeRecordByUUID(_file, _UUID);
    }
    
    /**
     * This method will search by a key element in the File, and return all the UUIDs that match the key
     * in an Array String
     * @param _file
     * @param _keyString
     * @return mathchesFound with the UUIDs found to match the elements
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static String [] findbyKeyInFile(File _file, String _keyString) throws FileNotFoundException, IOException{
        //Creates a new instance of findbyKeyInFile from Database class
        Database findbyKeyInFile = new Database();
        //Passes _file and _keyString to method in Database
        String [] foundMatches = findbyKeyInFile.findbyKeyInFile(_file, _keyString);
        return foundMatches;
    }
    
    /**
     * This method updates a element given a file, a UUID, and a Array String containing the new data
     * @param _file File to be updated
     * @param _UUID UUID of the element/data to be changed
     * @param _data New data that will be placed
     * @throws IOException 
     */
    public static void updateElement(File _file, String _UUID, String [] _data) throws IOException{
        //Creates a new instance of updateElement from Database class
        Database updateElement = new Database();
        //Passes _file, _UUID, _data to method in Database
        updateElement.updateElement(_file, _UUID, _data);
    }
    
    /**
     * Method to create a new text file given a file name, it will create file in the Database package
     * @param _fileName Name of the file, no need of ".txt" 
     * @return true if file created, else false
     */
    public static boolean makeNewFile(String _fileName){
        boolean response = false;
        // Creates an instance of makeNewFile method in Database
        Database makeNewFile = new Database();
        // Passes_fileName to method in database
        response = makeNewFile.makeNewFile(_fileName);
        return response;
    }
}
