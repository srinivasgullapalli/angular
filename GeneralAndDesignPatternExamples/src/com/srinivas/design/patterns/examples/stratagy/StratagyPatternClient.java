package com.srinivas.design.patterns.examples.stratagy;

public class StratagyPatternClient {

	public static void main(String args[]) {
		Context context = new Context(new OperationAdd());
		int resultAdd = context.executeOperation(2, 3);
		System.out.println("Addition Result :  " + resultAdd);
	}

}
