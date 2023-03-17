package com.axis.configuration;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.axis.dto.UserDto;

@FeignClient(name = "userclient",url = "http://localhost:8094/api/users")
public interface UserFeignClient {

	@GetMapping("/userslist")
	List<UserDto> getAllUsers();
	
	@GetMapping("/id/{id}")
	UserDto getUserById(@PathVariable ObjectId id);
}
