package com.outfitrecommendation.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;
    private String name;
    private int age;
    private String gender;
    private String address;
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Preference> preference;

    @OneToMany(mappedBy = "customer")
    private List<Feedback> feedbacks;

    @OneToMany
    private List<Recommendation> recommendations;

    public Customer(long id, String name, int age, String gender, String address, String email) {
        this.customerId = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
    }

    public Customer() {
    }

    // Getters and setters
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Preference> getPreferences() {
        return preference;
    }

    public void setPreferences(List<Preference> preferences) {
        this.preference = preferences;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

}
