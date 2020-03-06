package com.sunflower.fingerprnt.model;

public class Credentials{
	private String email;
	private String password;
	private boolean rememberMe;

	public Credentials(String email, String password, boolean rememberMe) {
		this.email = email;
		this.password = password;
		this.rememberMe = rememberMe;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setRememberMe(boolean rememberMe){
		this.rememberMe = rememberMe;
	}

	public boolean isRememberMe(){
		return rememberMe;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"Credentials{" + 
			"password = '" + password + '\'' + 
			",remember_me = '" + rememberMe + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}
