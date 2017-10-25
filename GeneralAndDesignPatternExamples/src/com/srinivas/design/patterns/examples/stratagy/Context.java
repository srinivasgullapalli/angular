package com.srinivas.design.patterns.examples.stratagy;

public class Context  {
	
	Stratagy obj;
	public Context(Stratagy stratagy)
	{
		obj=stratagy;
	}
	
   public int executeOperation(int one,int two)
   {
	   return obj.operationStratagy(one, two);
   }
}
