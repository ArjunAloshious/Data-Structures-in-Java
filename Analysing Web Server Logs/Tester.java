import java.util.*;
import edu.duke.*;

public class Tester
{
	public void testLogEntry()
	{
		LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
		System.out.println(le);
		LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
		System.out.println(le2);
	}
	
	public void testLogAnalyzer()
	{
		LogAnalyzer obj = new LogAnalyzer();
		obj.readFile("short-test_log");
		obj.printAll();
	}
	
	public void testUniqueIP()
	{
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("short-test_log");
		int uniqueIPs = la.countUniqueIPs();
		System.out.println("There are "+ uniqueIPs + " IPs");
	}
	
	public void main()
	{
		Tester ob = new Tester();
		LogAnalyzer obj = new LogAnalyzer();
		obj.readFile("weblog3_log");
		
		ob.testLogEntry();
		ob.testLogAnalyzer();
		ob.testUniqueIP();
		
		obj.printAllHigherThanNum(400);
		obj.uniqueIPVisitsOnDay("Mar 17");
		obj.countUniqueIPsInRange(300, 399);
		
		LogAnalyzer ob = new LogAnalyzer();
		ob.readFile("weblog2_log");
		
		int c = ob.countUniqueIPs();
		System.out.println("Count = " + c);
		
		ob.uniqueIPVisitsOnDay("Sep 24");
		
		ob.countUniqueIPsInRange(400,499);
	}
}