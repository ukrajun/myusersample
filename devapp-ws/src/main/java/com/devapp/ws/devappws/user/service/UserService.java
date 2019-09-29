package com.devapp.ws.devappws.user.service;


import java.util.List;

import com.devapp.ws.devappws.ui.model.response.OperationStatus;
import com.devapp.ws.devappws.user.dto.UserDto;
import com.devapp.ws.devappws.user.exception.DataValidationException;


public interface UserService {

	UserDto createUser(UserDto userDto) throws DataValidationException;

	UserDto getUserDetailsByUserId(String userId);

	UserDto updateUser(UserDto userDto);

	OperationStatus deleteUser(String id);

	List<UserDto> getUsers(int page, int limit);

}
