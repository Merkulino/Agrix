package com.betrybe.agrix.farm.models.repositories;

import com.betrybe.agrix.farm.models.entities.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Farm Interface to use Jpa. 
 */
@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {
  
}
