package com.axis.repository;

import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.axis.dto.UserDto;
import com.axis.model.User;

public interface UserRepository extends MongoRepository<User, ObjectId>{


	@Query("{holderName:?0}")
	Optional<User> findByHolderName(String holderName);


	UserDto save(UserDto userDto);

	@Query("{city:?0}")
	Optional<User> getUserByCity(String city);

	@Query("{phoneNumber:?0}")
	Optional<User> getByPhoneNumber(long phoneNumber);
	

	
	

}
