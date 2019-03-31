package com.servicecontrol.dev.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.servicecontrol.dev.models.task.Task;
import com.servicecontrol.dev.models.task.TaskStatus;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{
	
	List<Task> findAllByUserId(Long id);
	
	Integer countByStatusAndUserId(TaskStatus status,Long userId);
	
	@Query(value="SELECT SUM(price) FROM TASK WHERE user_id = ?1 and status = 0 or status = 1 or status = 5",nativeQuery = true)
	BigDecimal sumMoneyToReceive(Long userId);
	
	@Query(value="SELECT SUM(price) FROM TASK WHERE user_id = ?1 and status = 6",nativeQuery = true)
	BigDecimal sumMoneyReceived(Long userId);

}
