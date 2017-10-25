package com.srinivas.design.patterns.examples.factory;

public class FactoryPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Shape object = ShapeFactory.getShapeInstance("CIRCLE");
       object.draw();
	}

}
