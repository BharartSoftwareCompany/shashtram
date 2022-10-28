package com.bsc.shastram.core.module.secmsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsc.shastram.core.model.Context;
import com.bsc.shastram.core.module.secmsg.model.SecretMessageSession;
import com.bsc.shastram.core.module.secmsg.repo.SecretMessageRepo;
import com.bsc.shastram.core.module.secmsg.repo.SecretMessageSessionRepo;



@Service
public class SecretMessageServices {
	
	@Autowired
	private SecretMessageRepo secretMessageRepo;
	
	
	@Autowired
	private SecretMessageSessionRepo secMessageSessionRepo;
	
	
	
	
	
	public SecretMessageSession createSession(SecretMessageSession session,Context context)
	{
		return session;
		
	}
	
	

}
