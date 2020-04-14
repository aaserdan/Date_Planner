package database;

/**
 * Provides a way to write and read from a file
 *
 * @author Arturo Last updated 4/13/2020
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public interface DatabaseInterface {

    // Used to keep track of the UUIDs and store them
    static Stack<String> stack = new Stack<String>();
    
    // Number of the UUIDs
    static int fileSize = 0;
    static int iterator = 0;
    
    /**
     * Writes in elements on a file, writing a coma to separate different information
     * Provides a UUID to keep track of elements written
     * @param _array elements coming in to be written
     * @param _file file where the information will be stored
     */
    void writeIn(String [] _array, File _file);

    /**
     * Reads the entire file and puts the content on a String to be returned
     * @param _file file to be read from
     * @return fullFile String that contains the data from file
     * @throws FileNotFoundException
     * @throws IOException 
     */
    String readFile(File _file) throws FileNotFoundException, IOException;
    
    /**
     * Finds the data in a file based on the UUID, returns a string containing the data
     * @param _file file to be read from
     * @param _uuid UUID String 
     * @return element Returns the data contained at the location of the UUID
     * @throws FileNotFoundException
     * @throws IOException 
     */
    String findText(File _file, String _uuid) throws FileNotFoundException, IOException;
    
    /**
     * Reads and saves all the UUIDs contained on a file, adds them to ReadInFile.stack, and returns the number of UUIDs/elements found
     * If file is empty returns 0
     * @param _file the file where the size will be read from
     * @return ReadInFile.fileSize with the size from the ReadInFile.stack
     * @throws IOException 
     */
    int getSizFile(File _file) throws IOException; 
     
    /**
     * Gets the last "x" number of elements from a file, and returns them on an Array String
     * @param _file the file that is be read from
     * @param _numElmtsReturn number of elements to be returned
     * @return elmtsInFile Array String with the elements from the file
     * @throws IOException 
     */
    String [] getLastElements(File _file, int _numElmtsReturn) throws IOException;
    
    /**
     * Finds the last "x" number of UUIDs on the file
     * @param _numElmtsReturn number of elements to be returned
     * @return elementsReturned Array string containing the last "x" number of UUIDS from the file 
     */
    String [] getLastUUID(File _file, int _numUUIDsReturn) throws IOException;
    
    // -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Methods and elements needed to generate a UUID for the Database to use
    
    // Characters to be used on to generate the UUID
    final char[] sourceCharacters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z', '0','1','2','3','4','5','6','7','8','9'};
    
    // UUID parts dived by number of characters
    final int timeLow = 8;
    final int timeMid = 4;
    final int timeHiAndVersion = 4;
    final int clockSeqHiAndResClockSeqLow = 4;
    final int node =12;
    
    /**
     * Generates a UUID 
     * @return UUIDreturned String returned containing the UUID
     */
    String generateUUID();
    
    /**
     * Generates the random parts of the UUID
     * @param strLength length of the String to be created
     * @return randomString randomString to be returned
     */
    String getRandomString(int strLength);
    
    /**
     * Returns a random character from the list of characters
     * @return the random character
     */
    public static char getRandomChar() {
        int rand = ThreadLocalRandom.current().nextInt(0,DatabaseInterface.sourceCharacters.length);        
        char chrReturned = DatabaseInterface.sourceCharacters[rand];
        return chrReturned;
    }
}
