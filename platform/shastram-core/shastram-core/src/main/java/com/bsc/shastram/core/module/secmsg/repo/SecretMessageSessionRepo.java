package com.bsc.shastram.core.module.secretmessage;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bsc.shastram.core.model.User;


@Repository
public interface SecretMessageSessionRepo extends  JpaRepository<SecretMessageSession, UUID> { 
	
	
	

}
