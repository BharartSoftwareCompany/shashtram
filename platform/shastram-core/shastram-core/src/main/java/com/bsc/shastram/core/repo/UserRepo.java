package com.bsc.shastram.core.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bsc.shastram.core.model.User;


@Repository
public interface UserRepo extends  JpaRepository<User, UUID> { 
	
	
	

}
