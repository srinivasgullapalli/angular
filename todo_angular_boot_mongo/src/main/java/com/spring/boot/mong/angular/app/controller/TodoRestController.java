package com.spring.boot.mong.angular.app.controller;

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


import com.spring.boot.mong.angular.app.entity.Todo;
import com.spring.boot.mong.angular.app.repository.ITodoRepository;


@RestController
@RequestMapping("/todo")
public class TodoRestController {


    @Autowired
    private ITodoRepository employeeRepository;
    @RequestMapping( method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void save(@Valid @RequestBody Todo todo) {
    	employeeRepository.save(todo);
    	System.out.println("todo saved Successfully!");
    }


    @RequestMapping( method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Todo> listAll() {
        return employeeRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTodo(@PathVariable  String id) {
    	System.out.println("Inside Delete REST API for :"+id);
		Map<String, Object> dataMap = new HashMap<String, Object>();
        employeeRepository.delete(id);
        dataMap.put("message", "todo deleted successfully");
		dataMap.put("status", "1");
    }
    
    @RequestMapping(value = "{employee}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Map<String, Object> editTodo(Todo todo) {
    	System.out.println("Inside update REST API for  : "+todo.getTodoItem());
		Map<String, Object> dataMap = new HashMap<String, Object>();
        employeeRepository.save(todo);
        dataMap.put("message", "todo updated successfully");
		dataMap.put("status", "1");
	    return dataMap;
    }
    
    
    
    
    
    
    
}
