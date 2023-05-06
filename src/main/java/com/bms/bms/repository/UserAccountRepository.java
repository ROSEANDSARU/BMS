package com.bms.bms.repository;

import com.bms.bms.model.UserAccountModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserAccountRepository extends MongoRepository<UserAccountModel, String> {

}
