/**
 * Description of CodonCount *
 * 
 * CodonCount is a program used to :
 *
 * Display all codons and their counts in a file for each of the starting postitions : 0, 1 and 2. 
 * Display most common codon and its number of occurences each time.
 * Display all codons that occur within a specified range.
 *  
 **/


import edu.duke.*;
import java.util.*;

public class CodonCount
{
    private HashMap<String,Integer> map;
    private int count;
    
    public CodonCount()
    {
        map = new HashMap<String,Integer>();
    }
    
    public int buildCodonMap(int start, String dna)
    {
        count=0;
        map.clear();
        String s = "";
        for(int i=start; i < dna.length() ; i+=3)
        {
            if((i+3) >= dna.length())
            {
                break;
            }
            s = dna.substring(i,i+3);
            if (! map.containsKey(s))
            {
                if(s.length()==3)
                {
                    map.put(s,1);
                    count++;
                }
            }
            else
            {
                map.put(s,map.get(s)+1);
            }
        }
        return count;
    }
    
    public String getMostCommonCodon()
    {
        int max=0,val=0;
        String s="";
        for(String key : map.keySet())
        {
            val=map.get(key);
            if(val > max)
            {
                max = val;
                s=key;
            }
        }
        return s;
    }
    
    public void printCodonCounts(int start, int end)
    {
        int val=0;
        for(String key : map.keySet())
        {
            val=map.get(key);
            if( val >= start && val <= end)
            {
                String s = key;
                System.out.println("\nCodon = "+s+"\tCount = "+val);
            }
        }
    }
    
    public void tester()
    {
        int n,a,b;
        int index = 0;
        String s = "";
        FileResource fr = new FileResource();
        String contents = fr.asString();
        contents = contents.toUpperCase();
        for(int i=0; i < 3; i++)
        {
            n = buildCodonMap(i,contents);
            System.out.println("Reading frame starting with "+ i +" results in "+ n +" unique codons");
            s = getMostCommonCodon();
            index = map.get(s);
            System.out.println("and most common codon is "+ s +" with count " + index);
            a=1;
            b=5;
            System.out.println("Counts of codons between "+ a +" and "+ b +" inclusive are:");
            printCodonCounts(5,8);
        }
	}
	
	public void main()
	{
		CodonCount obj = new CodonCount();
		obj.tester();
	}
}	