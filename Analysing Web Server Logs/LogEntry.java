/**
 * Description of LogEntry *
 *
 * Returns all elements of a web log file as separate entities to required classes and methods, one record at a time. 
 * 
 **/


import java.util.*;
import edu.duke.*;

public class LogEntry
{
	private String ipAddress;
	private Date accessTime;
	private String request;
	private int statusCode;
	private int bytesReturned;
	
	public LogEntry(String ip, Date time, String req, int status, int bytes)
	{
		ipAddress = ip;
		accessTime = time;
		request = req;
		statusCode = status;
		bytesReturned = bytes;
	}
	
	public String getIPAddress()
	{
		return ipAddress;
	}
	
	public Date getAccessTime()
	{
		return accessTime;
	}
	
	public String getRequest()
	{
		return request;
	}
	
	public int getStatusCode()
	{
		return statusCode;
	}
	public int getBytesReturned()
	{
		return bytesReturned;
	}
	
	public String toString()
	{
		return ipAddress + " " + accessTime + " " + request + " " + statusCode + " " + bytesReturned;
	}
}