package com.axis.service;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dto.CreditCardDto;
import com.axis.dto.UserDto;
import com.axis.exception.IdNotFoundException;
import com.axis.exception.InValidCityException;
import com.axis.exception.InValidIncomeException;
import com.axis.exception.PhoneNumberNotFoundException;
import com.axis.model.CreditCard;
import com.axis.model.User;
import com.axis.repository.CreditCardRepository;
import com.axis.repository.UserRepository;
import com.axis.utility.AppConstant;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CreditCardRepository creditCardRepository;
	

	@Override
	public UserDto addUser(UserDto userDto) {
		if(userDto.getMonthlyIncome()<15000)
			throw new InValidIncomeException(AppConstant.INVALID_INCOME_MESSAGE);
        
		return convertToDto(userRepository.save(convertToEntity(userDto)));
	}

	@Override
	public List<UserDto> getAllUser() {
		
		List<User> users=	userRepository.findAll();
		
		List<UserDto> userDtos = new ArrayList<UserDto>();
		
		for(User user :users)
		{
			userDtos.add(convertToDto(user));
		}
			
			return userDtos;
	}

	@Override
	public UserDto getUserById(ObjectId id) {
		
		Optional<User> optUser = userRepository.findById(id);
	     
		   if(optUser.isPresent())
			   return convertToDto(optUser.get());
		   else   
		      throw new IdNotFoundException(AppConstant.ID_NOT_FOUND_MESSAGE);
	}
	
	@Override
	public UserDto updateUserById(ObjectId id, UserDto userDto) {
		
		Optional<User> optUser = userRepository.findById(id);
	     
		   if(optUser.isPresent()) {
			   userDto.setId(optUser.get().getId());
			   return convertToDto(userRepository.save(convertToEntity(userDto)));
		   }
		   else   
		      throw new IdNotFoundException(AppConstant.ID_NOT_FOUND_MESSAGE);
	}

	@Override
	public void deleteUserById(ObjectId id) {
		
		User user = userRepository.findById(id).
				orElseThrow(() -> new IdNotFoundException(AppConstant.NOT_FOUND_MESSAGE +id));
		
		userRepository.delete(user);
	}
	
	@Override
	public UserDto getUserByPhoneNumber(long phoneNumber) {
		Optional<User> optUser = userRepository.getByPhoneNumber(phoneNumber);
	     
		   if(optUser.isPresent())
			   return convertToDto(optUser.get());
		   else   
		      throw new PhoneNumberNotFoundException(AppConstant.PHONE_NUMBER_NOT_FOUND_MESSAGE +phoneNumber);
	}
	
	@Override
	public UserDto getUserByCity(String city) {
		Optional<User> optUser = userRepository.getUserByCity(city);
	     
		   if(optUser.isPresent())
			   return convertToDto(optUser.get());
		   else   
		      throw new InValidCityException(AppConstant.CITY_NOT_FOUND_MESSAGE);
	}

	@Override
	public UserDto updateUserByPhoneNumber(long phoneNumber, UserDto userDto) {
		Optional<User> optUser = userRepository.getByPhoneNumber(phoneNumber);
	     
		   if(optUser.isPresent()) {
			   userDto.setId(optUser.get().getId());
			   return convertToDto(userRepository.save(convertToEntity(userDto)));
		   }
		   else   
		      throw new PhoneNumberNotFoundException(AppConstant.PHONE_NUMBER_NOT_FOUND_MESSAGE);
	}

	
   private UserDto convertToDto(User user) {
		
		UserDto userDto = new UserDto();
		
		userDto.setId(user.getId());
		userDto.setHolderName(user.getHolderName());
		userDto.setAge(user.getAge());
		userDto.setPhoneNumber(user.getPhoneNumber());
		userDto.setEmail(user.getEmail());
		userDto.setMonthlyIncome(user.getMonthlyIncome());
		userDto.setAddress(user.getAddress());
		userDto.setCity(user.getCity());
		userDto.setState(user.getState());
		userDto.setCountry(user.getCountry());
		userDto.setPincode(user.getPincode());
		userDto.setCreatedAt(user.getCreatedAt());

		CreditCardDto creditCardDto = new CreditCardDto();
		creditCardDto.setId(user.getCreditCard().getId());
		creditCardDto.setHolderName(user.getCreditCard().getHolderName());
		creditCardDto.setCardNumber(user.getCreditCard().getCardNumber());
		creditCardDto.setAccountNo(user.getCreditCard().getAccountNo());
		creditCardDto.setCardType(user.getCreditCard().getCardType());
		creditCardDto.setDailyLimit(user.getCreditCard().getDailyLimit());
		creditCardDto.setCvv(user.getCreditCard().getCvv());
		creditCardDto.setBank(user.getCreditCard().getBank());
		creditCardDto.setBranchName(user.getCreditCard().getBranchName());
		creditCardDto.setExpireDate(user.getCreditCard().getExpireDate());
		creditCardDto.setStatus(user.getCreditCard().getStatus());
		
		userDto.setCreditCardDto(creditCardDto);
		
		return userDto;
	}
	
		
		private User convertToEntity(UserDto userDto) {
			
			User user = new User();

			user.setId(userDto.getId());
			user.setHolderName(userDto.getHolderName());
			user.setPhoneNumber(userDto.getPhoneNumber());
			user.setAge(userDto.getAge());
			user.setEmail(userDto.getEmail());
			user.setMonthlyIncome(userDto.getMonthlyIncome());
			user.setAddress(userDto.getAddress());
			user.setCity(userDto.getCity());
			user.setState(userDto.getState());
			user.setCountry(userDto.getCountry());
			user.setPincode(userDto.getPincode());
			user.setCreatedAt(userDto.getCreatedAt());
			

	            CreditCard creditCard = new CreditCard();
	 
	            creditCard.setId(userDto.getCreditCardDto().getId());
	    		creditCard.setCardNumber(generatecardNumber());
	    		creditCard.setHolderName(userDto.getCreditCardDto().getHolderName());
	    		creditCard.setCardType(userDto.getCreditCardDto().getCardType());
	    		creditCard.setCvv(generatecvv());
	    		creditCard.setAccountNo(userDto.getCreditCardDto().getAccountNo());
	    		creditCard.setDailyLimit(userDto.getCreditCardDto().getDailyLimit());
	    		creditCard.setBank(userDto.getCreditCardDto().getBank());
	    		creditCard.setBranchName(userDto.getCreditCardDto().getBranchName());
	    		creditCard.setExpireDate(userDto.getCreditCardDto().getExpireDate());
	    		creditCard.setStatus(userDto.getCreditCardDto().getStatus());
	            
	        user.setCreditCard(creditCard);
			
			return user;
		}

		
		private long generatecardNumber() {
			long cardNumber =0l;
			Random rand = new Random();
			
			cardNumber = (rand.nextLong(1000000)+1000000000000000l)+(rand.nextInt(900)+100);
			System.out.println(cardNumber);
			return cardNumber;
		}
			
		private int generatecvv() {
			int cvv=0;
			Random rand = new Random();
			
			cvv = (rand.nextInt(900)+100);
			System.out.println(cvv);
			return cvv;
		}
		
		
		

	
}
