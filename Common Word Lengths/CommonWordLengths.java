/**
 * Description of CommonWordLengths*
 * 
 * CommonWordLengths is a program used to :
 *
 * Read all words in a file and take their lengths after excluding special characters on a word's initial or final positions, or both.
 * Find the most common word length among all retrieved word lengths.
 * Display the lengths obtained, the words of each length and the most common word length found.
 *
 **/
 
import edu.duke.*;
import java.lang.*;

public class CommonWordLengths
{
	public void countWordLengths(FileResource res, int[] counts) 
	{
		String[] commonwords = new String[35];
		int len=0;
		boolean b; 
		for(String word : res.words())
		{
			len=word.length();
			if( len == 1 && !(Character.isLetter(word.charAt(0))))				// if the word is a single special character symbol and not a single letter
			{
				continue;
			}
			if(len > 30)														// if word length is greater than array length
			{
				counts[31]++;
				commonwords[31] = commonwords[31] + "     " + word;
				continue;
			}
			if( !(Character.isLetter(word.charAt(0))) )							// if first character of string is a special character
			{
				if( !(Character.isLetter(word.charAt(len-1))) )					// if last character of string is a special character  -> AND condition
				{
					counts[len-2]++;
					word = word.substring(1, len - 1);
					commonwords[len-2] = commonwords[len-2] + "     " + word;
				}
				counts[len-1]++;												//  -> ELSE condition of first 'if'
				word = word.substring(1, len);
				commonwords[len-1] = commonwords[len-1] + "     " + word;
			}
			if( !(Character.isLetter(word.charAt(len-1))) )						// if last character of string is a special character
			{
				counts[len-1]++;
				word = word.substring(0, len - 1);
				commonwords[len-1] = commonwords[len-1] + "     " + word;
			}
			else																// if the word doesn't start or end with special characters
			{
				counts[len]++;
				commonwords[len] = commonwords[len] + "     " + word;
			}
		}
		for(int i=1; i < 32 ; i++)
		{
			if(counts[i] != 0)
			{
				System.out.println("Number of words of length " + i + " = " + counts[i]);
				System.out.println(commonwords[i]);
			}
		}
	}
	
	public int indexOfMax(int[] values)
	{
		int max=0,index=0;
		int len = values.length;
		for(int i=0 ; i < len ; i++)
		{
			if (values[i] > max)
			{
				max = values[i];
				index = i;
			}
		}
		return index;
	}
	
	public void testCountWordLengths()
	{
		FileResource fr = new FileResource();
		int[] counts = new int[32];
		countWordLengths(fr, counts);
		int index = indexOfMax(counts);
		System.out.println("Most common word length is = " + index);
	}
	
	public void main()
	{
		CommonWordLengths obj = new CommonWordLengths();
		obj.testCountWordLengths();
	}
}