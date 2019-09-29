package com.devapp.ws.devappws.user.dto;

import java.io.Serializable;
import java.util.List;

import com.devapp.ws.devappws.ui.model.request.AddressRequestModel;

public class UserDto implements Serializable{
	
	private static final long serialVersionUID = -3124495965948452532L;
	
	private String userId ;
	private String firstName;
	private String lastName;
	private String email ;
	private String password ;
	
	private String encryptedPassword;
	
	private boolean emailVerficationStatus = false;
	
	private List<AddressDto> addresses ;
	
	public List<AddressDto> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressDto> addresses) {
		this.addresses = addresses;
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
