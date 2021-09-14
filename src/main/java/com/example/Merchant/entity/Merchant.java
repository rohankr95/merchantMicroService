package com.example.Merchant.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document
public class Merchant {
    @Id
    private String _id;
    private String name;
//    private String password;
    private String username;
    private int ratings; // non editable by m
    private String image;
    private HashMap<String,ProdDetails> productsMap;
    //productid, prodDetails
    private int TotalProductsAvailble; //initialize it with products.size()

    public String get_id() {
        return _id;
    }


//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public Merchant() {
        this.productsMap = new HashMap<>();
    }

    public String getMerchantId() {
        return _id;
    }

    public void setMerchantId(String merchantId) {
        this._id = merchantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public HashMap<String, ProdDetails> getProductsMap() {
        return productsMap;
    }

    public void setProductsMap(HashMap<String, ProdDetails> productsMap) {
        this.productsMap = productsMap;
    }

    public int getTotalProductsAvailble() {
        return TotalProductsAvailble;
    }

    public void setTotalProductsAvailble(int totalProductsAvailble) {
        TotalProductsAvailble = totalProductsAvailble;
    }
}
