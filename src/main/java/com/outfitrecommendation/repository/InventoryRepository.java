package com.outfitrecommendation.repository;

import com.outfitrecommendation.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByBrandAndCategory(String brand, String categoryName);
}
