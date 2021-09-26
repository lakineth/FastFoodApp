package com.example.product;

public class FoodModel {

    String PID;
    String name;
    String price;
    String description;
    String category;

    public FoodModel(String PID, String name, String price, String description, String category) {
        this.PID = PID;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public FoodModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

}
