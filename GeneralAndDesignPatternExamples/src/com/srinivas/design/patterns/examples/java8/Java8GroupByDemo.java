package com.srinivas.design.patterns.examples.java8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;




public class Java8GroupByDemo {

	public static void main(String[] args) {
		
		
     Java8GroupByDemo obj= new Java8GroupByDemo();
     try {
		obj.groupByWithSingleElement("D:\\GIT-STORE\\GeneralAndDesignPatternExamples\\person.csv");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	
	public void groupByWithSingleElement(String fileName) throws FileNotFoundException, IOException
	{
		Pattern pattern= Pattern.compile(",");
		try(BufferedReader reader= new BufferedReader(new FileReader(fileName)))
		{
			Map<String,List<Person>> groupByMap =  reader.lines().skip(1).map(line -> {
				  String[] arr = pattern.split(line);
				  return new Person(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]);
			  }).collect(Collectors.groupingBy(Person::getCountry));
			
			for(Map.Entry<String, List<Person>> mapEntry : groupByMap.entrySet())
			{
				System.out.println("Group by Details : "+mapEntry.getKey()+" ==> "+mapEntry.getValue());
			}
			
		}
				
	}

}
class Person
{
	String id;
	String name;
	String gender;
	String age;
	String country;
	String religion;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", country=" + country
				+ ", religion=" + religion + "]";
	}
	public Person(String id, String name, String gender, String age, String country, String religion) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.country = country;
		this.religion = religion;
	}
	
}
