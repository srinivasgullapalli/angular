package com.spring.boot.mong.angular.app.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Todo {

	@Id
	private String id;

	@NotNull
	@Size(min = 2, max = 1000)
	private String todoItem;

	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((todoItem == null) ? 0 : todoItem.hashCode());
		result = prime * result + ((todoStatus == null) ? 0 : todoStatus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (todoItem == null) {
			if (other.todoItem != null)
				return false;
		} else if (!todoItem.equals(other.todoItem))
			return false;
		if (todoStatus == null) {
			if (other.todoStatus != null)
				return false;
		} else if (!todoStatus.equals(other.todoStatus))
			return false;
		return true;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTodoItem() {
		return todoItem;
	}

	public void setTodoItem(String todoItem) {
		this.todoItem = todoItem;
	}

	public String getTodoStatus() {
		return todoStatus;
	}

	public void setTodoStatus(String todoStatus) {
		this.todoStatus = todoStatus;
	}

	private String todoStatus;

}
