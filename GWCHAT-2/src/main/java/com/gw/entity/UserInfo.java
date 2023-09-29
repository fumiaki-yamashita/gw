package com.gw.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;



@Data
public class UserInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userid;
	private String nicname;
    private String password;
    private String repassword;
    private Date createdate;
    private Date updatedate;
}