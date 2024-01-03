package com.TSH.service;

import com.TSH.LoginResopnse.LoginMesage;
import com.TSH.binding.LoginForm;
import com.TSH.binding.registation;
import com.TSH.entity.Login;
import com.TSH.entity.LoginResponse;
import com.TSH.entity.rigistationEntity;

public interface rigistationService 
{

	   String signUp(registation form);

	   LoginResponse loginUser(LoginForm form);
	
//	     //method to Login User
//		com.TSH.LoginResopnse.LoginMesage loginUser(Login login);
		
		//method to reset password
		LoginMesage resetPassword(Login login);
		
		//changing password by using otp
		LoginMesage password(Login login);
		
		// This method is useful for frontend profile update
		rigistationEntity updateUser(rigistationEntity model, Long id);

		String deleteUserById(Long userId);     

}

