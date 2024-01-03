package com.TSH.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TSH.entity.rigistationEntity;

public interface rigistationRepo extends JpaRepository<rigistationEntity, Long> {

	public rigistationEntity findByEmailAndPassword(String email, String password);

	public rigistationEntity findByMobileNumberAndPassword(String mobile, String password);

	public boolean existsByEmail(String email);

	public rigistationEntity findByEmail(String email); 
		
	public rigistationEntity findByMobileNumber(String mobile);

	public Optional<rigistationEntity> findByUserId(long id);

	boolean existsByMobileNumber(String mobileNo);

	public String deleteByUserId(Long id);
	
}

