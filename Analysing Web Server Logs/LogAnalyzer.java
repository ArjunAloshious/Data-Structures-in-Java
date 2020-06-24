/**
 * Description of LogAnalyzer *
 *
 * Reads files and displays number of unique IP Address values in an ArrayList.
 * Displays all unique IP Addresses that visited a website on a particular day in a web log file.
 * Displays number of unique IP Addresses that visited a website which have a status code within a specified range.
 * Prints all status codes greater than number specified.
 * Prints all records of the web log.
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
	
	public int countUniqueIPs()
	{
		ArrayList<String> uniqueIPs = new ArrayList<String>();
		for(LogEntry le : records)
		{
			String ipAddress = le.getIPAddress();
			if(!uniqueIPs.contains(ipAddress))
			{
				uniqueIPs.add(ipAddress);
			}
		}
		return uniqueIPs.size();
	}
	
	public void uniqueIPVisitsOnDay(String someday)
	{
		ArrayList<String> uniqueIPs = new ArrayList<String>();
		for(LogEntry le : records)
		{
			Date d = le.getAccessTime();
			String str = d.toString();
			if(str.contains(someday))
			{
				String ipAddress = le.getIPAddress();
				if(!uniqueIPs.contains(ipAddress))
				{
					uniqueIPs.add(ipAddress);
				}
			}
		}
		for (String i : uniqueIPs)
		{
			System.out.println("Unique IP on " + someday +" = " + i);
		}
	}
	
	public void countUniqueIPsInRange(int low, int high)
	{
		ArrayList<String> uniqueIPs = new ArrayList<String>();
		for(LogEntry le : records)
		{
			int sc = le.getStatusCode();
			if(sc >= low && sc <= high)
			{	
				String ipAddress = le.getIPAddress();
				if(!uniqueIPs.contains(ipAddress))
				{
					uniqueIPs.add(ipAddress);
				}
			}
		}
		System.out.println("There are "+ uniqueIPs.size() + " IPs");
	}
	
	public void printAllHigherThanNum(int num)
	{
		ArrayList<Integer> gt = new ArrayList<Integer>();
		for(LogEntry le : records)
		{
			int sc = le.getStatusCode();
			if(sc > num)
			{
				gt.add(sc);
			}
		}
		for (int i : gt)
		{
			System.out.println("Status Code = " + i);
		}
	}
	
	public void printAll()
	{
		for(LogEntry le : records)
		{
			System.out.println(le);
		}
	}	
}