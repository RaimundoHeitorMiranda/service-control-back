package com.servicecontrol.dev.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicecontrol.dev.models.User;
import com.servicecontrol.dev.models.task.Task;
import com.servicecontrol.dev.models.task.TaskStatus;
import com.servicecontrol.dev.models.task.TaskStatusCount;
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
		
		task.setStatus(TaskStatus.WAITING);
		task.setCreation_date(LocalDateTime.now());
		
		user.getTasks().add(task);
		task.setUser(user);
		
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
		return this.taskRepository.findAllByUserId(userId);
	}

	@Override
	public Task update(Long id, Task taskUpdate) {
		Task task = this.getById(id);
		
		taskUpdate.setId(task.getId());
		taskUpdate.setUser(task.getUser());
		return this.taskRepository.save(taskUpdate);
	}

	@Override
	public void delete(Long id) {
		this.taskRepository.deleteById(id);
	}

	@Override
	public TaskStatusCount getStatistcs(Long userId) {
		TaskStatusCount statistic = new TaskStatusCount();
		statistic.setWaiting(this.taskRepository.countByStatusAndUserId(TaskStatus.WAITING,userId));
		statistic.setInProgress(this.taskRepository.countByStatusAndUserId(TaskStatus.IN_PROGRESS,userId));
		statistic.setPaused(this.taskRepository.countByStatusAndUserId(TaskStatus.PAUSED,userId));
		statistic.setStopped(this.taskRepository.countByStatusAndUserId(TaskStatus.STOPPED,userId));
		statistic.setCanceled(this.taskRepository.countByStatusAndUserId(TaskStatus.CANCELED,userId));
		statistic.setWaitingPayment(this.taskRepository.countByStatusAndUserId(TaskStatus.WAITING_PAYMENT,userId));
		statistic.setFinalized(this.taskRepository.countByStatusAndUserId(TaskStatus.FINALIZED,userId));
		return statistic;
	}

}
