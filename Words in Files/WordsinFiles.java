/**
 * Description of WordsinFiles *
 * 
 * WordsinFiles is a program used to :
 * 
 * Store all words in selected files as keys of a HashMap.
 * Store all filenames in which these words occur as values of the HashMap. (an ArrayList of String type for each key : word)
 * Display highest number of files in which any word appears, for a group of selected files.
 * Display the ArrayList of filenames and its length as count for the key (word) appearing in exactly 'n' files.
 * Display all files containing a particular word, that is, the ArrayList of names corresponding to a given word in a HashMap.
 *
 **/


import edu.duke.*;
import java.util.*;
import java.io.*;

public class WordsinFiles
{
	private HashMap<String,ArrayList<String>> map;
	public WordsinFiles()
	{
		map = new HashMap<String,ArrayList<String>>();
	}
	
	private void addWordsFromFile(File f)
	{
	    FileResource fr= new FileResource(f);
		for (String word : fr.words())
		{
			if (! map.containsKey(word))
            {
				ArrayList<String> wordsArrayList = new ArrayList<String>();
				wordsArrayList.add(f.getName());
				map.put(word,wordsArrayList);
            }
            else
			{
				ArrayList<String> arrL = new ArrayList<String>();
				arrL = map.get(word);
				String filename = f.getName();
				if(arrL.contains(filename))
				{
					continue;
				}
				arrL.add(filename);
				map.remove(word);
				map.put(word, arrL);
			}
		}
	}
	
	public void buildWordFileMap()
	{
		map.clear();
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles())
		{
			addWordsFromFile(f);
		}
	}
	
	public int maxNumber()
	{
		String str="";
		int max=0, count=0;
		for (String s : map.keySet()) 
		{
			ArrayList<String> arrL = new ArrayList<String>();
			arrL = map.get(s);
			count = arrL.size();
			if (count > max)
			{
				max = count;
			}
		}
		return max;
	}
	
	public ArrayList wordsInNumFiles(int number)
	{
	        int count = 0; 
		ArrayList<String> arrL = new ArrayList<String>();
		ArrayList<String> newArrL = new ArrayList<String>();
		for (String s : map.keySet()) 
		{	
			arrL = map.get(s);
			count = arrL.size();
			if (count == number)
			{
				newArrL.add(s);
			}
		}
		return newArrL;
	}
	
	public void printFilesIn(String word)
	{
		ArrayList<String> arrL = new ArrayList<String>();
		for (String s : map.keySet()) 
		{
			if(s.equals(word))
			{
				arrL = map.get(word);
				for (String str : arrL) 
				{
					System.out.println(str);
				}
			}
		}
	}
	
	public void main()
	{
		WordsinFiles obj = new WordsinFiles();
		obj.buildWordFileMap();
		int max = obj.maxNumber();
		ArrayList<String> arrL = new ArrayList<String>();
		arrL = obj.wordsInNumFiles(3);
		int size = arrL.size();
		System.out.println("Max. Number : "+max);
		System.out.println("No. of words = "+size);
		System.out.println("Array List : "+arrL);
		obj.printFilesIn("cats");
	}
}