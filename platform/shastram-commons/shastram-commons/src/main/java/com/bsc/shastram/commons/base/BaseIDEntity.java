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

import javax.persistence.*;
import java.io.Serializable;
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
		createdTimestamp = date.getTime();
		updatedTimestamp = date.getTime();

	}

	protected String updatedBy;
	protected String createdBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date createdOn;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
