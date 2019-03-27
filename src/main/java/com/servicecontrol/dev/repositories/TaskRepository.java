package com.servicecontrol.dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicecontrol.dev.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{

}
