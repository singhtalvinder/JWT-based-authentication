package com.singht.springjwt.security.domain;

import java.io.Serializable;

public class Response implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6798481726389828797L;
	
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Response(String message) {
		super();
		this.message = message;
	}
	

}
