package com.example.project.model;

public class Product {
    private int id;
    private String name;
    private int price;
    private String cvs;
    private String image;
    private String plus;
    private String category;

    public Product(int id, String name, int price, String cvs, String image, String plus, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cvs = cvs;
        this.image = image;
        this.plus = plus;
        this.category = category;
    }

    public String getPlus() {
        return plus;
    }

    public void setPlus(String plus) {
        this.plus = plus;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) { this.price = price; }

    public String getCvs() {
        return cvs;
    }

    public void setCvs(String cvs) { this.cvs = cvs; }
}
