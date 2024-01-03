package com.TSH.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "registration", uniqueConstraints = { @UniqueConstraint(columnNames = { "EMAIL", "MOBILE_NO" }) })
public class rigistationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long userId;

	@NotBlank(message = "Please enter proper firstName name")
	@Size(min = 3, message = "firstName should be atleast 3 characters")
	@Size(max = 15, message = "firstName should not be greater than 15 characters")
	@Column(name = "FNAME")
	private String firstName;

	@NotBlank(message = "Please enter proper lastName name")
	@Size(min = 2, message = "lastName should be atleast 2 characters")
	@Size(max = 15, message = "lastName should not be greater than 15 characters")
	@Column(name = "LNAME")
	private String lastName;

	@NotBlank(message = "Please enter a valid email address.")
	@Email(message = "Please enter a valid email address.")
	@Size(max = 50, message = "Email should not be greater than 50 characters.")
	@Column(name = "EMAIL")
	private String email;

	@NotNull(message = "Mobile number must not be null.")
	@Digits(integer = 10, fraction = 0, message = "Mobile number must be numeric and have at most 10 digits.")
	@Column(name = "MOBILE_NO")
	private String mobileNumber;

	@NotBlank(message = "Password should not be empty.")
	@Size(min = 6, message = "password should be atleast 6 characters")
	//@Size(max = 15, message = "password should not be greater than 16 characters")
	@Column(name = "PASSWORD")
	private String password;

	@NotBlank(message = "confirmPwd should not be empty.")
	@Size(min = 6, message = "password should be atleast 6 characters")
	@Column(name = "CONFIRM_PASSWORD")
	@Size(max = 15, message = "confirmPwd should not be greater than 16 characters")
	private String confirmPassword;

	@NotBlank(message = "state should not be empty.")
	private String state;

	@NotBlank(message = "country should not be empty.")
	private String country;

	@NotBlank(message = "address should not be empty.")
	@Column(name = "ADDRESS")
	
	private String address;
	@NotBlank(message = "JobClassification should not be empty.")
	@Column(name = "JobClassification")
	
	private String JobClassification;
	@NotBlank(message = "Qualification should not be empty.")
	@Column(name = "Qualification")
	
	private String Qualification;
	
	@NotBlank(message = "Years of Experience should not be empty.")
	@Column(name = "YEARS OF EXPERIENCE")
	
	private String YearsOfExperience;
	
	@NotBlank(message = "Expertience should not be empty.")
	@Column(name = "Expertience")
	
	private String Expertience;
	
	@NotBlank(message = "Languages should not be empty.")
	@Column(name = "Languages")
	
	private String Languages;
	
	@NotBlank(message = "Proficiency should not be empty.")
	@Column(name = "Proficiency")
	
	private String Proficiency;
	
	@NotBlank(message = "ExpectedSalary should not be empty.")
	@Column(name = "ExpectedSalary")
	
	private String ExpectedSalary;
	
	@NotBlank(message = "InterestedIn should not be empty.")
	@Column(name = "InterestedIn")
	
	private String InterestedIn;
	
	@NotBlank(message = "Resume should not be empty.")
	@Column(name = "Resume")
	
	private String Resume;
	
	@NotBlank(message = "Declaimer should not be empty.")
	
	private String Declaimer;
	
	@NotBlank(message = "Photo should not be empty.")
	@Column(name = "Photo")
	
	private String Photo;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getJobClassification() {
		return JobClassification;
	}

	public void setJobClassification(String JobClassification) {
		this.JobClassification = JobClassification;
	}
	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String Qualification) {
		this.Qualification = Qualification;
	}
	public String getYearsOfExperience() {
		return YearsOfExperience;
	}

	public void setYearsOfExperience(String YearsOfExperience) {
		this.YearsOfExperience = YearsOfExperience;
	}
	
	public String getLanguages() {
		return Languages;
	}

	public void setLanguages(String Languages) {
		this.Languages = Languages;
	}
	public String getProficiency() {
		return Proficiency;
	}

	public void setProficiency(String Proficiency) {
		this.Proficiency = Proficiency;
	}
	public String getExpectedSalary() {
		return ExpectedSalary;
	}

	public void setExpectedSalary(String ExpectedSalary) {
		this.ExpectedSalary = ExpectedSalary;
	}
	public String getResume() {
		return Resume;
	}

	public void setResume(String Resume) {
		this.Resume = Resume;
	}
	public String getInterestedIn() {
		return InterestedIn;
	}

	public void setInterestedIn(String InterestedIn) {
		this.InterestedIn = InterestedIn;
	}
	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String Photo) {
		this.Photo = Photo;
	}
	public String getDeclaimer() {
		return Declaimer;
	}

	public void setDeclaimer(String Declaimer) {
		this.Declaimer = Declaimer;
	}

	public rigistationEntity(Long userId,
			@NotBlank(message = "Please enter proper firstName name") @Size(min = 3, message = "firstName should be atleast 3 characters") @Size(max = 15, message = "firstName should not be greater than 15 characters") String firstName,
			@NotBlank(message = "Please enter proper lastName name") @Size(min = 2, message = "lastName should be atleast 2 characters") @Size(max = 15, message = "lastName should not be greater than 15 characters") String lastName,
			@NotBlank(message = "Please enter a valid email address.") @Email(message = "Please enter a valid email address.") @Size(max = 50, message = "Email should not be greater than 50 characters.") String email,
			@NotNull(message = "Mobile number must not be null.") @Digits(integer = 10, fraction = 0, message = "Mobile number must be numeric and have at most 10 digits.") String mobileNumber,
			@NotBlank(message = "Password should not be empty.") @Size(min = 6, message = "password should be atleast 6 characters") @Size(max = 15, message = "password should not be greater than 16 characters") String password,
			@NotBlank(message = "confirmPwd should not be empty.") @Size(min = 6, message = "password should be atleast 6 characters") @Size(max = 15, message = "confirmPwd should not be greater than 16 characters") String confirmPassword,
			@NotBlank(message = "state should not be empty.") String state,
			@NotBlank(message = "country should not be empty.") String country,
			@NotBlank(message = "address should not be empty.") String address,
			@NotBlank(message = "Declaimer should not be empty.") String Declaimer, @NotBlank(message = "ExpectedSalary should not be empty.") String ExpectedSalary, 
			@NotBlank(message = "Expertience should not be empty.") String Expertience,
			@NotBlank(message = "InterestedIn should not be empty.") String InterestedIn, 
			@NotBlank(message = "JobClassification should not be empty.") String JobClassification,
			@NotBlank(message = "Languages should not be empty.") String Languages,
			@NotBlank(message = "Photo should not be empty.") String Photo,
			@NotBlank(message = "Proficiency should not be empty.") String Proficiency,
			@NotBlank(message = "Qualification should not be empty.") String Qualification,
			@NotBlank(message = "Resume should not be empty.") String Resume)
	
	{
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.state = state;
		this.country = country;
		this.address = address;
		this.Declaimer=Declaimer;
		this.ExpectedSalary=ExpectedSalary;
		this.Expertience=Expertience;
		this.InterestedIn=InterestedIn;
		this.JobClassification=JobClassification;
		this.Languages=Languages;
		this.Photo=Photo;
		this.Proficiency=Proficiency;
		this.Qualification=Qualification;
		this.Resume=Resume;
	}

	public rigistationEntity() {
	}

}
