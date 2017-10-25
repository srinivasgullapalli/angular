package com.srinivas.design.patterns.examples.programmingPuzzles;

import java.io.File;
import java.util.Arrays;


public class ListFiles  {
	public static String fileLocation="D:\\SAMPLES";
	public static void main(String[] args) {
		 System.out.println("Before submit method : ");
	 listOne(fileLocation);
		// listOneUsingStream(fileLocation);
	}
	

	public static  void listOne(String location)
	{
		File files = new File(location);
	 for(File file : files.listFiles())	
	 {
		if(!file.isDirectory())
		{
			System.out.println("This is file : "+file.getAbsolutePath());
		}
		else
		{
			listOne(file.getAbsolutePath());
		}
	}
	}
	
	
	
	public static void listOneUsingStream(String fileLocation)
	{
		File files = new File(fileLocation);
		Arrays.asList(files.listFiles()).stream().forEach(s -> listOne(s.getAbsolutePath()));
		
	}


}
