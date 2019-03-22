package com.adidas.challenge.jwtcommon;


/**
 * POJO class for User used for log in.
 * @author Gaurav Kumar
 *
 */
public class User {
    private String username;
    private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}