package com.bsc.shastram.core.module.secmsg;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bsc.shastram.core.controller.BaseController;

@RequestMapping("/session")
@Controller
public class SecretMessageSessionController extends BaseController {
	
	
	
	 @RequestMapping(method = RequestMethod.POST, path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<String> createSession()  
	 {
		 return null;
	 }
	    	

}
