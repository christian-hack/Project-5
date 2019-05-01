import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HammDist {
	
	private ArrayList<String> stations = new ArrayList<String>();
	private ArrayList<String> hd0Stations = new ArrayList<String>();
	private ArrayList<String> hd1Stations = new ArrayList<String>();
	private ArrayList<String> hd2Stations = new ArrayList<String>();
	private ArrayList<String> hd3Stations = new ArrayList<String>();
	private ArrayList<String> hd4Stations = new ArrayList<String>();
	File file = new File("Mesonet.txt");
	
	public HammDist() throws IOException 
	{
		read();
		
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
	
	public void addStation(String stationToAdd) 
	{
		stations.add(stationToAdd);
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
	
	public void getMatchingStations(String st) 
	{
		int HD = 0;
		int iOfStation = stations.indexOf(st);
		
		for (int i = 0; i < stations.size(); ++i) 
		{
			if (i != iOfStation) 
			{
				HD = computeHammingDist(st, stations.get(i));
				if (HD == 0) 
				{
					hd0Stations.add(stations.get(i));
				}
				if (HD == 1) 
				{
					hd1Stations.add(stations.get(i));
				}
				if (HD == 2)
				{
					hd2Stations.add(stations.get(i));
				}
				if (HD == 3)
				{
					hd3Stations.add(stations.get(i));
				}
				if (HD == 4)
				{
					hd4Stations.add(stations.get(i));
				}
			}
			
		}
	}

}
