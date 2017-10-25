package com.srinivas.design.patterns.examples.factory;

public class ShapeFactory {

	public static Shape getShapeInstance(String shape)
	{
		Shape object =null;
		
		switch(shape)
		{
		case  "CIRCLE" : object=new Circle();break;
		case  "RECTANGLE" : object = new Rectangle();break;
		case "TRIANGLE" : object = new Triangle();break;
		default: break;
		
		}
		
		return object;
	}
	
}
