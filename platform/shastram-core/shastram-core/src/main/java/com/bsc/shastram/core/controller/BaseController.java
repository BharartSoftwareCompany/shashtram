package com.bsc.shastram.core.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.bsc.shastram.core.model.User;

public class BaseController {
	
	@Autowired
	protected User user;

}
