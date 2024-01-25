package com.quiznestserver.model;

public class JwtResponse {
	
	private User user;
	private String token;

	/**
	 * @param token
	 */
	public JwtResponse(User user, String token) {
		this.user = user;
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

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
