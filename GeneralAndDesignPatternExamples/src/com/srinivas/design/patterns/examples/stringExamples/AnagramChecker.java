package com.srinivas.design.patterns.examples.stringExamples;

import java.util.Arrays;

public class AnagramChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
        String str1 ="Hello world" ;  
        String str2 = "World Hello";
		String inputStringOne = str1.replaceAll("\\s", "");
		String inputStringTwo =str2.replaceAll("\\s", "");
		
		char[] inputCharArrayOne =inputStringOne.toLowerCase().toCharArray();
		
		char[] inputCharArrayTwo = inputStringTwo.toLowerCase().toCharArray();
		
		Arrays.sort(inputCharArrayOne);
		Arrays.sort(inputCharArrayTwo);
		
		Boolean status = Arrays.equals(inputCharArrayOne, inputCharArrayTwo);
		System.out.println("Anagram ??? : "+status);
	}

}
