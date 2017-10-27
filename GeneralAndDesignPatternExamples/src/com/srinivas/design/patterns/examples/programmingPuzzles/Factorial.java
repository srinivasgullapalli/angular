package com.srinivas.design.patterns.examples.programmingPuzzles;

public class Factorial {

	public static int factorial(int number)
	{
		if(number ==0 )
			return 1;
		int result=1;
		for(int i=1;i<=number;i++)
		{
			result=result*i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println("Factorial : "+factorial(6));
	}

}
