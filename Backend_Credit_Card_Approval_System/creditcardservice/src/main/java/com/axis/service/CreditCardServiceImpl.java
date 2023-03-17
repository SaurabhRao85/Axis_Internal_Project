package com.axis.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dto.CreditCardDto;
import com.axis.dto.UserDto;
import com.axis.exception.CardNumberNotFoundException;
import com.axis.exception.CardStatusException;
import com.axis.exception.IdNotFoundException;
import com.axis.exception.InValidDailyLimitException;
import com.axis.model.CreditCard;
import com.axis.model.User;
import com.axis.repository.CreditCardRepository;
import com.axis.repository.UserRepository;
import com.axis.utility.AppConstant;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	CreditCardRepository creditCardRepository;
	
	@Autowired
	UserRepository userRepository;
	

	@Override
	public CreditCardDto addCreditCard(CreditCardDto creditCardDto) {
		
		return convertToDto(creditCardRepository.save(convertToEntity(creditCardDto)));
	}

	
	@Override
	public List<CreditCardDto> getAllCreditCard() {
		
		List<CreditCard> creditCards=	creditCardRepository.findAll();
		
		List<CreditCardDto> creditCardDtos = new ArrayList<CreditCardDto>();
		
		for(CreditCard creditCard :creditCards)
		{
			creditCardDtos.add(convertToDto(creditCard));
		}
			
		return creditCardDtos;
	}

	
	@Override
	public CreditCardDto getCreditCardByCardNumber(long cardNumber) {
		Optional<CreditCard> optCreditCard = creditCardRepository.getByCardNumber(cardNumber);
	     
		   if(optCreditCard.isPresent())
			   return convertToDto(optCreditCard.get());
		   else   
		      throw new CardNumberNotFoundException(AppConstant.CARD_NUMBER_NOT_FOUND_MESSAGE);
	}

	
	
	@Override
	public CreditCardDto updateCreditCardByCardNumber(long cardNumber, CreditCardDto creditCardDto) {
		Optional<CreditCard> optCreditCard = creditCardRepository.getByCardNumber(cardNumber);
	     
		   if(optCreditCard.isPresent()) {
			   creditCardDto.setId(optCreditCard.get().getId());
			   return convertToDto(creditCardRepository.save(convertToEntity(creditCardDto)));
		   }
		   else   
		      throw new IdNotFoundException(AppConstant.CARD_NUMBER_NOT_FOUND_MESSAGE);
	}

	



	@Override
	public void deleteCreditCardByCardNumber(long cardNumber) {
		CreditCard creditCard = creditCardRepository.getByCardNumber(cardNumber).
				orElseThrow(() -> new CardNumberNotFoundException(AppConstant.CARD_NUMBER_NOT_FOUND_MESSAGE +cardNumber));
		
		creditCardRepository.delete(creditCard);
		
	}
	
	private CreditCardDto convertToDto(CreditCard creditCard)
	{
        
		CreditCardDto creditCardDto = new CreditCardDto();
		
		creditCardDto.setId(creditCard.getId());
		creditCardDto.setHolderName(creditCard.getHolderName());
		creditCardDto.setCardNumber(creditCard.getCardNumber());
		creditCardDto.setCardType(creditCard.getCardType());
		creditCardDto.setAccountNo(creditCard.getAccountNo());
		creditCardDto.setBank(creditCard.getBank());
		creditCardDto.setBranchName(creditCard.getBranchName());
		creditCardDto.setCvv(creditCard.getCvv());
		creditCardDto.setDailyLimit(creditCard.getDailyLimit());
		creditCardDto.setExpireDate(creditCard.getExpireDate());
		creditCardDto.setStatus(creditCard.getStatus());
		
		UserDto userDto = new UserDto();
		userDto.setId(creditCard.getUser().getId());
		userDto.setHolderName(creditCard.getUser().getHolderName());
		userDto.setAge(creditCard.getUser().getAge());
		userDto.setPhoneNumber(creditCard.getUser().getPhoneNumber());
		userDto.setEmail(creditCard.getUser().getEmail());
		userDto.setMonthlyIncome(creditCard.getUser().getMonthlyIncome());
		userDto.setAddress(creditCard.getUser().getAddress());
		userDto.setCity(creditCard.getUser().getCity());
		userDto.setState(creditCard.getUser().getState());
		userDto.setCountry(creditCard.getUser().getCountry());
		userDto.setPincode(creditCard.getUser().getPincode());
		userDto.setCreatedAt(creditCard.getUser().getCreatedAt());
		
        creditCardDto.setUserDto(userDto);
		
		return creditCardDto;
	}
	
	private CreditCard convertToEntity(CreditCardDto creditCardDto)
	{
		CreditCard creditCard = new CreditCard();
		creditCard.setId(creditCardDto.getId());
		creditCard.setHolderName(creditCardDto.getHolderName());
		creditCard.setCardNumber(generatecardNumber());
		creditCard.setCardType(creditCardDto.getCardType());
		creditCard.setAccountNo(creditCardDto.getAccountNo());
		creditCard.setBank(creditCardDto.getBank());
		creditCard.setBranchName(creditCardDto.getBranchName());
		creditCard.setCvv(creditCardDto.getCvv());
		creditCard.setDailyLimit(creditCardDto.getDailyLimit());
		creditCard.setExpireDate(creditCardDto.getExpireDate());
		creditCard.setStatus(creditCardDto.getStatus());
          
			 User user = new User();
	         user.setId(creditCardDto.getUserDto().getId());
	         user.setHolderName(creditCardDto.getUserDto().getHolderName());
	 		user.setAge(creditCardDto.getUserDto().getAge());
	 		user.setPhoneNumber(creditCardDto.getUserDto().getPhoneNumber());
	 		user.setEmail(creditCardDto.getUserDto().getEmail());
	 		user.setMonthlyIncome(creditCardDto.getUserDto().getMonthlyIncome());
	 		user.setAddress(creditCardDto.getUserDto().getAddress());
	 		user.setCity(creditCardDto.getUserDto().getCity());
	 		user.setState(creditCardDto.getUserDto().getState());
	 		user.setCountry(creditCardDto.getUserDto().getCountry());
	 		user.setPincode(creditCardDto.getUserDto().getPincode());
	 		user.setCreatedAt(creditCardDto.getUserDto().getCreatedAt());
	 	
	        creditCard.setUser(user);
			
			return creditCard;
			
		}




private long generatecardNumber() {
	long cardNumber =0l;
	Random rand = new Random();
	
	cardNumber = (rand.nextLong(1000000)+1000000000000000l)+(rand.nextInt(900)+100);
	System.out.println(cardNumber);
	return cardNumber;
}
	

	



	
		
	

	
	

}
