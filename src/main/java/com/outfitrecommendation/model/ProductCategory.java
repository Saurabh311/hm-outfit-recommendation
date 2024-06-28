package com.outfitrecommendation.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;
    @ManyToMany(mappedBy = "productCategories")
    private List<Event> eventList;
    @ManyToMany
    private List<Inventory> itemList;

    // constructors
    public ProductCategory(long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public ProductCategory() {
    }

    // getters and setters

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public List<Inventory> getItemList() {
        return itemList;
    }

    public void setItemList(List<Inventory> itemList) {
        this.itemList = itemList;
    }
}
