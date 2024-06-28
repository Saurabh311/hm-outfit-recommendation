package com.outfitrecommendation.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recId;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private String eventName;
    @OneToMany
    private List<Inventory> items;

// constructors
    public Recommendation() {
    }

    public Recommendation(Customer customer, String eventName, List<Inventory> items) {
        this.customer = customer;
        this.eventName = eventName;
        this.items = items;
    }


// Getters and setters
    public Long getRecId() {
        return recId;
    }

    public void setRecId(Long recId) {
        this.recId = recId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public List<Inventory> getItems() {
        return items;
    }

    public void setItems(List<Inventory> items) {
        this.items = items;
    }
}
