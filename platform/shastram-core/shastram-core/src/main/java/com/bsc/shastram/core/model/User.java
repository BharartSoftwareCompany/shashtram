package com.bsc.shastram.core.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.bsc.shastram.commons.base.BaseIDEntity;
import com.bsc.shastram.commons.model.base.BaseUser;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Table(schema = "profile" , name = "user_s")
@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@Component
public class User extends BaseUser {
	
	private String bio;

}
