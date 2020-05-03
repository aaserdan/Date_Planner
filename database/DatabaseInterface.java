package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Provides a way to write in a file as well as reading from it
 *
 * @author Arturo Last updated 4/1/2020
 */
public interface DatabaseInterface {

    // Used to keep track of the UUIDs and store them
    static Stack<String> stack = new Stack<String>();

    // Number of the UUIDs
    static int fileSize = 0;
    static int iterator = 0;

    /**
     * Writes in elements on a file, writing a coma to separate different
     * information Provides a UUID to keep track of elements written
     *
     * @param _array elements coming in to be written
     * @param _file file where the information will be stored
     */
    void writeIn(String[] _array, File _file);

    /**
     * Reads the entire file and puts the content on a String to be returned
     *
     * @param _file file to be read from
     * @return fullFile String that contains the data from file
     * @throws FileNotFoundException
     * @throws IOException
     */
    String readFile(File _file) throws FileNotFoundException, IOException;

    /**
     * Finds the data in a file based on the UUID, returns a string containing
     * the data
     *
     * @param _file file to be read from
     * @param _uuid UUID String
     * @return element Returns the data contained at the location of the UUID
     * @throws FileNotFoundException
     * @throws IOException
     */
    String findText(File _file, String _uuid) throws FileNotFoundException, IOException;

    /**
     * Reads and saves all the UUIDs contained on a file, adds them to
     * ReadInFile.stack, and returns the number of UUIDs/elements found If file
     * is empty returns 0
     *
     * @param _file the file where the size will be read from
     * @return ReadInFile.fileSize with the size from the ReadInFile.stack
     * @throws IOException
     */
    int getSizFile(File _file) throws IOException;

    /**
     * Gets the last "x" number of elements from a file, and returns them on an
     * Array String
     *
     * @param _file the file that is be read from
     * @param _numElmtsReturn number of elements to be returned
     * @return elmtsInFile Array String with the elements from the file
     * @throws IOException
     */
    String[] getLastElements(File _file, int _numElmtsReturn) throws IOException;

    /**
     * Finds the last "x" number of UUIDs on the file
     *
     * @param _numElmtsReturn number of elements to be returned
     * @return elementsReturned Array string containing the last "x" number of
     * UUIDS from the file
     */
    String[] getLastUUID(File _file, int _numUUIDsReturn) throws IOException;

    /**
     * This method will search by a key element in the File, and return all the
     * UUIDs that match the key in an Array String
     *
     * @param _file
     * @param _keyString
     * @return mathchesFound with the UUIDs found to match the elements
     * @throws FileNotFoundException
     * @throws IOException
     */
    String[] findbyKeyInFile(File _file, String _keyString) throws FileNotFoundException, IOException;

    /**
     * This method creates a temporal file, then passes all the data from the
     * original file to the temporary file except for the element that is wished
     * to be deleted, then deletes the "original" and renames the temporary as
     * the original.
     *
     * @param _file the file from which an element will be deleted
     * @param _UUID UUID String
     * @throws IOException
     */
    void removeRecordByUUID(File _file, String _UUID) throws IOException;

    /**
     * This method updates a element given a file, a UUID, and a Array String
     * containing the new data
     *
     * @param _file File to be updated
     * @param _UUID UUID of the element/data to be changed
     * @param _data New data that will be placed
     * @throws IOException
     */
    public void updateElement(File _file, String _UUID, String[] _data) throws IOException;

    /**
     * Method to create a new text file given a file name, it will create file
     * in the Database package
     *
     * @param _fileName Name of the file, no need of ".txt"
     * @return true if file created, else false
     */
    public boolean makeNewFile(String _fileName);
}

