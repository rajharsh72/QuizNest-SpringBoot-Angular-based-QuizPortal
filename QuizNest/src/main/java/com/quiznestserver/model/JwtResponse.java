package com.quiznestserver.model;

public class JwtResponse {
	
	private String token;

	/**
	 * @param token
	 */
	public JwtResponse(String token) {
		super();
		this.token = token;
	}
	
	public JwtResponse() {}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
