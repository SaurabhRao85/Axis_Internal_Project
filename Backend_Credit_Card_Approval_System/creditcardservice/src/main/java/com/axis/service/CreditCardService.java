package com.axis.service;

import java.util.List;

import com.axis.dto.CreditCardDto;

public interface CreditCardService {

	CreditCardDto addCreditCard(CreditCardDto creditCardDto);
	List<CreditCardDto> getAllCreditCard();
	CreditCardDto updateCreditCardByCardNumber(long cardNumber, CreditCardDto creditCardDto);
    CreditCardDto getCreditCardByCardNumber(long cardNumber);
	void deleteCreditCardByCardNumber(long cardNumber);

      
    
}
