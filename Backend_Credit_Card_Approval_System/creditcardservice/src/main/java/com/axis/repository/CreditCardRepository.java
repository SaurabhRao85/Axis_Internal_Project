package com.axis.repository;

import java.util.Optional;

import org.bson.types.ObjectId;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.axis.model.CreditCard;

public interface CreditCardRepository extends MongoRepository<CreditCard, ObjectId> {


	@Query("db.creditCards50.update({cardNumber:?0},{$set:{'cardNumber':?1,'holderName':?2,'cardType':?3,'accountNo':?4,'bank':?5,'branchName:':?6,'cvv':?7,'dailyLimit':?8,'status':?9}})")
	CreditCard updateCreditCardByCardNumber(long cardNumber);

    
	
	@Query("{cardNumber:?0}")
	Optional<CreditCard> getByCardNumber(long cardNumber);
	
	

	
	

	
	

}
