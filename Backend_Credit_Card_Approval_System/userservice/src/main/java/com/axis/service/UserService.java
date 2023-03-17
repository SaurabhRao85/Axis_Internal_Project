package com.axis.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.axis.dto.UserDto;

public interface UserService {

	UserDto addUser(UserDto userDto);
	List<UserDto> getAllUser();
	UserDto getUserById(ObjectId id);
	UserDto updateUserById(ObjectId id, UserDto userDto);
    void deleteUserById(ObjectId id);
    UserDto getUserByCity(String city);
    UserDto getUserByPhoneNumber(long phoneNumber);
    UserDto updateUserByPhoneNumber(long phoneNumber, UserDto userDto);
}
