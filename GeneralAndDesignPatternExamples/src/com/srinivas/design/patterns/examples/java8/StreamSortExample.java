package com.srinivas.design.patterns.examples.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamSortExample {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee("Durga","Vaddi","900"));
        employeeList.add(new Employee("Uday","Vadapalli","3000"));
        employeeList.add(new Employee("Srinivas","Gullapalli","2000"));
        employeeList.add(new Employee("Bhanu","Valapalli","4000"));
        employeeList.add(new Employee("Ashwin","Vutukuri","5000"));

/*        employeeList.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o1.firstName.compareTo(o2.firstName);
			}
        	
        	
        	
		} );*/
        Collections.sort(employeeList,(Employee e1,Employee e2)-> e1.firstName.compareTo(e2.firstName));
        
        employeeList.forEach(System.out::print);
        employeeList.sort((Employee e1,Employee e2)-> e1.firstName.compareTo(e2.firstName));
       // employeeList.sort(employeeList,(Employee e1,Employee e2)-> e1.firstName.compareTo(e2.firstName));
        
	}

}

class Employee 
{
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + "]";
	}
	public Employee(String firstName, String lastName, String salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	String firstName;
	String lastName;
	String salary;
	
}
