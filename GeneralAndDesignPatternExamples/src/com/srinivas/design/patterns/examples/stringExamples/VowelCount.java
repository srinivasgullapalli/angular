package com.srinivas.design.patterns.examples.stringExamples;

import java.util.Scanner;

public class VowelCount {

	
	public static void main(String args[])
	{   
		System.out.println("Enter String to test : ");
		Scanner scanner = new Scanner(System.in);
		char[] charArray = scanner.nextLine().toCharArray();
		
		int vowelCount=0;
		for(Character charactor : charArray){
		switch(charactor)
		{
		case  'a' :
			vowelCount++;
			break;
		case 'e' :
			vowelCount++;
			break;
		case 'i' : 
			vowelCount++;
			break;
		case 'o' :
			vowelCount++;
			break;
		case  'u':
			vowelCount++;
			break;
		default:
			 
		}  
		}
		
		System.out.println(" Vowel Count : "+vowelCount);
	}
}
