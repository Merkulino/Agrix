package com.betrybe.agrix.farm.controller;

import com.betrybe.agrix.farm.models.entities.Fertilizer;
import com.betrybe.agrix.farm.service.FertilizerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * Fertilizers Controller.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {

  @Autowired
  private FertilizerService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Fertilizer createFertilizer(@RequestBody Fertilizer fertilizer) {
    return service.createFertilizer(fertilizer);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @Secured("ADMIN")
  public List<Fertilizer> getFertilizers() {
    return service.getFertilizers();
  }
  
  @GetMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public Fertilizer getFertilizerById(@PathVariable Long id) {
    return service.getFertilizerById(id);
  }
  
}
