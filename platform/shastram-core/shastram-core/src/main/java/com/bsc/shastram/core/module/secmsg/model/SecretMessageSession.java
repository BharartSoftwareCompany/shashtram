package com.bsc.shastram.core.module.secmsg.model;

import javax.persistence.Entity;

import javax.persistence.Table;

import com.bsc.shastram.commons.base.BaseIDEntity;
import com.bsc.shastram.core.model.User;

import lombok.Data;


@Table( schema= "secretmessage", name ="secret_message_session")
@Entity
@Data
public class SecretMessageSession extends BaseIDEntity {
	
	private static final long serialVersionUID = 1L;
	private boolean isCreatedByRegisteredUser;
	private User creator;
	private String tile;
	private String description;
	private long expiry;
	private boolean isExpired = false;
	private String shortCode;
	private boolean isPublic = true;
	private boolean isPasswordProtected = false;
	private String passCode;
	
	
	

}
