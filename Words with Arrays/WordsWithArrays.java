/**
 * Description of WordsWithArrays *
 * 
 * WordsWithArrays is a program used to :
 *
 * Display total count of all words in a file by using Arrays to store the word and store word counts.
 * Display count of all words that occur in the file.
 * 
 **/


import java.util.*;
import edu.duke.*;

public class WordsWithArrays
{    
    StorageResource myWords;
    public WordsWithArrays()
	{
        myWords = new StorageResource();
    }
	
    public void readWords()
	{
        myWords.clear();
        FileResource resource = new FileResource();
        for(String word : resource.words())
		{
            myWords.add(word.toLowerCase());
        }
    }
    
    public boolean contains(String[] list, String word, int numStored)
	{
        for(int k=0; k < numStored; k++)
		{
            if (list[k].equals(word))
			{
                return true;
            }
        }
        return false;
    }
    
    public int countDifferentArray()
	{
        int numStored = 0;
        String[] words = new String[ myWords.size() ];
        for( String s : myWords.data() )
		{
             if (! contains(words,s, numStored))
			 {
                 words[numStored] = s;
                 numStored++;
             }
        }
        return numStored;
    }
    
    public void tester()
	{
        readWords();
        System.out.println("Number of words read : " + myWords.size());
        int unique = countDifferentArray();
        System.out.println("Array Count  = " + unique);
    }
	
	public void main()
	{
		WordsWithArrays obj = new WordsWithArrays();
		obj.tester();
	}
}