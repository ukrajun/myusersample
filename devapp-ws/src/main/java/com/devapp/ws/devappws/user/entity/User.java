package com.devapp.ws.devappws.user.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.devapp.ws.devappws.user.dto.AddressDto;


@Entity(name = "USERS")
public class User implements Serializable{

	private static final long serialVersionUID = -6909749907865905897L;
	
	@Id
	@GeneratedValue
	private Long Id;
	
	@Column(nullable = false, length = 50)
	private String userId ;
	
	@Column(nullable = false, length = 50)
	private String firstName;
	
	@Column(nullable = false, length = 50)
	private String lastName;
	
	@Column(nullable = false, length = 150, unique=true)
	private String email ;
	
	@Column(nullable = false)
	private String password ;
	
	private String encryptedPassword;
	
	private boolean emailVerficationStatus = false;
	
	private List<AddressEntity> addresses ;
	
	public List<AddressEntity> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressEntity> addresses) {
		this.addresses = addresses;
	}

	public Long getId() {
		return Id;
	}
	
	public void setId(Long id) {
		Id = id;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public boolean isEmailVerficationStatus() {
		return emailVerficationStatus;
	}

	public void setEmailVerficationStatus(boolean emailVerficationStatus) {
		this.emailVerficationStatus = emailVerficationStatus;
	}

}
