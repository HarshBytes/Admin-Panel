package com.example.adminpanel;

public class Datamodel {
    private String ProductName;
    private String ProductPrice;
    private String ProductURL;

    public Datamodel() {
        // Default constructor required for Firebase
    }

    public Datamodel(String productName, String productPrice, String productURL) {
        this.ProductName = productName;
        this.ProductPrice = productPrice;
        this.ProductURL = productURL;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        this.ProductName = productName;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        this.ProductPrice = productPrice;
    }

    public String getProductURL() {
        return ProductURL;
    }

    public void setProductURL(String productURL) {
        this.ProductURL = productURL;
    }
}
