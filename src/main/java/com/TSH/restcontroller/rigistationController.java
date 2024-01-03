package com.TSH.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TSH.LoginResopnse.LoginMesage;
import com.TSH.binding.LoginForm;
import com.TSH.binding.registation;
import com.TSH.entity.Login;
import com.TSH.entity.LoginResponse;
import com.TSH.entity.rigistationEntity;
import com.TSH.service.rigistationService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/erpTally")
public class rigistationController {

	@Autowired
	private rigistationService service;

	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@Valid @RequestBody registation form) {
		String save = service.signUp(form);
		return new ResponseEntity<String>(save, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginForm form) {
		LoginResponse response = service.loginUser(form);
		if (response.isSuccess()) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
		}
	}

//	@GetMapping("/forgot/{email}")
//	public ResponseEntity<String> forgetPwd(@PathVariable String email) {
//		Boolean status = service.forgetpassword(email);
//		if (status) {
//			return new ResponseEntity<>("Password reset initiated. Check your email for further instructions.",
//					HttpStatus.OK);
//		}
//		return new ResponseEntity<>("Invalid Email. User not found.", HttpStatus.NOT_FOUND);
//	}
	
	@DeleteMapping("/company/{companyId}")
	public String deleteUserById(@PathVariable Long companyId) {
		return service.deleteUserById(companyId);
	}


	@PutMapping({ "/user/{userId}" })
	public ResponseEntity<rigistationEntity> updateUser(@PathVariable Long userId, @RequestBody rigistationEntity modal) {
		System.out.println("UserId is :"+userId);
		System.out.println("User:"+modal);
		service.updateUser(modal, userId);
		return new ResponseEntity<rigistationEntity>(modal, HttpStatus.ACCEPTED);
	}

		
//		@GetMapping("/email/{emailId}")
//		public rigistationEntity viewUserbyEmail(@PathVariable String emailId){
//			return service.getUserbyEmail(emailId);
//		}
//
			
	@PostMapping("/reset")
	public LoginMesage resetPassword(@RequestBody Login login ) {
		LoginMesage msg = service.resetPassword(login);
		return msg;
	}
		
	
	@PutMapping("/password")
	public LoginMesage newpassword(@RequestBody Login login) {
		LoginMesage msg = service.password(login);
		return msg;	
	}
			
	
	@PutMapping("/update/{userId}")
	public rigistationEntity updateUserEmail(@RequestBody rigistationEntity model,@PathVariable   Long userId) {
		  return service.updateUser(model, userId); 
	}
}