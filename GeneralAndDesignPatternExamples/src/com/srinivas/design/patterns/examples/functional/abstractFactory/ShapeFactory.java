package com.srinivas.design.patterns.examples.functional.abstractFactory;

public class ShapeFactory extends AbstracFactory {

	public Shape getShape(String shapeName)
	{
		if(shapeName.equalsIgnoreCase("RECTANGLE"))
			return new Rectangle();
		    
		
		if(shapeName.equalsIgnoreCase("CIRCLE"))
			return new Circle();
		
		return null;
	}
	
	public Color getColor(String color)
	{
		return null;
	}
	
	
	
}
