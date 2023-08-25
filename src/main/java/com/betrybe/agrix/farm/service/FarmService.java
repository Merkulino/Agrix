package com.betrybe.agrix.farm.service;

import com.betrybe.agrix.farm.exceptions.NotFoundException;
import com.betrybe.agrix.farm.models.entities.Crop;
import com.betrybe.agrix.farm.models.entities.Farm;
import com.betrybe.agrix.farm.models.repositories.CropRepository;
import com.betrybe.agrix.farm.models.repositories.FarmRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Farm Service.
 */
@Service
public class FarmService {

  @Autowired
  private FarmRepository farmRepository;

  @Autowired
  private CropRepository cropRepository;

  /**
   * up db.
   */
  public void up() {
    Farm farmDto = new Farm();
    farmDto.setName("fazendinha");
    farmDto.setSize(5.0);

    Farm farmRes = this.createFarm(farmDto);

    Crop cropDto = new Crop();
    cropDto.setFarmId(farmRes.getId());
    cropDto.setName("Batatinha");
    cropDto.setPlantedArea(22);
    cropDto.setPlantedDate(LocalDate.of(2222, 2, 22));
    cropDto.setHarvestDate(LocalDate.now());
    
    Crop cropDto2 = new Crop();
    cropDto2.setFarmId(farmRes.getId());
    cropDto2.setName("Mandioquinha");
    cropDto.setPlantedArea(22);
    cropDto2.setPlantedDate(LocalDate.now());
    cropDto2.setHarvestDate(LocalDate.now());

    cropRepository.save(cropDto);
    cropRepository.save(cropDto2);
  }

  public Farm createFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  public List<Farm> getFarms() {
    return farmRepository.findAll();
  }

  /**
   * Check if has farm.
   *
   * @param id of farm
   *
   * @return the farm or exception
   * 
   */
  public Farm getFarm(Long id) {
    Optional<Farm> farm = farmRepository.findById(id);

    if (farm.isEmpty()) {
      throw new NotFoundException("Fazenda não encontrada!");
    }

    return farm.get();
  }

  /**
   * Create Farm Crop.
   *
   * @param id
   *
   * @param crop
   *
   * @return
   *
   */
  public Crop createFarmsCrop(Long id, Crop crop) {
    this.getFarm(id);

    Crop cropDto = new Crop();
    cropDto.setFarmId(id);
    cropDto.setName(crop.getName());
    cropDto.setPlantedArea(crop.getPlantedArea());
    cropDto.setPlantedDate(crop.getPlantedDate());
    cropDto.setHarvestDate(crop.getHarvestDate());

    // DTO save farmId
    return cropRepository.save(cropDto);
  }

  @GetMapping("/{id}/crops")
  public List<Crop> getFarmsCrop(Long farmId) {
    this.getFarm(farmId);
    return cropRepository.findAllByFarmId(farmId);
  }

}
