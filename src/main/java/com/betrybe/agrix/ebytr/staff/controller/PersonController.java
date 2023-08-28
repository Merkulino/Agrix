package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.AuthRequest;
import com.betrybe.agrix.ebytr.staff.dto.AuthResponse;
import com.betrybe.agrix.ebytr.staff.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.dto.ResponseDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.JwtService;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PersonCOntrooerl.
 */
@RequestMapping
@RestController
public class PersonController {

  @Autowired
  private PersonService personService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired 
  private PasswordEncoder encoder;

  @Autowired
  private JwtService jwtService;

  /**
   * Saving new person.
   *
   * @param personDto
   * 
   * @return
   * 
   */
  @PostMapping("/persons")
  private ResponseEntity<PersonDto> saveNewPerson(@RequestBody Person person) {
    String encodedPassword = encoder.encode(person.getPassword());
    person.setPassword(encodedPassword);
    PersonDto personResponse = personService.create(person);
    return ResponseEntity.status(HttpStatus.CREATED).body(personResponse);
  }

  @PostMapping("/auth/login")
  private ResponseEntity<AuthResponse> login(@RequestBody AuthRequest auth) {
    UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(
        auth.username(), auth.password());
    Authentication authenticate = authenticationManager.authenticate(usernamePassword);
    Person person = (Person) authenticate.getPrincipal();

    String jwt = jwtService.generateToken(person);
    return ResponseEntity.status(HttpStatus.OK).body(new AuthResponse(jwt));
  }

}
