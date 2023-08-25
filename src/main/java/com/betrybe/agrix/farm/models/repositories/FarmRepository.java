package com.betrybe.agrix.farm.models.repositories;

import com.betrybe.agrix.farm.models.entities.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Farm Interface to use Jpa. 
 */
@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {
  
}
