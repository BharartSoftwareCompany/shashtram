package com.bsc.shastram.core.module.secmsg.model;



import org.springframework.stereotype.Component;
import com.bsc.shastram.commons.base.DTO;
import lombok.Data;


@Component
@Data
public class SecretMessageSessionDTO extends DTO {
	
	
	
	private String title;
	private String description;
	private long expiry;
	private String shortCode;
	private boolean isPublic = true;
	private String passCode;
	private String type;
	
	
	

}
