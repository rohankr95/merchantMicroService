package com.example.Merchant.dto;

import java.util.HashMap;

public class ProductDto {
    private String _id;
    private String productName;
    private int productQuantity;
    private float productPrice;
    private String productImage;
    private String productCategory;
    private HashMap<Integer,MerchantPriQuaDetails> merSpecDetails;
    private int availble;
    private int sold;
    private int ratings;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public HashMap<Integer, MerchantPriQuaDetails> getMerSpecDetails() {
        return merSpecDetails;
    }

    public void setMerSpecDetails(HashMap<Integer, MerchantPriQuaDetails> merSpecDetails) {
        this.merSpecDetails = merSpecDetails;
    }

    public int getAvailble() {
        return availble;
    }

    public void setAvailble(int availble) {
        this.availble = availble;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
}
