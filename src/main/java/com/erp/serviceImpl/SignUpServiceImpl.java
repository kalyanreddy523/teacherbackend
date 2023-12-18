package com.erp.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.binding.LoginForm;
import com.erp.binding.SignUpForm;
import com.erp.entity.SignUpEntity;
import com.erp.repository.SignUpRepo;
import com.erp.service.SignUpService;

@Service
public class SignUpServiceImpl implements SignUpService{
	
	@Autowired
	private SignUpRepo repo;

	@Override
	public String signUp(SignUpForm form) {
	    if (form.getPwd().equals(form.getConfirmPwd())) {
	        if (!repo.existsByEmail(form.getEmail())) {
	            SignUpEntity entity = new SignUpEntity();
	            BeanUtils.copyProperties(form, entity);
	            repo.save(entity);
	            return "Signup successful";
	        } else {
	            return "Email already exists";
	        }
	    }
	    return "Password and confirm password do not match";
	}


	@Override
	public String login(LoginForm form) {
		
		SignUpEntity emailAndPwd = repo.findByEmailAndPwd(form.getEmail(), form.getPwd());
		
		if (emailAndPwd == null) {
			return "invalid credintial";
		}
		return " sucess";
	}

}
