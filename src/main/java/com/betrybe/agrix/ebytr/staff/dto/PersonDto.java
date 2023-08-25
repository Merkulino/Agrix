package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * Person DTO.
 */
public record PersonDto(Long id, String username, Role role) {
  public Person toEntity() {
    return new Person(id, username, role);
  }
}
