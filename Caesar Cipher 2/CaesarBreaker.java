/**
 * Description of CaesarBreaker *
 * 
 * CaesarBreaker is a program used to :
 *
 * Decrypt a file encrypted with Caesar Cipher for two-key encryption by : 
 *   - Splitting the content into two strings of alternate characters and
 *   - Finding a key for each of the two strings assuming that 'e' is the most frequently occuring.
 * Finally, use the two keys on the two strings to decrypt the file content.
 *
 **/
 
 import edu.duke.*;

public class CaesarBreaker 
{
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
	
	public String halfOfString(String message, int start)
	{
		char ch;
		String newmessage = "";
		for(int i=start; i < message.length() ; i+=2)
		{
			ch = message.charAt(i);
			newmessage = newmessage + ch;
		}
		return newmessage;
	}
	
	public int getKey(String s)
	{
		int[] freqs = countLetters(s);
		int maxDex = maxDex(freqs);
		int dkey = maxDex - 4;
		if( maxDex < 4 )
        {
            dkey = 26 - (4-maxDex);
        }
		return dkey;
	}

	public void decryptTwoKeys(String encrypted)
	{
		String s1 = halfOfString(encrypted,0);
		String s2 = halfOfString(encrypted,1);
		int key1 = getKey(s1);
		int key2 = getKey(s2);
		System.out.println("Key 1 = " + key1 + "\tKey 2 = " + key2);
		CaesarCipher cc = new CaesarCipher();
		String message = cc.encryptTwoKeys(encrypted, (26-key1), (26-key2));
		System.out.println("Decrypted TWO-KEY Message = " + message);
	}
	
	public void main()
	{
		FileResource fr = new FileResource();
		String contents = fr.asString();
		CaesarBreaker obj = new CaesarBreaker;
		obj.decryptTwoKeys(contents);
	}
}