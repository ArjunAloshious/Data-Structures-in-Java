import java.util.*;

public class Tester
{
	public void testCounts()
	{
		LogAnalyzer la = new LogAnalyzer();
		la.readFile("weblog2_log");
		
		HashMap<String,Integer> counts = la.countVisitsPerIP();
		System.out.println("IP addresses that visited and their count :-");
		System.out.println(counts);
		
		int max = la.mostNumberVisitsByIP(counts);
		System.out.print("\nMaximum number of visits = ");
		System.out.println(max);
		
		ArrayList<String> arr = la.iPsMostVisits(counts);
		System.out.println("\nMost visited IP adresses were :-");
		System.out.println(arr);
		
		HashMap<String, ArrayList<String>> map = la.iPsForDays();
		System.out.println("\nDays and corresponding IP visits are :-");
		System.out.println(map);
		
		String str = la.dayWithMostIPVisits(map);
		System.out.println("\nDay with most visits from an IP Address is : " + str);
		
		String s1 = "Sep 29";
		ArrayList<String> arrayL = la.iPsWithMostVisitsOnDay(map, s1);
		System.out.println("\nIP addresses that visited most on Sep 29 are :-\n" + arrayL);
	}
}