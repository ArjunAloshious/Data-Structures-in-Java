/**
 * Description of CommonWords *
 * 
 * CommonWords is a program used to :
 *
 * Find all common words within a text file by referencing another file which contains a sample list of common words. 
 * Take the count of these common words and display the words along with their count as output.
 *
 **/
 
import edu.duke.*;

public class CommonWords
{
	public String[] getCommon()
	{
		FileResource res = new FileResource("common.txt");
		String[] common = new String[20];
		int index = 0;
		for(String s : res.words())
		{
			common[index]=s;
			index += 1;
		}
		return common;
	}
	
	public int indexOf(String[] list, String word)
	{
		for(int k=0; k < list.length ; k++)
		{
			if(list[k].equals(word))
			{
				return k;
			}
		}
		return -1;
	}
	
	
	public void countWords(FileResource res, String[] common, int[] counts)
	{
		for(String word : res.words())
		{
			word = word.toLowerCase();
			int index = indexOf(common, word);
			if (index != -1 )
			{
				counts[index] += 1; 
			}
		}	
	}
	
	public void countShakespeare()
	{
		String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt", "likeit.txt", "macbeth.txt", "romeo.txt"};
		String[] common = getCommon();
		int[] counts = new int[common.length];
		for(int k=0; k < plays.length ; k++)
		{
			FileResource res = new FileResource(plays[k]);
			countWords(res,common,counts);
			System.out.println("done with " + plays[k]);
		}
		for(int k=0; k < common.length; k++)
		{
			System.out.println(common[k] + "\t" + counts[k]);
		}
	}
	
	public void main()
	{
		CommonWords obj = new CommonWords();
		obj.countShakespeare();
	}
}