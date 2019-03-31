package com.servicecontrol.dev.services;

import java.util.List;

import com.servicecontrol.dev.models.task.Task;
import com.servicecontrol.dev.models.task.TaskStatusCount;

public interface TaskService {

	// crud
	
	Task register(Long userId,Task task);
	
	Task getById(Long id);
	
	List<Task> getAllByUser(Long userId);
	
	Task update(Long id, Task taskUpdate);
	
	void delete(Long id);
	
	// statistc
	
	TaskStatusCount getStatistcs(Long userId);
	
}
