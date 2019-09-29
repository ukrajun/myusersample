package com.devapp.ws.devappws.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devapp.ws.devappws.ui.model.request.UserDetailsRequest;
import com.devapp.ws.devappws.ui.model.response.OperationStatus;
import com.devapp.ws.devappws.ui.model.response.UserDetailsResponse;
import com.devapp.ws.devappws.user.dto.UserDto;
import com.devapp.ws.devappws.user.exception.DataValidationException;
import com.devapp.ws.devappws.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersDetailsRestController {
	
	@Autowired
	UserService userService ;
	
	@GetMapping(path ="/{Id}")
	public UserDetailsResponse getUserDetails(@PathVariable String Id) {
		
		UserDto userDto = userService.getUserDetailsByUserId(Id);
		
		UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
		BeanUtils.copyProperties(userDto,userDetailsResponse);
		return userDetailsResponse;
	}
	
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<UserDetailsResponse> getUsers(@RequestParam (value = "page", defaultValue="0") int page,
			@RequestParam ( value="limit", defaultValue="20") int limit) {
		
		List<UserDetailsResponse> users = new ArrayList<>();
		List<UserDto> userDtos = new ArrayList<>();
		userDtos = userService.getUsers(page,limit);
		
		for (UserDto  userDto:  userDtos) {
			UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
			
			 BeanUtils.copyProperties(userDto, userDetailsResponse);
			 users.add(userDetailsResponse);
		 }
		return users;
	}
	
	@PostMapping( consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
				  produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	
	public UserDetailsResponse createUser(@RequestBody UserDetailsRequest userDetailsRequest ) throws DataValidationException {
		
		if(userDetailsRequest.getEmail().isEmpty()) {
			throw new DataValidationException ("Required Data missing");
		}
		UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetailsRequest, userDto);
		
		userDto = userService.createUser(userDto) ;
		
		BeanUtils.copyProperties(userDto,userDetailsResponse);
		
		return userDetailsResponse;
	}
	@PutMapping( value = "/{Id}",
				consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
				produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public UserDetailsResponse updateUserDetails(@PathVariable String Id, @RequestBody UserDetailsRequest userDetailsRequest)
			{
		
		UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
		UserDto userDto = new UserDto();
		userDto.setUserId(Id);
		userDto.setFirstName(userDetailsRequest.getFirstName());
		userDto.setLastName(userDetailsRequest.getLastName());
		
		userDto = userService.updateUser(userDto) ;
		
		BeanUtils.copyProperties(userDto,userDetailsResponse);
		
		return userDetailsResponse;
	}
	@DeleteMapping(path ="/{Id}",
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public OperationStatus deleteUser(@PathVariable String Id) {
		
		OperationStatus operationStatus = userService.deleteUser(Id) ;
		return operationStatus ;
	}

}
