package com.servicecontrol.dev.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicecontrol.dev.models.Task;
import com.servicecontrol.dev.repositories.TaskRepository;
import com.servicecontrol.dev.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Task register(Task task) {
		return this.taskRepository.save(task);
	}

	@Override
	public Task getById(Long id) {
		return this.taskRepository.findById(id).get();
	}

	@Override
	public List<Task> getAll() {
		return this.taskRepository.findAll();
	}

	@Override
	public Task update(Long id, Task taskUpdate) {
		taskUpdate.setId(id);
		return this.taskRepository.save(taskUpdate);
	}

	@Override
	public void delete(Long id) {
		this.taskRepository.deleteById(id);
	}

}
