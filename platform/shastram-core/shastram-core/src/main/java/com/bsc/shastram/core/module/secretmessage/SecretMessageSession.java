package com.bsc.shastram.core.module.secretmessage;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bsc.shastram.commons.base.BaseIDEntity;

import lombok.Data;


@Table( schema= "secretmessage", name ="secret_message_session")
@Entity
@Data
public class SecretMessageSession extends BaseIDEntity {
	
	private static final long serialVersionUID = 1L;
	private boolean isCreatedByRegisteredUser;
	private String userId;
	private String tile;
	private String description;
	private long expiry;
	private boolean isExpired = false;
	private String shortCode;
	private boolean isPublic = true;
	
	
	

}
