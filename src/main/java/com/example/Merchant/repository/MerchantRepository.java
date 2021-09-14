package com.example.Merchant.repository;

import com.example.Merchant.entity.Merchant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends MongoRepository<Merchant,String> {
}
