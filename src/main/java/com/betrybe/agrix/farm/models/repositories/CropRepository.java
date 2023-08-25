package com.betrybe.agrix.farm.models.repositories;

import com.betrybe.agrix.farm.models.entities.Crop;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Crop Repository to connect with database.
 */
@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {
  List<Crop> findAllByFarmId(Long farmId);
  
  /**
   * Find crops between two dates.
   *
   * @param start
   *
   * @param end
   *
   * @return
   * 
   */
  List<Crop> findAllByHarvestDateGreaterThanAndHarvestDateLessThan(LocalDate start, LocalDate end);
}
