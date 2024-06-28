package com.outfitrecommendation.repository;

import com.outfitrecommendation.model.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {

}
