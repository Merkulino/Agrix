package com.betrybe.agrix.farm.controller;

import com.betrybe.agrix.farm.models.entities.Crop;
import com.betrybe.agrix.farm.models.entities.Fertilizer;
import com.betrybe.agrix.farm.service.CropService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Crop's Controlller.
 */
@RestController
@RequestMapping("/crops")
public class CropController {

  @Autowired
  private CropService service;

  /**
   * Associate Crop With Fertilizer.
   *
   * @param cropId
   * 
   * @param fertilizerId
   * 
   * @return
   * 
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> associateCropWithFertilizer(
      @PathVariable Long cropId,
      @PathVariable Long fertilizerId
  ) {
    this.service.associateCropWithFertilizer(cropId, fertilizerId);
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body("Fertilizante e plantação associados com sucesso!");
  }
  
  /**
   * Get Fertilizers from an crop.
   *
   * @param cropId
   * 
   * @return
   * 
   */
  @GetMapping("/{cropId}/fertilizers")
  public ResponseEntity<List<Fertilizer>> getFertilizersOfCrop(@PathVariable Long cropId) {
    List<Fertilizer> fertilizers = this.service.getFertilizersOfCrop(cropId);
    return ResponseEntity
      .status(HttpStatus.OK)
      .body(fertilizers);
  }

  @GetMapping("/search")
  @ResponseStatus(HttpStatus.OK)
  public List<Crop> getCropsBetweenDates(
      @RequestParam(name = "start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start, 
      @RequestParam(name = "end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
    return service.getCropsBetweenDates(start, end);
  }

  @GetMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public Crop getCrop(@PathVariable Long id) {
    return service.getCrop(id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Crop> getCrops() {
    return service.getCrops();
  }
  
  
}
