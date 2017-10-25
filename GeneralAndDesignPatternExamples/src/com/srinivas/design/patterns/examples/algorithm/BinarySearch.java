package com.srinivas.design.patterns.examples.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	public Boolean binarySearch(List<Integer> list,Integer numberToBeSearched)
	{
		int start = 0;
		int end = list.size()-1;
		int mid = (start+end)/2;
		for(Integer element: list)
		{
			if(list.get(mid)==numberToBeSearched)
				return true;
			 if(numberToBeSearched > list.get(mid))
			 {
				 start=mid+1;
				 mid = (start+end)/2;
			 }
			 else
			 {
				  end=mid-1;
				  mid = (start+end)/2;
			 }
		}
		 return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       BinarySearch search = new BinarySearch();
       List<Integer> list = new ArrayList<Integer>();
       list.add(1);list.add(2);list.add(3);list.add(4);
       list.add(5);list.add(6);list.add(7);list.add(8);
       System.out.println("Result -->"+search.binarySearch(list, 5));
	}

}
