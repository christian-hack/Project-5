import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HammDist {
	
	private ArrayList<String> stations = new ArrayList<String>();
	private ArrayList<String> hDStations = new ArrayList<String>();
	File file = new File("Mesonet.txt");
	
	public HammDist() {
		
	}
	
	public void read() throws IOException
	{
		Scanner bw = new Scanner(file);
		String temp = "";
		bw.nextLine();
		bw.nextLine();
		bw.nextLine();
		
		while (bw.hasNextLine())
		{
			temp = bw.next();
			stations.add(temp);
			bw.nextLine();
		}
		bw.close();
	}
	
	public void addStation(String station2Add) 
	{
		stations.add(station2Add);
	}
	
	public int computeHammingDist(String stationOne, String stationTwo) 
	{
		char[] station1 = new char[4];
		char[] station2 = new char[4];
		
		for (int index = 0; index < 4; ++index) 
		{
			station1[index] = stationOne.charAt(index);
		}
		
		for (int index = 0; index < 4; ++index) 
		{
			station2[index] = stationTwo.charAt(index);
		}
		//create count variable to find discrepancies between array elements
		int count = 0;
		
		for (int index = 0; index < 4; ++index) 
		{
			if (station1[index] != station2[index]) 
			{
				++count;
			}
		}
		return count;
		
	}
	
	public ArrayList<String> getMatchingStations(String st, int hd) 
	{
		int HD = 0;
		int iOfStation = stations.indexOf(st);
		ArrayList<String> match = new ArrayList<String>();
		
		for (int i = 0; i < stations.size(); ++i) 
		{
			if (i != iOfStation) 
			{
				HD = computeHammingDist(st, stations.get(i));
				if (HD == hd) 
				{
					match.add(stations.get(i));
				}
			}
			
		}
		return match;
	}

}
