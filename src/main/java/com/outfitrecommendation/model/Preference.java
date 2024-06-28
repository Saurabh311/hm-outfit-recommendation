package com.outfitrecommendation.model;

import jakarta.persistence.*;

@Entity
public class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long preferenceId;
    private double budget;
    private String style;
    private String brand;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Event event;

}


