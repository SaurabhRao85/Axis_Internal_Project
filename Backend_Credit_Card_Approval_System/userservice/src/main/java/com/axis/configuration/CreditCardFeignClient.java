package com.axis.configuration;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.axis.dto.CreditCardDto;
import com.axis.dto.UserDto;


@FeignClient(name = "creditcardclient",url = "http://localhost:8095/api/CreditCard")
public interface CreditCardFeignClient {

	@GetMapping("/creditCards")
	List<CreditCardDto> getAllCreditCard();
	
	@GetMapping("/CardNumber/{cardNumber}")
	CreditCardDto getCreditCardById(@PathVariable  long cardNumber);

	
}
