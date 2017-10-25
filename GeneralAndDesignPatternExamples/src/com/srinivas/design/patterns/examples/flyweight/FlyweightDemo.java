package com.srinivas.design.patterns.examples.flyweight;

public class FlyweightDemo {

	
	 private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };
	public static void main(String[] args) {
		for(int i=0; i<=colors.length;i++)
		{
			Circle circle = (Circle)ShapeFactory.getCircle(getRandomColor());
	         circle.setX(getRandomX());
	         circle.setY(getRandomY());
	         circle.setRadius(100);
	         circle.draw();
		}
		
	}
	
	public static String getRandomColor()
	{
		return colors[(int)(Math.random()*colors.length)];
	}
	   private static int getRandomX() {
		      return (int)(Math.random()*100 );
		   }
		   private static int getRandomY() {
		      return (int)(Math.random()*100);
		   }
	 
}