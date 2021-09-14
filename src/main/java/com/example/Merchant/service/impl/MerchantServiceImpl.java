package com.example.Merchant.service.impl;

import com.example.Merchant.entity.Merchant;
import com.example.Merchant.entity.ProdDetails;
import com.example.Merchant.repository.MerchantRepository;
import com.example.Merchant.repository.ProdDetailsRepository;
import com.example.Merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MerchantServiceImpl implements MerchantService {


    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public Merchant get(String id) {
        Optional<Merchant> merchant =  merchantRepository.findById(id);

        if(!merchant.isPresent())
            return null;
        return merchant.get();

    }

    @Override
    public Merchant save(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public Merchant update(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public void delete(String id) {
merchantRepository.deleteById(id);
    }
}
