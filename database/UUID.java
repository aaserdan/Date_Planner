package database;

//package lecturea;

import java.util.concurrent.ThreadLocalRandom;
/**
 * The UUID class is used to create the UUID needed for the Database
 * Last updated May 2, 2020
 * @Author Arturo
 */
public class UUID {
    // Characters to be used on to generate the UUID
    private final static char[] sourceCharacters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z', '0','1','2','3','4','5','6','7','8','9'};
    
    // UUID parts dived by number of characters
    private final static int timeLow = 8;
    private final static int timeMid = 4;
    private final static int timeHiAndVersion = 4;
    private final static int clockSeqHiAndResClockSeqLow = 4;
    private final static int node =12;
    
    /**
     * Generates a UUID 
     * @return UUIDreturned String returned containing the UUID
     */
    public static String generateUUID(){
        String UUIDReturned = "";
        UUIDReturned += UUID.getRandomString(timeLow) + "-";
        UUIDReturned += UUID.getRandomString(timeMid) + "-";
        UUIDReturned += UUID.getRandomString(timeHiAndVersion) + "-";
        UUIDReturned += UUID.getRandomString(clockSeqHiAndResClockSeqLow) + "-";
        UUIDReturned += UUID.getRandomString(node);
        return UUIDReturned;
    }
    
    /**
     * Generates the random parts of the UUID
     * @param strLength length of the String to be created
     * @return randomString randomString to be returned
     */
    private static String getRandomString(int strLength) {
        String randomString = "";
        for (int i = 0; i < strLength; i++) {
            randomString+= UUID.getRandomChar();
        }
        return randomString;
    }
    
    /**
     * Returns a random character from the list of characters
     * @return the random character
     */
    private static char getRandomChar() {
        int rand = ThreadLocalRandom.current().nextInt(0,sourceCharacters.length);        
        return UUID.sourceCharacters[rand];
    }
    
}
