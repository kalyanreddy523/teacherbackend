package com.erp.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.binding.LoginForm;
import com.erp.binding.SignUpForm;
import com.erp.service.SignUpService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/erpTally")
public class SingUpController {

	@Autowired
	private SignUpService service;

	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@Valid @RequestBody SignUpForm  form) {
		String save = service.signUp(form);
		return new ResponseEntity<String>(save,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginForm form){
		String login = service.login(form);
		return new ResponseEntity<String>(login,HttpStatus.OK);
		
	}

}
