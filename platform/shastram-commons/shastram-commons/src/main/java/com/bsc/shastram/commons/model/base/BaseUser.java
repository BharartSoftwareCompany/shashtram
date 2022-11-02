package com.bsc.shastram.commons.model.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.stereotype.Component;

import com.bsc.shastram.commons.base.BaseIDEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
@Component
public abstract class BaseUser extends BaseIDEntity {

	@Column(name = "user_type")
	protected String type;
	@Column(name = "full_name")
	protected String fullName;
	@Column(name = "first_name")
	protected String firstName;
	@Column(name = "last_name")
	protected String lastName;
	@Column(name = "middle_name")
	protected String middleName;
	@Column(name = "date_of_birth")
	protected Date dob;
	protected String sex;
	@Column(unique = true)
	protected String email;
	protected String country;
	protected String cc;
	protected String phone;
	@Column(name = "email_verification_status")
	protected String emailVerificationStatus;
	@Column(name = "phone_verification_status")
	protected String phoneVerificationStatus;
	@Column(name = "profile_image_url")
	protected String profileImageUrl;

}
