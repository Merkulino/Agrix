package com.betrybe.agrix.farm.controller;

import com.betrybe.agrix.farm.models.entities.Crop;
import com.betrybe.agrix.farm.models.entities.Farm;
import com.betrybe.agrix.farm.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe controller farm.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  @Autowired
  private FarmService service;
  
  @GetMapping("/up")
  @ResponseStatus(HttpStatus.OK)
  public void up() {
    service.up();
  }

  @PostMapping("/{id}/crops")
  public ResponseEntity<Crop> createFarmsCrop(@PathVariable Long id, @RequestBody Crop crop) {
    Crop farmCrop = service.createFarmsCrop(id, crop);
    return ResponseEntity.status(HttpStatus.CREATED).body(farmCrop);
  }

  @GetMapping("/{id}/crops")
  public ResponseEntity<List<Crop>> getFarmsCrop(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(service.getFarmsCrop(id));
  }


  @GetMapping("/{id}")
  public ResponseEntity<Farm> getFarm(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(service.getFarm(id));
  }

  /**
   * Create a new farm.
   *
   * @param farm object
   */
  @PostMapping
  public ResponseEntity<Farm> createFarm(@RequestBody Farm farm) {
    Farm farmResponse = service.createFarm(farm);
    return ResponseEntity.status(HttpStatus.CREATED).body(farmResponse);
  }

  @GetMapping
  public ResponseEntity<List<Farm>> getFarms() {
    return ResponseEntity.status(HttpStatus.OK).body(service.getFarms());
  }

}
