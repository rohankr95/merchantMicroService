package com.example.Merchant.service.impl;

import com.example.Merchant.entity.ProdDetails;
import com.example.Merchant.repository.ProdDetailsRepository;
import com.example.Merchant.service.ProdDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProdDetailsServiceImpl implements ProdDetailsService {


    @Autowired
    ProdDetailsRepository prodDetailsRepository;

    @Override
    public ProdDetails get(String id) {
        return prodDetailsRepository.findById(id).get();
    }

    @Override
    public ProdDetails save(ProdDetails prodDetails) {
        return prodDetailsRepository.save(prodDetails);
    }

    @Override
    public ProdDetails update(ProdDetails prodDetails) {
        return prodDetailsRepository.save(prodDetails);
    }

    @Override
    public void delete(String id) {
prodDetailsRepository.deleteById(id);
    }
}

