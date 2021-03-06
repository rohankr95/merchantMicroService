package com.example.Merchant.dto;

import com.example.Merchant.dto.MerchantPriQuaDetails;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;


public class Product {
//required to send data to products table
        private String _id;
        private String productName;
        private int productQuantity;
        private float productPrice;
        private String productImage;
        private String productCategory;
        private HashMap<Integer,MerchantPriQuaDetails> merSpecDetails;
        //merchantId,details

        public String getProductId() {
            return _id;
        }

        public void setProductId(String productId) {
            this._id = productId;
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
    }


