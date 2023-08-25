package com.betrybe.agrix.farm.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

/**
 * Farm Entity to database.
 */
@Entity
@Table(name = "farms")
@Data
public class Farm {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Double size;

  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "farm")
  @JsonIgnore
  private List<Crop> crops;

}
