package com.outfitrecommendation;

import com.outfitrecommendation.model.*;
import com.outfitrecommendation.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class DataLoader {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            // Sample customers
            customerRepository.saveAll(List.of(
                    new Customer(1L, "John Doe", 30, "Male", "123 Main Malmo", "john.doe@example.com"),
                    new Customer(2L, "Jane Smith", 28, "Female", "456 Elm Stockholm", "jane.smith@example.com"),
                    new Customer(3L, "Robin Kate", 21, "Male", "76 Elm Stockholm", "robin.kate@example.com")
            ));

            // Sample product categories
            ProductCategory suits = new ProductCategory(1L, "Suits");
            ProductCategory shirts = new ProductCategory(2L, "Shirts");
            ProductCategory trousers = new ProductCategory(3L, "Trousers");
            ProductCategory shoes = new ProductCategory(4L, "Shoes");
            ProductCategory cap = new ProductCategory(5L, "Cap");
            productCategoryRepository.saveAll(List.of(suits, shirts, trousers, shoes, cap));

            // Sample events
            Event wedding = new Event(1L, "Wedding", new ArrayList<>(List.of(suits, shirts, trousers, shoes)));
            Event christmas = new Event(2L, "Christmas", new ArrayList<>(List.of(suits, shirts)));
            Event midsummer = new Event(3L, "Midsummer", new ArrayList<>(List.of(trousers, shirts, cap)));
            eventRepository.saveAll(List.of(wedding, christmas, midsummer));

            // Sample inventory items
            inventoryRepository.saveAll(List.of(
                    new Inventory(1L, "Tuxedo", "Suits", 2500, "H&M", "Black", 10),
                    new Inventory(2L, "Dress Shirt", "Shirts", 500, "H&M", "White",15),
                    new Inventory(3L, "Dress Pants", "Trousers", 1000, "H&M", "Black", 20),
                    new Inventory(4L, "Formal Shoes", "Shoes", 800, "H&M", "Black", 30),
                    new Inventory(5L, "Casual Shirt", "Shirts", 300, "Nike", "Blue", 25),
                    new Inventory(6L, "Jeans", "Trousers", 700, "Nike", "Blue", 20)
            ));
        };
    }
}

