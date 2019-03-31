package com.servicecontrol.dev.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.servicecontrol.dev.models.task.Task;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Task> tasks = new ArrayList<Task>();
	
	public User() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", tasks=" + tasks
				+ "]";
	}
		
}
