package com.srinivas.design.patterns.examples.proxy;

public class ProxyImage implements Image {

	private String fileName=null;
	private RealImage realImage=null;
	public ProxyImage(String fileName)
	{
		this.fileName = fileName;
	}
	
	public void image()
	{
		if(realImage ==null)
			realImage = new RealImage();
		realImage.image();
	}
	
}
