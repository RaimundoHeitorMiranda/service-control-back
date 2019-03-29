package com.servicecontrol.dev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicecontrol.dev.models.Task;
import com.servicecontrol.dev.services.TaskService;

@RestController
@RequestMapping("user/{userId}/service")
@CrossOrigin("*")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	
	@PostMapping
	public ResponseEntity<Task> register(@PathVariable Long userId,@RequestBody Task task){
		return ResponseEntity.status(HttpStatus.OK).body(this.taskService.register(userId,task));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> getById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(this.taskService.getById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Task>> getAll(@PathVariable Long userId){
		return ResponseEntity.status(HttpStatus.OK).body(this.taskService.getAllByUser(userId));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> update(@PathVariable Long id,@RequestBody Task taskUpdate){
		return ResponseEntity.status(HttpStatus.OK).body(this.taskService.update(id, taskUpdate));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		this.taskService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();	
	}
	
}
