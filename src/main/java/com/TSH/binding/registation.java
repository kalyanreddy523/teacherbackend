package com.TSH.binding;

import lombok.Data;

@Data
public class registation {

	private String firstName;

	private String lastName;

	private String email;

	private String mobileNumber;

	private String password;

	private String confirmPassword;

	private String address;

	private String JobClassification;

	private String Qualification;
	
	private String YearsofExperience;
	
	private String ExpertiseIn;
	
	private String  Languages;
	
	private String Proficiency;
	
	private String ExpectedSalary;
	
	private String InterestedIn;
	
	private String Resume;
	
	private String Declaimer;
	
	private String Photo;
	

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public registation(String firstName, String lastName, String email, String mobileNumber, String password,
			String confirmPassword, String address, String country, String state, String Declaimer, String ExpectedSalary, String ExpertiseIn, String InterestedIn, String JobClassification, String Languages, String Proficiency, String Photo, String Qualification, String Resume, String YearsofExperience) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.address = address;
		this.Declaimer=Declaimer;
		this.ExpectedSalary=ExpectedSalary;
		this.ExpertiseIn=ExpertiseIn;
		this.InterestedIn=InterestedIn;
		this.JobClassification=JobClassification;
		this.Languages=Languages;
		this.Proficiency =Proficiency; 
		this.Photo=Photo;
		this.Qualification=Qualification;
		this.Resume=Resume;
		this.YearsofExperience=YearsofExperience;
		}

	public registation() {
	}

	public String getJobClassification() {
		return JobClassification;
	}

	public void setJobClassification(String jobClassification) {
		JobClassification = jobClassification;
	}

	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String qualification) {
		Qualification = qualification;
	}

	public String getYearsofExperience() {
		return YearsofExperience;
	}

	public void setYearsofExperience(String yearsofExperience) {
		YearsofExperience = yearsofExperience;
	}

	public String getExpertiseIn() {
		return ExpertiseIn;
	}

	public void setExpertiseIn(String expertiseIn) {
		ExpertiseIn = expertiseIn;
	}

	public String getLanguages() {
		return Languages;
	}

	public void setLanguages(String languages) {
		Languages = languages;
	}

	public String getProficiency() {
		return Proficiency;
	}

	public void setProficiency(String proficiency) {
		Proficiency = proficiency;
	}

	public String getExpectedSalary() {
		return ExpectedSalary;
	}

	public void setExpectedSalary(String expectedSalary) {
		ExpectedSalary = expectedSalary;
	}

	public String getInterestedIn() {
		return InterestedIn;
	}

	public void setInterestedIn(String interestedIn) {
		InterestedIn = interestedIn;
	}

	public String getResume() {
		return Resume;
	}

	public void setResume(String resume) {
		Resume = resume;
	}

	public String getDeclaimer() {
		return Declaimer;
	}

	public void setDeclaimer(String declaimer) {
		Declaimer = declaimer;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

}
