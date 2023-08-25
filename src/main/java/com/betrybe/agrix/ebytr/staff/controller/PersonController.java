package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.dto.ResponseDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PersonCOntrooerl.
 */
@RequestMapping("/persons")
@RestController
public class PersonController {

  @Autowired
  private PersonService personService;

  /**
   * Saving new person.
   *
   * @param personDto
   * 
   * @return
   * 
   */
  @PostMapping
  private ResponseEntity<PersonDto> saveNewPerson(@RequestBody Person person) {
    PersonDto personResponse = personService.create(person);
    return ResponseEntity.status(HttpStatus.CREATED).body(personResponse);
  }

}
