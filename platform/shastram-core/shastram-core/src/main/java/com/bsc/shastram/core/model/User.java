package com.bsc.shastram.core.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bsc.shastram.commons.model.base.BaseUser;

import lombok.Data;


@Table(name = "suser")
@Entity
@Data
public class User extends BaseUser {

}
