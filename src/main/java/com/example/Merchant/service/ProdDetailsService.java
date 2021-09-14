package com.example.Merchant.service;

import com.example.Merchant.entity.Merchant;
import com.example.Merchant.entity.ProdDetails;

public interface ProdDetailsService {
    public ProdDetails get(String id);
    public ProdDetails save(ProdDetails prodDetails);
    public ProdDetails update(ProdDetails prodDetails);
    public void delete(String id);
}
