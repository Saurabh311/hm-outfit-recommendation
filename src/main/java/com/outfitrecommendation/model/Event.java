package com.outfitrecommendation.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eventId;
    private String eventName;
    @ManyToMany
    @JoinTable(name = "event_category", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<ProductCategory> productCategories;

    // Constructors
    public Event(long id, String eventName, ArrayList<ProductCategory> productCategories) {
        this.eventId = id;
        this.eventName = eventName;
        this.productCategories = productCategories;
    }

    public Event() {
    }

    // getters and setters
    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }
}
