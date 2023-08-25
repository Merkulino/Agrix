package com.betrybe.agrix.farm.service;

import com.betrybe.agrix.farm.exceptions.NotFoundException;
import com.betrybe.agrix.farm.models.entities.Crop;
import com.betrybe.agrix.farm.models.entities.Fertilizer;
import com.betrybe.agrix.farm.models.repositories.CropRepository;
import com.betrybe.agrix.farm.models.repositories.FertilizerRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Crop's Service.
 */
@Service
public class CropService {
  
  @Autowired
  private CropRepository repository;
  
  @Autowired
  private FertilizerRepository fertilizerRepository;

  public List<Crop> getCrops() {
    return this.repository.findAll();
  }

  /**
   * Get Crop by his id.
   *
   * @param id
   *
   * @return
   *
   */
  public Crop getCrop(Long id) {
    Optional<Crop> crop = this.repository.findById(id);

    if (crop.isEmpty()) {
      throw new NotFoundException("Plantação não encontrada!");
    }

    return crop.get();
  }

  public List<Crop> getCropsBetweenDates(LocalDate start, LocalDate end) {
    return repository.findAllByHarvestDateGreaterThanAndHarvestDateLessThan(start, end);
  }

  /**
   * Associate Fertilizers with Crop and Crop with Fertilizers.
   *
   * @param cropId
   * 
   * @param fertilizerId
   *
   */
  public void associateCropWithFertilizer(Long cropId, Long fertilizerId) {
    Crop crop = this.getCrop(cropId);
    Fertilizer fertilizer = this.fertilizerRepository.findById(fertilizerId)
        .orElseThrow(() -> new NotFoundException("Fertilizante não encontrado!"));
    
    crop.getFertilizers().add(fertilizer);
    fertilizer.getCrops().add(crop);

    repository.save(crop);
    fertilizerRepository.save(fertilizer);
  }

  public List<Fertilizer> getFertilizersOfCrop(Long cropId) {
    Crop crop = this.getCrop(cropId);
    return crop.getFertilizers();
  }

}
