package com.srinivas.design.patterns.examples.sorting;

import java.util.List;

public class QuickSort {
	
	public int partition(int arr[] ,int low,int high)
	{
		int i=low-1;
		int pivot =arr[high];
		for(int j=low; j< high;j++)
		{
			if(arr[j] <= pivot)
			{
				i++;
			  int temp= arr[j];
			  arr[j]=arr[i];
			  arr[i]=temp;
			}
			
		}
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		
		return i+1;
	}
	
	 static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i]+" ");
	        System.out.println();
	    }	
	public void quickSort(int[] inputArray, int start,int end)
	{
		if(start < end)
		{
			int i=partition(inputArray, start, end);
			quickSort(inputArray, start, i-1);
			quickSort(inputArray, i+1, end);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {10, 7, 8, 9, 1, 5};
	        int n = arr.length;
	 
	        QuickSort ob = new QuickSort();
	        ob.quickSort(arr, 0, n-1);
	 
	        System.out.println("sorted array");
	        printArray(arr);
		

	}

}
