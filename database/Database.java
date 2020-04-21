package database;

/**
 * The class contains all necessary methods to be able to write and read from a given file
 * Contains UUID methods to maintain an order within the file
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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database implements DatabaseInterface {

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
    @Override
    public void writeIn(String [] _array, File _file){
        String newSpace = "\n";
        String coma = ",";
        FileWriter writer;
        try {
            writer = new FileWriter(_file, true);
        // Creates a new instance for generateUUID() method
        Database guuid = new Database();
        writer.write(guuid.generateUUID() + " :");
        for(int i =0; i<_array.length; i++){

            if(i==(_array.length-1)){
            writer.write(_array[i]);
            }
            else{
            writer.write(_array[i]);
            writer.write(coma);
            }
         
        }
        writer.write(newSpace);
        writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Reads the entire file and puts the content on a String to be returned
     * @param _file file to be read from
     * @return fullFile String that contains the data from file
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public String readFile(File _file) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(_file));
        String st;
        String fullFile = "";
        while ((st = br.readLine()) != null) {
            fullFile += st;
        }
        return fullFile;
    }

    /**
     * Finds the data in a file based on the UUID, returns a string containing the data
     * @param _file file to be read from
     * @param _uuid UUID String
     * @return element Returns the data contained at the location of the UUID
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public String findText(File _file, String _uuid) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(_file));
        String st;
        String element = "";
        while ((st = br.readLine()) != null) {
            if(st.contains((CharSequence) _uuid)){
             element = st;
            }
        }
        return element;
    }
    /**
     * Reads and saves all the UUIDs contained on a file, adds them to ReadInFile.stack, and returns the number of UUIDs/elements found
     * If file is empty returns 0
     * @param _file the file where the size will be read from
     * @return ReadInFile.fileSize with the size from the ReadInFile.stack
     * @throws IOException
     */
    @Override
    public int getSizFile(File _file) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(_file));
        String st;
        int count = 0;
        int empty = 0;
        String temp = "";
        char space = ' ';
        int i=0;
        int x =0;
        // Checks if its empty
        if((st = br.readLine()) == null){
            return empty;
        }
        // Moves the UUIDs from the file into a stack
        while ((st = br.readLine()) != null) {
            i = 0;
            temp = "";
            while(st.charAt(i) != space){
            temp += Character.toString(st.charAt(i));
            i++;
            }
            Database.stack.add(temp);
            x++;
        }
        // Gives value to final size
        Database.fileSize = Database.stack.size();
        return Database.fileSize;
    }

    /**
     * Gets the last "x" number of elements from a file, and returns them on an Array String
     * @param _file the file that is be read from
     * @param _numElmtsReturn number of elements to be returned
     * @return elmtsInFile Array String with the elements from the file
     * @throws IOException
     */
    @Override
    public String [] getLastElements(File _file, int _numElmtsReturn) throws IOException{
        String [] elmtsInFile = new String [_numElmtsReturn];
        // Creates a new instance for to generate getLastUUID() method
        Database uuid = new Database();
        String [] UUIDs = uuid.getLastUUID(_file, _numElmtsReturn);

        for(int i =0; i<_numElmtsReturn; i++){
            elmtsInFile[i] = uuid.findText(_file, UUIDs[i]);
        }
        return elmtsInFile;
    }

    /**
     * Finds the last "x" number of UUIDs on the file
     * @param _numElmtsReturn number of elements to be returned
     * @return elementsReturned Array string containing the last "x" number of UUIDS from the file
     */
    @Override
    public String [] getLastUUID(File _file, int _numUUIDsReturn) throws IOException{
        String [] UUIDs = new String [_numUUIDsReturn];
        // Creates a new instance for the getRandomChar() method
        Database gsf = new Database();
        Database.iterator = (gsf.getSizFile(_file)-1);
        int i = 0;
        while(i < _numUUIDsReturn){
            //brings the element on the iterator- i, and adds it to the array string
            UUIDs[i]= Database.stack.get(Database.iterator-i);
        i++;
        }

        return UUIDs;
    }

    // Characters to be used on to generate the UUID
    private final char[] sourceCharacters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z', '0','1','2','3','4','5','6','7','8','9'};

    // UUID parts dived by number of characters
    private final int timeLow = 8;
    private final int timeMid = 4;
    private final int timeHiAndVersion = 4;
    private final int clockSeqHiAndResClockSeqLow = 4;
    private final int node =12;

    /**
     * Generates a UUID
     * @return UUIDreturned String returned containing the UUID
     */
    @Override
    public String generateUUID(){
        String UUIDReturned = "";
        // Creates a new instance for the getRandomString() method
        Database grs = new Database();
        UUIDReturned += grs.getRandomString(timeLow) + "-";
        UUIDReturned += grs.getRandomString(timeMid) + "-";
        UUIDReturned += grs.getRandomString(timeHiAndVersion) + "-";
        UUIDReturned += grs.getRandomString(clockSeqHiAndResClockSeqLow) + "-";
        UUIDReturned += grs.getRandomString(node);
        return UUIDReturned;
    }

    /**
     * Generates the random parts of the UUID
     * @param strLength length of the String to be created
     * @return randomString randomString to be returned
     */
    @Override
    public String getRandomString(int strLength) {
        String randomString = "";
        for (int i = 0; i < strLength; i++) {
            // Creates a new instance for the getRandomChar() method
            Database grc = new Database();
            randomString+= grc.getRandomChar();
        }
        return randomString;
    }

    /**
     * Returns a random character from the list of characters
     * @return the random character
     */
    public char getRandomChar() {
        int rand = ThreadLocalRandom.current().nextInt(0,DatabaseInterface.sourceCharacters.length);
        char chrReturned = DatabaseInterface.sourceCharacters[rand];
        return chrReturned;
    }
}
