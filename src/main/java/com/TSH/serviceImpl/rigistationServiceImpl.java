package com.TSH.serviceImpl;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.TSH.LoginResopnse.LoginMesage;
import com.TSH.binding.LoginForm;
import com.TSH.binding.registation;
import com.TSH.entity.Login;
import com.TSH.entity.LoginResponse;
import com.TSH.entity.rigistationEntity;
import com.TSH.repository.rigistationRepo;
import com.TSH.service.rigistationService;

@Service
public class rigistationServiceImpl implements rigistationService {

	@Autowired
	private rigistationRepo repo;

	@Autowired
	private JavaMailSender mailService;

	// Registration method
	@Override
	public String signUp(registation form) {
		if (form.getPassword().equals(form.getConfirmPassword())) {
			if (!repo.existsByEmail(form.getEmail())) {
				rigistationEntity entity = new rigistationEntity();
				BeanUtils.copyProperties(form, entity);
				repo.save(entity);
				return "Registration Successful";
			} else {
				return "Entered Email is Already Exists";
			}
		}
		return "Password and confirm password do not match";
	}

	// Login by Email / Phone Number.
	@Override
	public LoginResponse loginUser(LoginForm form) {
		rigistationEntity user = null;

		if (form.getIdentifier() != null) {
			// Check if the identifier is an email
			user = repo.findByEmailAndPassword(form.getIdentifier(), form.getPassword());

			// If not found, check if the identifier is a mobile number
			if (user == null) {
				user = repo.findByMobileNumberAndPassword(form.getIdentifier(), form.getPassword());
			}
		}

		if (user != null) {
			return new LoginResponse(true, "Login Successful", user.getUserId());
		} else {
			return new LoginResponse(false, "Invalid Credentials", null);
		}
	}

//	@Override
//	public boolean forgetpassword(String email) {
//		rigistationEntity findByEmail = repo.findByEmail(email);
//
//		if (findByEmail == null) {
//			return false;
//		}
//		String subject = "recover password";
//		String body = "your password::" + findByEmail.getPassword();
//		emailUtil.sendEmail(email, subject, body);
//		return true;
//
//	}

	// method to update the User using User-Id.

	@Override
	public rigistationEntity updateUser(rigistationEntity modal, Long userId) {
		Optional<rigistationEntity> userOptional = repo.findByUserId((long) userId);

		if (userOptional.isPresent()) {

			rigistationEntity userToBeUpdated = userOptional.get();
			// System.out.println("---> UserFromDB:"+userToBeUpdated);
			userToBeUpdated.setUserId(modal.getUserId());
			userToBeUpdated.setFirstName(modal.getFirstName());
			userToBeUpdated.setLastName(modal.getLastName());
			userToBeUpdated.setEmail(modal.getEmail());
			userToBeUpdated.setMobileNumber(modal.getMobileNumber());
			userToBeUpdated.setAddress(modal.getAddress());
			userToBeUpdated.setCountry(modal.getCountry());
			userToBeUpdated.setState(modal.getState());

			Encoder encoder = Base64.getEncoder();
			String encodepassword = encoder.encodeToString(modal.getPassword().getBytes());
			userToBeUpdated.setPassword(encodepassword);

			Encoder encoder1 = Base64.getEncoder();
			String encodeConformpassword = encoder1.encodeToString(modal.getConfirmPassword().getBytes());
			userToBeUpdated.setPassword(encodeConformpassword);

			repo.save(userToBeUpdated);
			return userToBeUpdated;
		}
		return userOptional.orElseThrow();
	}

	public String deleteUserById(Long userId) {
		Optional<rigistationEntity> companyOptional = repo.findByUserId(userId);

		if (companyOptional.isPresent()) {
			repo.deleteByUserId(userId);
			return "Successfully deleted";
		} else {
			return "User not found for ID: " + userId;
		}
	}

	// method to reset password if user forget their old password & Generate New
	// Password.
	String otp;
	Long id;

	public LoginMesage resetPassword(Login login) throws MailException {

		rigistationEntity mail1;
		mail1 = repo.findByEmail(login.getEmailId());

		if (mail1 != null) {
			String mail = mail1.getEmail();
			String m = login.getEmailId();

			if (mail.equals(m)) {
				SimpleMailMessage message = new SimpleMailMessage();
				message.setFrom("muppuri47@gmail.com");
				message.setTo(mail);
				message.setSubject("ERP Tally Website Reset Password ");
				Random random = new Random();
				otp = (Integer.toString(random.nextInt(999999)));
				String body = "Greetings From ERP Tally Website ......!\n You are Requested for Reset Password\n Please enter Your OTP .... "
						+ otp + " Don't Share This One Time Password ";
				message.setText(body);
				mailService.send(message);
				id = mail1.getUserId();
				return new LoginMesage("OTP Send to E-Mail check it Once", true);
			} else {
				return new LoginMesage("E-Mail Entered Not Matched With Data-Base E-mails Plz Try Again ", false);
			}
		} else {
			return new LoginMesage("E-Mail is Not Exist Plz Try Again ", false);
		}
	}

	// method to change password by using OTP

	public LoginMesage password(Login login) {

		if (login.getOtp().equals(otp)) {
			rigistationEntity mail1 = repo.findByEmail(login.getEmailId());

			Optional<rigistationEntity> model = repo.findByUserId(id);
			rigistationEntity models = model.get();
			String mail2 = models.getEmail();

//			  java.util.Base64.Encoder  encoder= Base64.getEncoder();
//			  String encodepassword=encoder.encodeToString(login.getPassword().getBytes());
//			  models.setPassword(encodepassword);

			models.setPassword(login.getPassword());

//			  java.util.Base64.Encoder  encoder1= Base64.getEncoder();
//			  String encodeConfirmpassword=encoder1.encodeToString(login.getConfirmPassword().getBytes());
//		       models.setConfirmPassword(encodeConfirmpassword);

			models.setConfirmPassword(login.getConfirmPassword());
			repo.save(models);

			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(mail2);
			message.setSubject("New Password For ERP Tally Website");
			Random random = new Random();
			int atIndex = mail2.indexOf('@');
			String username = mail2.substring(0, atIndex);
			String body = "Welcome To ERP Tally Website " + username + "\n You are New  Password is "
					+ login.getPassword() + " \nPlease be login with your New Password \n Don't Share this Password ";
			message.setText(body);
			mailService.send(message);

			return new LoginMesage("Password Reset Successfully", true);
		} else {
			return new LoginMesage("OTP is Incorrect  ", false);
		}
	}

	public boolean existsByEmail(String email) {
		return repo.existsByEmail(email);
	}

	public boolean existsByMobileNo(String mobileNo) {
		return repo.existsByMobileNumber(mobileNo);
	}
}