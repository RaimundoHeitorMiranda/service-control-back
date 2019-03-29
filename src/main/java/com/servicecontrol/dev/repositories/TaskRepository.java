package com.servicecontrol.dev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicecontrol.dev.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{
	
	List<Task> findAllByUser(Long id);

}
