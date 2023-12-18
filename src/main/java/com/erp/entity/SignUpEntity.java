package com.erp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "SINGUP_TAB")
public class SignUpEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer snoId;

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
	private Long phno;


	@NotBlank(message = "Password should not be empty.")
	@Size(min = 6, message = "password should be atleast 6 characters")
	@Size(max = 15, message = "password should not be greater than 16 characters")
	@Column(name = "PASSWORD")
	private String pwd;

	@NotBlank(message = "confirmPwd should not be empty.")
	@Size(min = 6, message = "password should be atleast 6 characters")
	@Column(name = "CONFIRM_PASSWORD")
	@Size(max = 15, message = "confirmPwd should not be greater than 16 characters")
	private String confirmPwd;

	@NotBlank(message = "company should not be empty.")
	@Column(name = "COMPANY")
	private String company;

	@NotBlank(message = "address should not be empty.")
	@Column(name = "ADDRESS")
	private String address;

}
