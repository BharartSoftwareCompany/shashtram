package com.bsc.shastram.core.controller.demo;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bsc.shastram.commons.util.DateUtil;
import com.bsc.shastram.core.model.User;
import com.bsc.shastram.core.module.secmsg.model.SecretMessageSession;
import com.bsc.shastram.core.module.secmsg.repo.SecretMessageRepo;
import com.bsc.shastram.core.module.secmsg.repo.SecretMessageSessionRepo;
import com.bsc.shastram.core.repo.UserRepo;

@Controller
@RequestMapping("/demo")
public class DemoContoller {
	
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	SecretMessageSessionRepo smsRepo;
	
	@Autowired
	SecretMessageRepo messageRepo;
	

	    @RequestMapping(method = RequestMethod.GET, path = "/user", consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
	    public ResponseEntity<String> createUser()  {
	    	
	    	
	    	Date date = new Date();
	    	System.out.println(date.toGMTString());
	     	System.out.println(date.toLocaleString());
	    	
	    	
	    	User user = new User();
	    	
	    	user.setFullName("Madhusudhan");
	    	user.setActive(true);
	    	user.setEmail("hahaasdha@email.com");
	    	
	    	user = userRepo.save(user);
	    	user.toJsonString();
	    	return ResponseEntity.ok(user.toJsonString());
	    	
		  
	  }
	    
	    

	    @RequestMapping(method = RequestMethod.GET, path = "/session", consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
	    public ResponseEntity<String> createSession()  {
	    	
	    	
	    	Optional<User> user = userRepo.findById(UUID.fromString("a1c5af49-806f-4a1b-921a-cc61021fadab"));
	    	SecretMessageSession session =  new SecretMessageSession();
	    	session.setTile("Hello" +  DateUtil.getEPOCTime());
	    	session.setCreator(user.get());
	    	
	    	session=  smsRepo.save(session);
	    	return ResponseEntity.ok(session.toJsonString());
	    	
	  
	    	
	    }
	    

}
