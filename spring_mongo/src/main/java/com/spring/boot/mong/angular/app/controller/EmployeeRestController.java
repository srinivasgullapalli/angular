package com.spring.boot.mong.angular.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.spring.boot.mong.angular.app.entity.Employee;
import com.spring.boot.mong.angular.app.repository.IEmployeeRepository;


@RestController
@RequestMapping("/employee")
public class EmployeeRestController {


    @Autowired
    private IEmployeeRepository employeeRepository;
    @RequestMapping( method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void save(@Valid @RequestBody Employee employee) {
    	employeeRepository.save(employee);
    	System.out.println("Data Inserted Successfully!");
    }


    @RequestMapping( method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable  String id) {
    	System.out.println("Inside Delete REST API for :"+id);
		Map<String, Object> dataMap = new HashMap<String, Object>();
        employeeRepository.delete(id);
        dataMap.put("message", "employee deleted successfully");
		dataMap.put("status", "1");
	   // return dataMap;
    }
    
    @RequestMapping(value = "{employee}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Map<String, Object> editEmployee(Employee employee) {
    	System.out.println("Inside update REST API for  : "+employee.getName());
		Map<String, Object> dataMap = new HashMap<String, Object>();
        employeeRepository.save(employee);
        dataMap.put("message", "employee updated successfully");
		dataMap.put("status", "1");
	    return dataMap;
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Map<String, Object> loadListOfEmployees(String fileName) {
    	List<Employee> employeeList = new ArrayList<Employee>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
        employeeRepository.save(employeeList);
        dataMap.put("message", "employees list uploaded successfully");
		dataMap.put("status", "1");
	    return dataMap;
    }
    
    
    
    
    
    
}
