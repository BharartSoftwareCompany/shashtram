package com.bsc.shastram.core.module.secmsg.model;

import javax.persistence.Entity;

import javax.persistence.Table;

import com.bsc.shastram.commons.base.BaseIDEntity;
import com.bsc.shastram.core.model.User;

import lombok.Data;

@Table( schema= "secretmessage", name ="secret_message")
@Entity
@Data
public class SecretMessage extends BaseIDEntity {
	
	
	private static final long serialVersionUID = 1L;
	private String sessionID;
	private User poster;
	private String message;
	
	

	
}
