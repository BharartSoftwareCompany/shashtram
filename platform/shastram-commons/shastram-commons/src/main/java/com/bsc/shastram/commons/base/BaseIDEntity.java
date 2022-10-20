package com.bsc.shastram.commons.base;

import com.bsc.shastram.commons.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;
import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = false)
@TypeDefs({ @TypeDef(name = "json", typeClass = JsonStringType.class),
		@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })
public class BaseIDEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected UUID id;

	public BaseIDEntity() {
		Date date = DateUtil.getCurrentDateTimeUTC();
		updatedOn = date;
		createdOn = date;
		createdTimestamp =  DateUtil.getEPOCTime();
		updatedTimestamp = DateUtil.getEPOCTime();

	}

	protected String updatedBy;
	@Column(columnDefinition = "TEXT")
	protected String extras;
	protected String createdBy;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	protected Date createdOn;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	protected Date updatedOn;
	@Column(name = "ip_address")
	protected String ipAddress;
	@Column(columnDefinition = "boolean default true", nullable = false)
	protected boolean active = true;
	@Column(name = "created_timestamp")
	protected Long createdTimestamp;
	@Column(name = "updated_timestamp")
	protected Long updatedTimestamp;

	@JsonIgnore
	public String toJsonString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	@JsonIgnore
	public JSONObject toJson() {
		Gson gson = new Gson();
		return new JSONObject(gson.toJson(this));
	}
}
