package com.example.Merchant.repository;

import com.example.Merchant.entity.ProdDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdDetailsRepository extends MongoRepository<ProdDetails,String> {
}
