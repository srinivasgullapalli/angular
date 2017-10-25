package com.srinivas.design.patterns.examples.functional.abstractFactory;

public abstract class AbstracFactory {

	public abstract Shape getShape(String shapeName);
	
	public abstract Color getColor(String colorName);
}
