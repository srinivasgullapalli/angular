package com.srinivas.design.patterns.examples.proxy;

public class RealImage implements Image {

	private String fileName =null;
	@Override
	public void image() {
      
		this.loadImageDromDisk();
	}
	
	
	
	public void loadImageDromDisk()
	{
		System.out.println("Loaded Image from Disk using RealImage Method " );
	}
	
	

}
