package com.rython.ILService.repository;

import com.rython.ILService.model.Il;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IlRepository extends MongoRepository<Il,String> {
}
