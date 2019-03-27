package com.servicecontrol.dev.services;

import java.util.List;

import com.servicecontrol.dev.models.Task;

public interface TaskService {

	Task register(Task task);
	
	Task getById(Long id);
	
	List<Task> getAll();
	
	Task update(Long id, Task taskUpdate);
	
	void delete(Long id);
	
}
