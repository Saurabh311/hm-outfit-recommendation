package com.outfitrecommendation.controller;

import com.outfitrecommendation.dto.RecommendationRequest;
import com.outfitrecommendation.model.Recommendation;
import com.outfitrecommendation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/recommendation")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @PostMapping
    public ResponseEntity<?> generateRecommendation(@RequestBody RecommendationRequest request) {
        try {
            Recommendation recommendation = recommendationService.generateRecommendation(request.getCustomerId(), request.getEventType(), request.getBrand(), request.getBudget());
            return ResponseEntity.ok(recommendation);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(Map.of("error", e.getMessage()));
        }
    }
}

