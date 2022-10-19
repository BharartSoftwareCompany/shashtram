package com.bsc.shastram.core.controller.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bsc.shastram.core.model.User;
import com.bsc.shastram.core.repo.UserRepo;

@Controller
@RequestMapping("/demo")
public class DemoContoller {
	
	
	@Autowired
	UserRepo userRepo;
	

	    @RequestMapping(method = RequestMethod.GET, path = "/user", consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
	    public ResponseEntity<String> createUser()  {
	    	
	    	
	    	User user = new User();
	    	user.setFirstName("Madhusudhan");
	    	user.setEmail("hahaha@email.com");
	    	user = userRepo.save(user);
	    	user.toJsonString();
	    	return ResponseEntity.ok(user.toJsonString());
	    	
		  
	  }

}
