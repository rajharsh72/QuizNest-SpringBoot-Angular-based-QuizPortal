package com.quiznestserver.model;

public class JwtRequest {
	
	private String email;
	private String password;
	
	public JwtRequest() {}
	
	/**
	 * @param email
	 * @param password
	 */
	public JwtRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
