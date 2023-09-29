package com.gw.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserLoginRequest implements Serializable{
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
