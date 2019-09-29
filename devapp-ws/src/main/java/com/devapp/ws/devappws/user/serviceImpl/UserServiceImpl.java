package com.devapp.ws.devappws.user.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.transform.ToListResultTransformer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devapp.ws.devappws.ui.model.response.OperationStatus;
import com.devapp.ws.devappws.user.dto.UserDto;
import com.devapp.ws.devappws.user.entity.User;
import com.devapp.ws.devappws.user.exception.DataValidationException;
import com.devapp.ws.devappws.user.repositories.UserDetailsRepository;
import com.devapp.ws.devappws.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Override
	public UserDto createUser(UserDto userDto) throws DataValidationException {
		
		if(userDetailsRepository.findByEmail(userDto.getEmail()) != null)
			throw new DataValidationException("Duplicate record");

		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		user.setUserId("testuser"+Math.random());
		user.setPassword("testpassword"+Math.random());
		
		user = userDetailsRepository.save(user);
		
		UserDto storedUser = new UserDto();
		BeanUtils.copyProperties(user,storedUser);
		
		return storedUser;
	}

	@Override
	public UserDto getUserDetailsByUserId(String userId) {
		
		User user = userDetailsRepository.findByUserId(userId);
		
		UserDto returnUser = new UserDto();
		BeanUtils.copyProperties(user,returnUser);
		return returnUser;
	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		
		User user = userDetailsRepository.findByUserId(userDto.getUserId());
	
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		
		user = userDetailsRepository.save(user);
		
		UserDto storedUser = new UserDto();
		BeanUtils.copyProperties(user,storedUser);
		
		return storedUser;
	}

	@Override
	public OperationStatus deleteUser(String userId) {
		OperationStatus operationStatus =new OperationStatus();
		operationStatus.setOperationName("DELETE");
		operationStatus.setOperationStatus("SUCCESS");
		User user = userDetailsRepository.findByUserId(userId);
		userDetailsRepository.delete(user);
		return operationStatus;
	}

	@Override
	public List<UserDto> getUsers(int page, int limit) {
		// TODO Auto-generated method stub
		
		 List<UserDto> userDtos = new ArrayList<>();
		 List<User> users = new ArrayList<>();
		 
		 Page<User> userList= userDetailsRepository.findAll(PageRequest.of(page, limit));
		 users = userList.stream().collect(Collectors.toList());
		 
		 for (User user:  users) {
			 UserDto userDto= new UserDto();
			 BeanUtils.copyProperties(user, userDto);
			 userDtos.add(userDto);
		 }
		  
		return userDtos;
	}

}
