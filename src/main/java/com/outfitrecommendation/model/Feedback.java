package com.outfitrecommendation.model;

import jakarta.persistence.*;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long feedbackId;
    private int rating;
    private String comment;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Inventory item;
}
