package com.srinivas.design.patterns.examples.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorDemo {

	public static void main(String[] args) {
		List<String> inputList = Arrays.asList("Ram","srinivas","Bhanu","Durga","uday","aswin");
		Spliterator<String> splitter =  inputList.spliterator();
		Spliterator<String> splitter2 = splitter.trySplit();
		
		splitter.forEachRemaining((s) -> {
			 s.toUpperCase();
			System.out.println("Inside splitter 1 :" +s);});
		
		splitter2.forEachRemaining((s) -> {
			 s.toUpperCase();
			System.out.println("Inside splitter 2"+s);});
		
		
		
	}

}
