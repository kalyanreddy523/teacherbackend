package com.erp.service;

import com.erp.binding.LoginForm;
import com.erp.binding.SignUpForm;

public interface SignUpService {
	
	public String signUp(SignUpForm form);
	
	public String login(LoginForm form);
	

}
