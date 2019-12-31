package org.coody.reduce.vo;

import org.coody.framework.core.model.BaseModel;

@SuppressWarnings("serial")
public class UserLoginVO extends BaseModel{

	
	private String email;
	
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
