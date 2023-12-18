package com.erp.binding;

import lombok.Data;

@Data
public class SignUpForm {
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Long phno;

	private String pwd;
	
	private String confirmPwd;
	
	private String company;
	
	private String address;
	
	

}
