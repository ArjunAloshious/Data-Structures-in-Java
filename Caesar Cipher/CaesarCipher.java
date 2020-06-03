/**
 * Description of CaesarCipher *
 * 
 * CaesarCipher is a program used to :
 *
 * Encrypt a file's entire content with the help of a given key, while preserving all spaces, capitalizations and punctuations.
 * Decrypt this newly encrypted string by using the same encrypt() method, after passing (26-key) as the value of key.
 * Encrypt a file's entire content with the help of two given keys, while preserving all spaces, capitalizations and punctuations.
 * Find the key of an encrypted message and decrypt it with the help of this key obtained, with the assumption that 'e' is the most
 *   frequently occuring letter in the original message.
 *
 **/

import edu.duke.*;

public class CaesarCipher
{
    public String encrypt(String input, int key)
    {
        StringBuilder encrypted = new StringBuilder(input);
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        
        String upperShiftedAlphabet = upperAlphabet.substring(key) + upperAlphabet.substring(0,key);
        String lowerShiftedAlphabet = lowerAlphabet.substring(key) + lowerAlphabet.substring(0,key);
        
        for(int i=0; i<encrypted.length(); i++)
        {
            char currChar = encrypted.charAt(i);
            if(Character.isUpperCase(currChar))
            {
                int Uindx = upperAlphabet.indexOf(currChar);
                if (Uindx!=-1)
                {
                    char newChar = upperShiftedAlphabet.charAt(Uindx);
                    encrypted.setCharAt(i, newChar);
                }
            }
            else if(Character.isLowerCase(currChar))
            {
                int Lindx = lowerAlphabet.indexOf(currChar);
                if (Lindx!=-1)
                {
            
                    char newChar = lowerShiftedAlphabet.charAt(Lindx);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }
    
    public String encryptTwoKeys(String input, int key1, int key2)
    {
        StringBuilder encrypted = new StringBuilder(input);
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        
        String upperShiftedAlphabetKey1 = upperAlphabet.substring(key1) + upperAlphabet.substring(0,key1);
        String lowerShiftedAlphabetKey1 = lowerAlphabet.substring(key1) + lowerAlphabet.substring(0,key1);
        
        String upperShiftedAlphabetKey2 = upperAlphabet.substring(key2) + upperAlphabet.substring(0,key2);
        String lowerShiftedAlphabetKey2 = lowerAlphabet.substring(key2) + lowerAlphabet.substring(0,key2);
        
        for(int i=0; i<encrypted.length(); i+=2)
        {
            char currChar = encrypted.charAt(i);
            if(Character.isUpperCase(currChar))
            {
                int Uindx = upperAlphabet.indexOf(currChar);
                if (Uindx!=-1)
                {
                    char newChar = upperShiftedAlphabetKey1.charAt(Uindx);
                    encrypted.setCharAt(i, newChar);
                }
            }
            else if(Character.isLowerCase(currChar))
            {
                int Lindx = lowerAlphabet.indexOf(currChar);
                if (Lindx!=-1)
                {
            
                    char newChar = lowerShiftedAlphabetKey1.charAt(Lindx);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        
        for(int i=1; i<encrypted.length(); i+=2)
        {
            char currChar = encrypted.charAt(i);
            if(Character.isUpperCase(currChar))
            {
                int Uindx = upperAlphabet.indexOf(currChar);
                if (Uindx!=-1)
                {
                    char newChar = upperShiftedAlphabetKey2.charAt(Uindx);
                    encrypted.setCharAt(i, newChar);
                }
            }
            else if(Character.isLowerCase(currChar))
            {
                int Lindx = lowerAlphabet.indexOf(currChar);
                if (Lindx!=-1)
                {
            
                    char newChar = lowerShiftedAlphabetKey2.charAt(Lindx);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }
    
    public int[] countLetters(String message)
    {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k=0; k < message.length() ; k++)
        {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if(dex != -1)
            {
                counts[dex]+=1;
            }
        }
        return counts;
    }

    public String decrypt(String encrypted)
    {
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxDex(freqs);
        int dkey = maxDex - 4;
        if( maxDex < 4 )
        {
            dkey = 26 - (4-maxDex);
        }
        return cc.encrypt(encrypted, 26-dkey);
    }

    public int maxDex(int[] vals)
    {
        int maxDex = 0;
        for(int k=0; k < vals.length; k++)
        {
            if(vals[k] > vals[maxDex])
            {
                maxDex=k;
            }
        }
        return maxDex;
    }
    
    public void main()
    {
        int key=15;
        FileResource fr = new FileResource();
        String message = fr.asString();
        
        String encrypted = encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?", key);			// Single key encryption
        System.out.println(encrypted);
        
        String decrypted = encrypt(encrypted, 26-key);																		// Single key decryption by 
        System.out.println(decrypted);																						// using same encrypt() method
        
        String s = encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?", 21, 8);		// Two-key encryption
        System.out.println("\nGiven string is : Can you imagine life WITHOUT the internet AND computers in your pocket?");
        System.out.println("\nResult after two-key encryption is : " + s);
        
        String encrypted2 = encrypt("The frequency of letters at the beginning of words is different again.", 20);			// Decryption by finding the key
        System.out.println("\n"+encrypted2);																				// with the assumption that 'e' is
        String s2 = decrypt(encrypted2);																					// the most frequently occuring
        System.out.println("Obtained Result = " + s2);																		// letter in the original mesage
    }
}