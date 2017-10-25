package com.srinivas.design.patterns.examples.stringExamples;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String inputString = "Hello cruel world";
      char[] charArray= inputString.toCharArray();
      Map<Character,Integer> map = new LinkedHashMap<>();
      
      for(Character itr : charArray)
      {
    	  if(map.containsKey(itr))
    	  {
    		   map.put(itr, map.get(itr)+1);
    	  }
    	  else
    	  {
    		  map.put(itr, 1);
    	  }
      }
      
      
      for( Map.Entry<Character, Integer> mapEntry:map.entrySet())
      {
    	   if(mapEntry.getValue().equals(1))
    	   {
    		   System.out.println("First Non Repeated Character is : "+mapEntry.getKey());
    	   }
         break;
      }
		 
	}

}
