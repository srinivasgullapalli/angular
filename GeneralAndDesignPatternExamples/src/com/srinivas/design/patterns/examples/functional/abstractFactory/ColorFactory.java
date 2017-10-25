package com.srinivas.design.patterns.examples.functional.abstractFactory;

public class ColorFactory extends AbstracFactory {
	
	public Shape getShape(String shapeName)
	{
		
		
		return null;
	}
	
	public Color getColor(String colorName)
	{
		if(colorName.equalsIgnoreCase("RED"))
			return new RedColor();
		
		if(colorName.equalsIgnoreCase("BLUE"))
			return new BlueColor();
		
		
		return null;
			
	}

}
