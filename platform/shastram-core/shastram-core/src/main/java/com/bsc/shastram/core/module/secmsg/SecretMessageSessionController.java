package com.bsc.shastram.core.module.secmsg;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bsc.shastram.commons.util.ModelUtil;
import com.bsc.shastram.commons.util.rest.ResponseEntityUtil;
import com.bsc.shastram.core.controller.BaseController;
import com.bsc.shastram.core.module.secmsg.model.SecretMessageSession;
import com.bsc.shastram.core.module.secmsg.model.SecretMessageSessionDTO;

@RequestMapping("/session")
@Controller
public class SecretMessageSessionController extends BaseController {
	
	
	@Autowired
	private SecretMessageServices secretMessageServices;
	
	
	@Autowired
	private ModelUtil modelUtil;

	@RequestMapping(method = RequestMethod.POST, path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createSession(@RequestBody SecretMessageSessionDTO dto) {
		
		System.out.println(dto.toJsonString());
		try 
		{
			SecretMessageSession entity = (SecretMessageSession) modelUtil.convertToEntity(dto,SecretMessageSession.class);
			System.out.println(entity.toJsonString());
			entity  = secretMessageServices.createSession(entity, null);
			return ResponseEntityUtil.build(200,entity.toJson());
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return null;
	}

}
