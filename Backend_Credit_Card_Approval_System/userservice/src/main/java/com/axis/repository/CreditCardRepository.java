package com.axis.repository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.axis.model.CreditCard;

public interface CreditCardRepository extends MongoRepository<CreditCard, ObjectId> {

}
