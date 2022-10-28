package com.bsc.shastram.core.module.secmsg.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bsc.shastram.core.model.User;
import com.bsc.shastram.core.module.secmsg.model.SecretMessage;


@Repository
public interface SecretMessageRepo extends  JpaRepository<SecretMessage, UUID> { 
	
	
	

}
