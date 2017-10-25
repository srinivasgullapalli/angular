package com.srinivas.design.patterns.examples.functional.abstractFactory;

public class AbstractFactoryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       AbstracFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
       Shape shape = shapeFactory.getShape("CIRCLE");
       shape.getShape();

       AbstracFactory corlorFactory = FactoryProducer.getFactory("COLOR");
       Color color = corlorFactory.getColor("BLUE");
       color.draw();
	}

}
