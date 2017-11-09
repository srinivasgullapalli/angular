package com.srinivas.design.patterns.examples.singleTon;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FiveTon {
	
	private static List<FiveTon> list = Collections.synchronizedList(new LinkedList<FiveTon>());
	private static int index = 0; 
	private FiveTon()
	{
		
	}
	
	public static FiveTon getInstance()
	{
		if(list.size() <5)
		{
			FiveTon obj=null;
			synchronized (list) {
				 obj = new FiveTon();
				list.add(obj);
				return obj;
			}
		}
		else
		{
			synchronized (list) {
               FiveTon obj = list.get(index);
               index = (index +1) % list.size();
               return obj;
			}
		}
	}

	public int getSize() 
	{ 
	return list.size(); 
	} 
	public static void main(String[] args) {

		 System.out.println("FiveTon Example ");
		 for(int i=0;i<11;i++)
		 {
			 FiveTon ton=FiveTon.getInstance();
			 System.out.println("Fiveton : "+ton+" Size is "+ton.getSize()); 
		 }
	}

	@Override
	public String toString() {
		return "FiveTon []";
	}

}
