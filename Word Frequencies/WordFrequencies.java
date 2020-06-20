/**
 * Description of WordFrequencies *
 * 
 * WordFrequencies is a program used to :
 *
 * Display number of unique words in a file.
 * Display the most frequently occuring word and its count.
 *
 **/

 
import edu.duke.*;
import java.util.ArrayList;

public class WordFrequencies
{
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies()
	{
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique()
	{
        FileResource resource = new FileResource();
        for(String s : resource.words())
		{
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index == -1)
			{
                myWords.add(s);
                myFreqs.add(1);
            }
            else
			{
                int freq = myFreqs.get(index);
                myFreqs.set(index,freq+1);
            }
        }
    }
    
	public int findMax()
	{
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for(int k=0; k < myFreqs.size(); k++)
		{
            if (myFreqs.get(k) > max)
			{
                max = myFreqs.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
	
    public void tester()
	{
        findUnique();
        System.out.println("Number of Unique Words = "+myWords.size());
		int index = findMax();
        System.out.println("The word that occurs most often and its count are : "+myWords.get(index)+" "+myFreqs.get(index));
    }
	
	public void main()
	{
		WordFrequencies ob = new WordFrequencies();
		ob.tester();
	}
}