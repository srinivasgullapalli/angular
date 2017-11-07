package com.srinivas.design.patterns.examples.programmingPuzzles;

public class RepeatedElementsFinder {

	public void repeatFinder(int arr[])
	{
	      int size = arr.length;
	      
	      for(int i=0;i<size;i++)
	      {
	    	  for(int j=i+1;j<size;j++)
	    	  {
	    		   if(arr[i]==arr[j])
	    		   {
	    			   System.out.println("Repeated element is : "+arr[i]);
	    		   }
	    	  }
	      }
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int arr[]={1,8,2,3,4,4,5,6,7,2,8};
          RepeatedElementsFinder finder = new RepeatedElementsFinder();
          finder.repeatFinder(arr);
	}
	
	

}
