package com.outfitrecommendation.service;

import com.google.common.util.concurrent.AtomicDouble;
import com.outfitrecommendation.model.*;
import com.outfitrecommendation.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecommendationService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private RecommendationRepository recommendationRepository;

    public Recommendation generateRecommendation(Long customerId, String eventType, String brand, double budget) {
        // Fetch Customer and Event Information
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        Event event = eventRepository.findByEventName(eventType);
        if (event == null) {
            throw new RuntimeException("Event not found");
        }

        // Prepare for Recommendation Generation
        List<ProductCategory> requiredCategories = new ArrayList<>(event.getProductCategories());
        Map<String, Inventory> selectedItems = new HashMap<>();
        AtomicDouble totalCost = new AtomicDouble(0.0);

        // Select Items for Each Category
        for (ProductCategory category : requiredCategories) {
            List<Inventory> itemsForCategory = inventoryRepository.findByBrandAndCategory(brand, category.getCategoryName());
            Inventory selectedItem = null;

            for (Inventory item : itemsForCategory) {
                if (item.getStock() > 0 && totalCost.get() + item.getPrice() <= budget) {
                    selectedItem = item;
                    totalCost.addAndGet(item.getPrice());
                    break;
                }
            }

            if (selectedItem != null) {
                selectedItems.put(category.getCategoryName(), selectedItem);
            } else {
                throw new RuntimeException("Cannot find suitable item for category: " + category.getCategoryName() + " within budget.");
            }
        }

        // Final Checks and Saving the Recommendation
        if (selectedItems.size() < requiredCategories.size()) {
            throw new RuntimeException("Not enough items found to fulfill the requirements within the budget.");
        }

        Recommendation recommendation = new Recommendation(customer, eventType, new ArrayList<>(selectedItems.values()));

        return recommendationRepository.save(recommendation);
    }
}