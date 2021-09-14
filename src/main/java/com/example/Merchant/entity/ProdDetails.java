package com.example.Merchant.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProdDetails {
    @Id
    private String prodDetailsId;
    private int availble;
    private int sold;
    private int ratings;

    public int getAvailble() {
        return availble;
    }

    public void setAvailble(int availble) {
        this.availble = availble;
    }

    public int getSold() {
        return sold;
    }

    public String getProdDetailsId() {
        return prodDetailsId;
    }

    public void setProdDetailsId(String prodDetailsId) {
        this.prodDetailsId = prodDetailsId;
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

    @Override
    public String toString() {
        return "Quantity Available: "+this.getAvailble()+" , Sold: "+this.getSold()+" ,"+"Ratings"+this.getRatings();
    }
}
