package com.spring.boot.mong.angular.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.boot.mong.angular.app.entity.Todo;

public interface ITodoRepository extends MongoRepository<Todo, String> {
}
