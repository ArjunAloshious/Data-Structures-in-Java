/**
 * Description of LogAnalyzer *
 * 
 * Reads files and displays count of all visits made by each IP using a HashMap.
 * Displays the most number of visits made by an IP to the website.
 * Displays an ArrayList of all IPs that have the most number of visits to the website.
 * Creates a HashMap that maps days to all visits made by IP addresses on each day.
 * Returns the day with the most visits made by IP addresses.
 * Returns list of all IPs iwht most visits on a given day. 
 *
 **/


import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
	private ArrayList<LogEntry> records;
	
	public LogAnalyzer()
	{
		records = new ArrayList<LogEntry>();
	}
	
	public void readFile(String f)
	{
		FileResource fr = new FileResource(f);
		for(String line : fr.lines())
		{
			LogEntry rec = WebLogParser.parseEntry(line);
			records.add(rec);
		}
	}
	
	public HashMap<String,Integer> countVisitsPerIP()
	{
		HashMap<String,Integer> counts = new HashMap<String,Integer>();
		for(LogEntry le : records)
		{
			String ip = le.getIPAddress();
			if( !counts.containsKey(ip))
			{
				counts.put(ip,1);
			}
			else
			{
				counts.put(ip, counts.get(ip)+1);
			}
		}
		return counts;
	}
	
	public int mostNumberVisitsByIP(HashMap<String,Integer> map)
	{
		int max = 0;
		for (Integer i : map.values())
		{
			if( i > max)
			{
				max = i;
			}
		}
		return max;
	}
	
	public ArrayList<String> iPsMostVisits(HashMap<String,Integer> map)
	{
		int max = 0;
		ArrayList<String> arr = new ArrayList<String>();
		for (Integer i : map.values())
		{
			if( i > max)
			{
				max = i;
			}
		}
		
		for (String s : map.keySet())
		{
			int value = map.get(s);
			if( value == max)
			{
				arr.add(s);
			}
		}
		return arr;
	}
	
	public HashMap<String, ArrayList<String>> iPsForDays()
	{
		String newdate = "";
		Date date;
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		ArrayList<String> arr;
		for (LogEntry le : records)
		{
			date = le.getAccessTime();
			newdate = date.toString();
			newdate = newdate.substring(4,10);
			String ip = le.getIPAddress();
			if (!map.containsKey(newdate))
			{
				arr = new ArrayList<String>();
				arr.add(ip);
				map.put(newdate, arr);
			}
			else
			{
				arr = new ArrayList<String>();
			    arr = map.get(newdate);
				arr.add(ip);
				map.remove(newdate);
				map.put(newdate, arr);
			}
		}
		return map;
	}
	
	public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map)
	{
		int max = 0;
		String str = "";
		for(String s : map.keySet())
		{
			ArrayList<String> arr = map.get(s);
			if(arr.size() > max)
			{
				max = arr.size();
				str = s;
			}
		}
		return str;
	}
	
	public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map, String someday)
	{
		int c = 0;
		ArrayList<String> arr = new ArrayList<String>();
		HashMap<String, Integer> mapNew = new HashMap<String, Integer>();
		for (String s : map.keySet())
		{
			if (s.equals(someday))
			{
				arr = map.get(s);
				for (String str : arr)
				{
					if(!mapNew.containsKey(str))
					{
						mapNew.put(str, 1);
					}
					else
					{
						c = mapNew.get(str);
						mapNew.remove(str);
						mapNew.put(str, c+1);
					}
				}
			}
		}
		ArrayList<String> arrayL = iPsMostVisits(mapNew);
		return arrayL;
	}
}