package com.TSH.binding;

public class LoginForm {
	private String identifier;
	private String password;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginForm(String identifier, String password) {
		this.identifier = identifier;
		this.password = password;
	}

	public LoginForm() {
	}

}
