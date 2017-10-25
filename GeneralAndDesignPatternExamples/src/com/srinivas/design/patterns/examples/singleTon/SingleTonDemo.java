package com.srinivas.design.patterns.examples.singleTon;

public class SingleTonDemo {
	
	private static SingleTonDemo singleTon = new SingleTonDemo();
	
	private SingleTonDemo()
	{
		System.out.println("Object got created ");
	}
	
    public static SingleTonDemo  getInstance()
    {
    	return singleTon;
    }
    
    
	

	@Override
	public String toString() {
		return "SingleTonDemo [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     SingleTonDemo obj = SingleTonDemo.getInstance();
     System.out.println("Main Method Called...."+obj);
     SingleTonDemo obj1 = SingleTonDemo.getInstance();
     SingleTonDemo obj2 = SingleTonDemo.getInstance();
     SingleTonDemo obj3 = SingleTonDemo.getInstance();
     
	}

}
