package com.axis.controller;

import java.util.List;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.configuration.CreditCardFeignClient;
import com.axis.dto.UserDto;
import com.axis.service.UserService;
import com.axis.utility.AppConstant;

@RestController
@CrossOrigin(origins ="http://localhost:3000/")
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService userService;
	
	
	
	@PostMapping("/user")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto)
	{
		return new ResponseEntity<UserDto>(userService.addUser(userDto), HttpStatus.OK);
	}
	
	@GetMapping("/userslist")
	public ResponseEntity<List<UserDto>> getAllUser()
	{
		return new ResponseEntity<List<UserDto>>(userService.getAllUser(), HttpStatus.OK);
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable  ObjectId id)
	{
		return new ResponseEntity<UserDto>(userService.getUserById(id), HttpStatus.OK);
	}
	
	   @GetMapping("/phno/{phoneNumber}")
	    ResponseEntity<UserDto> getUserByPhoneNumber(@PathVariable  long phoneNumber)
	    {
	        return new ResponseEntity<UserDto>(userService.getUserByPhoneNumber(phoneNumber), HttpStatus.OK);
	    }
	  
	
	
	@PutMapping(value = "/userid/{id}")
	public ResponseEntity<UserDto> updateUserByUserID(@PathVariable ObjectId id, @RequestBody UserDto userDto) {
		
		return new ResponseEntity<UserDto>(userService.updateUserById(id, userDto),HttpStatus.OK);
	}
	
	@PutMapping(value = "/userphno/{phoneNumber}")
	public ResponseEntity<UserDto> updateUserByPhoneNumber(@PathVariable long phoneNumber, @RequestBody UserDto userDto) {
		
		return new ResponseEntity<UserDto>(userService.updateUserByPhoneNumber(phoneNumber, userDto),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable ObjectId id) {
		
		userService.deleteUserById(id);
		return new ResponseEntity<String>(AppConstant.DELETE_MESSAGE, HttpStatus.OK);
	}
}
