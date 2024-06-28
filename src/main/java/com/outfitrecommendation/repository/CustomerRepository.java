package com.outfitrecommendation.repository;

import com.outfitrecommendation.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
