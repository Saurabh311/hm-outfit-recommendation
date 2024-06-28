package com.outfitrecommendation.model;

import jakarta.persistence.*;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;
    private String name;
    private String category;
    private double price;
    private String brand;
    private String colour;
    private int stock;

    public Inventory() {
    }

    public Inventory(long id, String itemName, String category, int price, String brand, String colour, int stock) {
        this.itemId = id;
        this.name = itemName;
        this.category = category;
        this.price = price;
        this.brand = brand;
        this.colour = colour;
        this.stock = stock;
    }

    // getters and setters

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
