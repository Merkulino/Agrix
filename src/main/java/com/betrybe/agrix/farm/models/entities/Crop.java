package com.betrybe.agrix.farm.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * Crop Entity.
 */
@Entity
@Table(name = "crop")
@Data
public class Crop {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "farm_id")
  private Long farmId;

  @ManyToOne
  @JoinColumn(name = "farm_id", insertable = false, updatable = false)
  @JsonIgnore
  private Farm farm;

  @Column(length = 255, nullable = false)
  private String name;

  @Column(name = "planted_area", nullable = false)
  private double plantedArea;

  @Column(name = "planted_date", nullable = false)
  private LocalDate plantedDate;

  @Column(name = "harvest_date", nullable = false)
  private LocalDate harvestDate;

  @ManyToMany(mappedBy = "crops")
  @JsonIgnore
  private List<Fertilizer> fertilizers = new ArrayList<>();

}
