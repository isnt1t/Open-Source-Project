package com.example.project.model;

public class Product {
    private int id;
    private String cvs_name;
    private String product_name;
    private String product_category;
    private int price;
    private String plus;
    private String image;

    public Product(int id, String cvs_name, String product_name, String product_category, int price, String plus, String image) {
        this.id = id;
        this.cvs_name = cvs_name;
        this.product_name = product_name;
        this.product_category = product_category;
        this.price = price;
        this.plus = plus;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCvs_name() {
        return cvs_name;
    }

    public void setCvs_name(String cvs_name) {
        this.cvs_name = cvs_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPlus() {
        return plus;
    }

    public void setPlus(String plus) {
        this.plus = plus;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
