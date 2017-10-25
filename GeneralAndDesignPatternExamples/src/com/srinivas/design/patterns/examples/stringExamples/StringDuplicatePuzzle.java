package com.srinivas.design.patterns.examples.stringExamples;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringDuplicatePuzzle {
	
	public static void main(String args[])
	{
		String inputString = "Hello Hello World!";
     
		Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		
	   char[] charArray = inputString.toCharArray();
	   
	   for(Character c: charArray)
	   {
		   if(map.containsKey(c))
		   {
			   map.put(c, map.get(c)+1);
		   }
		   else
		   {
			   map.put(c, 1);
		   }
	   }
	 //  System.out.println("Map Size is : "+map.size());
	   for( Map.Entry<Character, Integer> mapEntry:map.entrySet())
	   {
		//  System.out.println("Key ==>"+mapEntry.getKey()+" and Value is : "+mapEntry.getValue());
		   
		   if(mapEntry.getValue()>1)
			   System.out.println("Duplicate Char is : "+mapEntry.getKey()+" And repeated times : "+mapEntry.getValue());
	   }
	   
}
}