package com.servicecontrol.dev.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicecontrol.dev.models.Task;
import com.servicecontrol.dev.models.User;
import com.servicecontrol.dev.repositories.TaskRepository;
import com.servicecontrol.dev.repositories.UserRepository;
import com.servicecontrol.dev.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Task register(Long userId,Task task) {
		User user = this.userRepository.findById(userId).orElseThrow(()->
			new RuntimeException());
		
		user.getTasks().add(task);
		
		this.taskRepository.save(task);
		this.userRepository.save(user);
		
		return task;
	}

	@Override
	public Task getById(Long id) {
		return this.taskRepository.findById(id).orElseThrow(()->
				new RuntimeException());
	}

	@Override
	public List<Task> getAllByUser(Long userId) {
		return this.taskRepository.findAllByUser(userId);
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
