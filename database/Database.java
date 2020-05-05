package database;

/**
 * The class contains all necessary methods to be able to write, read, edit, and
 * delete data from an Array string, as well as creating a file
 *
 * @author Arturo Last updated May 2, 2020
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database implements DatabaseInterface {

    // Used to keep track of the UUIDs and store them
    static Stack<String> stack = new Stack<String>();

    // Scanner Used by the Deleting method
    static Scanner scanner;

    // Number of the UUIDs
    static int fileSize = 0;
    static int iterator = 0;

    /**
     * Used to by the write in method
     */
    public static final String initialSeparator = " :";
    public static final String newSpace = "\n";
    public static final String separator = "-*;+*+;*-";

    // Error messages
    static final String GenError = "An Error Occurred!";
    static final String FileNotFound = "File Not Found!";

    /**
     * Writes in elements on a file, writing a coma to separate different
     * information Provides a UUID to keep track of elements written
     *
     * @param _array elements coming in to be written
     * @param _file file where the information will be stored
     */
    @Override
    public void writeIn(String[] _array, File _file) {
        if (_file.exists() == false) {
            System.out.println("File does not exists!");
            return;
        }
        FileWriter writer;
        try {
            writer = new FileWriter(_file, true);
            writer.write(UUID.generateUUID() + Database.initialSeparator);
            for (int i = 0; i < _array.length; i++) {

                if (i == (_array.length - 1)) {
                    writer.write(_array[i]);
                } else {
                    writer.write(_array[i]);
                    writer.write(Database.separator);
                }

            }
            writer.write(Database.newSpace);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //----------------------------- Read Methods-----------------------------------------------

    /**
     * Reads the entire file and puts the content on a String to be returned
     *
     * @param _file file to be read from
     * @return fullFile String that contains the data from file
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public String readFile(File _file) {
        BufferedReader br = null;
        String fullFile = "";
        String st;
        try {
            br = new BufferedReader(new FileReader(_file));
            while ((st = br.readLine()) != null) {
                fullFile += st;
            }
            br.close();
        } catch (Exception ex) {
            System.out.println(Database.FileNotFound);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fullFile;
    }

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
    @Override
    public String findText(File _file, String _uuid) {
        String st;
        String element = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(_file));
            while ((st = br.readLine()) != null) {
                if (st.contains((CharSequence) _uuid)) {
                    element = st;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(Database.FileNotFound);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            System.out.println(Database.GenError);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
        return element;
    }

    /**
     * Reads and saves all the UUIDs contained on a file, adds them to
     * ReadInFile.stack, and returns the number of UUIDs/elements found If file
     * is empty returns 0
     *
     * @param _file the file where the size will be read from
     * @return ReadInFile.fileSize with the size from the ReadInFile.stack
     * @throws IOException
     */
    @Override
    public int getSizFile(File _file) {
        Database.stack.clear();
        String st;
        int count = 0;
        int empty = 0;
        String temp = "";
        char space = ' ';
        int i = 0;
        int x = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(_file));
            // Moves the UUIDs from the file into a stack
            while ((st = br.readLine()) != null) {
                i = 0;
                temp = "";
                while (st.charAt(i) != space) {
                    temp += Character.toString(st.charAt(i));
                    i++;
                }
                Database.stack.add(temp);
                x++;
            }
            // Gives value to final size
            Database.fileSize = Database.stack.size();
        } catch (IOException e) {
            System.out.println(Database.GenError);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);

        }
        return Database.fileSize;
    }

    /**
     * Gets the last "x" number of elements from a file, and returns them on an
     * Array String
     *
     * @param _file the file that is be read from
     * @param _numElmtsReturn number of elements to be returned
     * @return elmtsInFile Array String with the elements from the file
     * @throws IOException
     */
    @Override
    public String[] getLastElements(File _file, int _numElmtsReturn) {
        String[] elmtsInFile = new String[_numElmtsReturn];
        // Creates a new instance for to generate getLastUUID() method
        Database uuid = new Database();
        try {
            String[] UUIDs = uuid.getLastUUID(_file, _numElmtsReturn);

            for (int i = 0; i < _numElmtsReturn; i++) {
                elmtsInFile[i] = uuid.findText(_file, UUIDs[i]);
            }
        } catch (Exception e) {
            System.out.println(Database.GenError);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
        return elmtsInFile;
    }

    /**
     * Finds the last "x" number of UUIDs on the file
     *
     * @param _numElmtsReturn number of elements to be returned
     * @return elementsReturned Array string containing the last "x" number of
     * UUIDS from the file
     */
    @Override
    public String[] getLastUUID(File _file, int _numUUIDsReturn) {
        String[] UUIDs = new String[_numUUIDsReturn];
        // Creates a new instance for the getRandomChar() method
        Database gsf = new Database();
        try {
            Database.iterator = (gsf.getSizFile(_file) - 1);

            int i = 0;
            while (i < _numUUIDsReturn) {
                //brings the element on the iterator- i, and adds it to the array string
                UUIDs[i] = Database.stack.get(Database.iterator - i);
                i++;
            }
        } catch (Exception ex) {
            System.out.println(Database.GenError);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return UUIDs;
    }
    //---------------------------------- Deleting methods -----------------------------------------------------

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
    public void removeRecordByUUID(File _file, String _UUID) {
        // Gets the full file path of the original file
        String filePath = _file.getPath();
        // Generates the necesay path for a temporary file in database package
        String fileName = "temp.txt";
        String wkgDirectory = System.getProperty("user.dir") + File.separator + "src" + File.separator + "Database";
        String tempFilePath = wkgDirectory + File.separator + fileName;
        // Creates the new files accoridingly
        File oldFile = new File(filePath);
        File newFile = new File(tempFilePath);
        String UUID = "";
        try {

            // Creates a writer and a printWriter to write in the temporary new file version
            FileWriter fileWriter = new FileWriter(tempFilePath, true);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufWriter);
            scanner = new Scanner(new File(filePath));
            boolean deleted = false;
            /*
        Scans through the original file, when if finds the UUID to be deleted it does not write it
        in new file and changes deleted boolean value to true; else the deleted stays false.
             */
            while (scanner.hasNext()) {
                UUID = scanner.nextLine();
                if (!UUID.contains(_UUID)) {
                    printWriter.println(UUID);
                }
                if (UUID.contains(_UUID)) {
                    deleted = true;
                }
            }
            // Closes all the used classes to scanne and write
            scanner.close();
            printWriter.flush();
            printWriter.close();
            bufWriter.close();
            fileWriter.close();
            // Creates a new instance of clearFile method, and another instance of copyElementsInFile method
            Database clearFile = new Database();
            Database copyElementsInFile = new Database();
            /*
            Clears the original incoming file data, then copies the data from the temporary file back into the
            original file, then clears out the temporary file for reuse.
             */
            clearFile.clearFile(oldFile);
            copyElementsInFile.copyElementsInFile(newFile, oldFile);
            clearFile.clearFile(newFile);
            // Prints out whether or not it deleted
            if (deleted == false) {
                System.out.println("Element not found!");
            } else {
                System.out.println("Deleted Completed!");
            }
        } catch (FileNotFoundException e) {
            System.out.println(Database.FileNotFound);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            System.out.println(Database.GenError);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * This method clears out all the data existing in a file
     *
     * @param _file the file that will be cleared out
     * @throws IOException
     */
    public void clearFile(File _file) {
        try {
            Formatter formatter = new Formatter(_file.getCanonicalFile());
            scanner = new Scanner(new File(_file.getCanonicalPath()));
            // Will scan each line and format it
            while (scanner.hasNext()) {
                formatter.format(" ");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(Database.FileNotFound);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            System.out.println(Database.GenError);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * This method copies the data from _fileA file to an empty _fileB file
     *
     * @param _fileA file to be copy from
     * @param _fileB file where the information will be written on
     * @throws IOException
     */
    public void copyElementsInFile(File _fileA, File _fileB) {
        String data = "";
        try {
            // Creates a writer and a printWriter to write in the temporary new file version
            FileWriter fileWriter = new FileWriter(_fileB.getCanonicalPath(), true);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufWriter);
            scanner = new Scanner(new File(_fileA.getCanonicalPath()));
            /*
        Scans through _fileA file and writes the data into _fileB
             */
            while (scanner.hasNext()) {
                data = scanner.nextLine();
                printWriter.println(data);
            }
            // Closes all the used classes to scanne and write
            scanner.close();
            printWriter.flush();
            printWriter.close();
            bufWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(Database.FileNotFound);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            System.out.println(Database.GenError);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    //---------------------------------- Update a File methods -----------------------------------------------
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
    public String[] findbyKeyInFile(File _file, String _keyString) {
        String st;
        String[] matchesFound = null;
        // Creates a new instance to get the getSizeFile method
        Database getSizeFile = new Database();
        try {
            BufferedReader br = new BufferedReader(new FileReader(_file));
            int size = getSizeFile.getSizFile(_file);
            System.out.println(size);
            matchesFound = new String[size];
            String element = "";
            boolean check = false;
            int i = 0;
            while ((st = br.readLine()) != null) {
                if (st.contains((CharSequence) _keyString)) {
                    element = st;
                    matchesFound[i] = element;
                    i++;
                    check = true;
                }
            }

            if (check == false) {
                try {
                    throw new Exception("Element not found");
                } catch (Exception ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(Database.FileNotFound);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            System.out.println(Database.GenError);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
        return matchesFound;
    }

    /**
     * This method updates a element given a file, a UUID, and a Array String
     * containing the new data
     *
     * @param _file File to be updated
     * @param _UUID UUID of the element/data to be changed
     * @param _data New data that will be placed
     * @throws IOException
     */
    public void updateElement(File _file, String _UUID, String[] _data) {
        // Gets the full file path of the original file
        String filePath = _file.getPath();
        // Generates the necesay path for a temporary file in database package
        String fileName = "temp.txt";
        String wkgDirectory = System.getProperty("user.dir") + File.separator + "src" + File.separator + "Database";
        String tempFilePath = wkgDirectory + File.separator + fileName;
        // Creates the new files accoridingly
        File oldFile = new File(filePath);
        File newFile = new File(tempFilePath);
        //Strings to help writeIn the data
        String data = "";

        try {
            // Creates a writer and a printWriter to write in the temporary new file version
            FileWriter fileWriter = new FileWriter(tempFilePath, true);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufWriter);
            scanner = new Scanner(new File(filePath));
            boolean updated = false;
            /*
        Scans through the original file, when if finds the UUID to be deleted it does not write it
        in new file and changes deleted boolean value to true; else the deleted stays false.
             */
            while (scanner.hasNext()) {
                data = scanner.nextLine();
                if (!data.contains(_UUID)) {
                    printWriter.println(data);
                }
                if (data.contains(_UUID)) {
                    data = _UUID;
                    data += Database.initialSeparator;
                    for (int i = 0; i < _data.length; i++) {
                        if (i == (_data.length - 1)) {
                            data += _data[i];
                        } else {
                            data += _data[i] + Database.separator;
                        }
                    }
                    printWriter.println(data);
                    updated = true;
                }
            }
            // Closes all the used classes to scanne and write
            scanner.close();
            printWriter.flush();
            printWriter.close();
            bufWriter.close();
            fileWriter.close();
            // Creates a new instance of clearFile method, and another instance of copyElementsInFile method
            Database clearFile = new Database();
            Database copyElementsInFile = new Database();
            /*
        Clears the original incoming file data, then copies the data from the temporary file back into the
        original file, then clears out the temporary file for reuse.
             */
            clearFile.clearFile(oldFile);
            copyElementsInFile.copyElementsInFile(newFile, oldFile);
            clearFile.clearFile(newFile);
            // Prints out whether or not it updated
            if (updated == false) {
                System.out.println("Element not found!");
            } else {
                System.out.println("Update Completed!");
            }
        } catch (FileNotFoundException e) {
            System.out.println(Database.FileNotFound);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            System.out.println(Database.GenError);
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Method to create a new text file given a file name, it will create file
     * in the Database package
     *
     * @param _fileName Name of the file, no need of ".txt"
     * @return true if file created, else false
     */
    public boolean makeNewFile(String _fileName) {
        // Constructs the filePath
        String workingDirectory = System.getProperty("user.dir") + File.separator + "src" + File.separator + "Database";
        String filePath = workingDirectory + File.separator + _fileName + ".txt";
        File contactUsDatabase = new File(filePath);
        boolean created = false;
        try {
            if (contactUsDatabase.createNewFile()) {
                System.out.println("File created!");
                created = true;
            } else {
                System.out.println("File already exists!");
            }
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return created;
    }
}
