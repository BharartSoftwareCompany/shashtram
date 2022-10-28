/*********************************************
 *  @author Madhusudhan Mahale |  2022 
 *********************************************/
package com.bsc.shastram.core.module.secmsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsc.shastram.core.model.Context;
import com.bsc.shastram.core.module.secmsg.model.SecretMessage;
import com.bsc.shastram.core.module.secmsg.model.SecretMessageSession;
import com.bsc.shastram.core.module.secmsg.repo.SecretMessageRepo;
import com.bsc.shastram.core.module.secmsg.repo.SecretMessageSessionRepo;



@Service
public class SecretMessageServices {
	
	@Autowired
	private SecretMessageRepo secretMessageRepo;
	
	
	@Autowired
	private SecretMessageSessionRepo secMessageSessionRepo;
	
	
	
	
	//Session related services
	public SecretMessageSession createSession(SecretMessageSession session,Context context)
	{
		session = secMessageSessionRepo.save(session);
		return session;
	}
	
	
	//Message related Services
	public SecretMessage saveMessage(SecretMessage message,Context context)
	{
		message = secretMessageRepo.save(message);
		return message;
		
	}
	
	

}
