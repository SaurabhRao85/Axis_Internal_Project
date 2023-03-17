package com.axis.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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

import com.axis.configuration.UserFeignClient;
import com.axis.dto.CreditCardDto;
import com.axis.dto.UserDto;
import com.axis.service.CreditCardService;
import com.axis.utility.AppConstant;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/CreditCard")
public class CreditCardController {

	@Autowired
	CreditCardService creditCardService;
	
	@Autowired
	UserFeignClient userFeignClient;
	
	@PostMapping("/creditCard")
	public ResponseEntity<CreditCardDto> addUser(@RequestBody CreditCardDto creditCardDto)
	{
		return new ResponseEntity<CreditCardDto>(creditCardService.addCreditCard(creditCardDto), HttpStatus.OK);
	}
	

	@GetMapping("/userslist")
	public ResponseEntity<List<UserDto>> addCreditCard()
	{
		return new ResponseEntity<List<UserDto>>(userFeignClient.getAllUsers(), HttpStatus.OK);
	}
	
	
	@GetMapping("/CardNumber/{cardNumber}")
	public ResponseEntity<CreditCardDto> getCreditCardByCardNumber(@PathVariable  long cardNumber)
	{
		return new ResponseEntity<CreditCardDto>(creditCardService.getCreditCardByCardNumber(cardNumber), HttpStatus.OK);
	}
	
	
	
	
	@PutMapping(value = "/CardNumber/{cardNumber}")
	public ResponseEntity<CreditCardDto> updateCreditCardByCardNumber(@PathVariable long cardNumber, @RequestBody CreditCardDto creditCardDto) {
		
		return new ResponseEntity<CreditCardDto>(creditCardService.updateCreditCardByCardNumber(cardNumber, creditCardDto),HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/CardNumber/{cardNumber}")
	public ResponseEntity<String> deleteCreditCardByCardNumber(@PathVariable long cardNumber) {
		
		creditCardService.deleteCreditCardByCardNumber(cardNumber);
		return new ResponseEntity<String>(AppConstant.DELETE_MESSAGE, HttpStatus.OK);
	}
}
