package com.srinivas.design.patterns.examples.functional.abstractFactory;

public class FactoryProducer {
	

	public static AbstracFactory getFactory(String factoryName)
	{
		if(factoryName.equalsIgnoreCase("SHAPE"))
		  return new ShapeFactory();
		  
		  if(factoryName.equalsIgnoreCase("color"))
			  return new ColorFactory();
                		  
		  return null;
			  
	}

}
