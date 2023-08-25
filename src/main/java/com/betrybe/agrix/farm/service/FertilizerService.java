package com.betrybe.agrix.farm.service;

import com.betrybe.agrix.farm.exceptions.NotFoundException;
import com.betrybe.agrix.farm.models.entities.Fertilizer;
import com.betrybe.agrix.farm.models.repositories.FertilizerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fertilizer Service.
 */
@Service
public class FertilizerService {

  @Autowired
  private FertilizerRepository repository;

  public Fertilizer createFertilizer(Fertilizer fertilizer) {
    return repository.save(fertilizer);
  }
  
  public List<Fertilizer> getFertilizers() {
    return repository.findAll();
  }

  
  /** 
   * Get Fertilizer by his id, and throw error if not found.
   *
   * @param id
   * 
   * @return Fertilizer
   */
  public Fertilizer getFertilizerById(Long id) {
    Optional<Fertilizer> fertilizer = repository.findById(id);

    if (fertilizer.isEmpty()) {
      throw new NotFoundException("Fertilizante não encontrado!");
    }

    return fertilizer.get();
  }
  
}
