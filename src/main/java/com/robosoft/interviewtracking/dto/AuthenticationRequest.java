package com.robosoft.interviewtracking.dto;

import java.io.Serializable;
import java.util.Collection;

import javax.management.loading.PrivateClassLoader;

import org.hibernate.secure.spi.GrantedPermission;

public class AuthenticationRequest implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public AuthenticationRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public AuthenticationRequest() {
		
	}


}
