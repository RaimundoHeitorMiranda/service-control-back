package com.servicecontrol.dev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicecontrol.dev.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
	
}
