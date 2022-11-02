package com.bsc.shastram.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bsc.shastram.core.model.User;


@Controller
public class BaseController {
	
	@Autowired
	protected User user;

}
