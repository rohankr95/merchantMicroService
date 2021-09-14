package com.example.Merchant.service;

import com.example.Merchant.entity.Merchant;

public interface MerchantService {
    public Merchant get(String id);
    public Merchant save(Merchant merchant);
    public Merchant update(Merchant merchant);
    public void delete(String id);
}
