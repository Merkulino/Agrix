package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.dto.AuthRequest;
import com.betrybe.agrix.ebytr.staff.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.PersonRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service layer class for handling persons business logic.
 */
@Service
public class PersonService implements UserDetailsService {

  private final PersonRepository personRepository;
  
  private final JwtService jwtService;

  @Autowired
  public PersonService(
      PersonRepository personRepository,
      JwtService jwtService) {
    this.personRepository = personRepository;
    this.jwtService = jwtService;
  }

  /**
   * Returns a person for a given ID.
   */
  public Person getPersonById(Long id) {
    Optional<Person> person = personRepository.findById(id);

    if (person.isEmpty()) {
      throw new PersonNotFoundException();
    }

    return person.get();
  }

  /**
   * Returns a person for a given username.
   */
  public UserDetails getPersonByUsername(String username) {
    return personRepository.findByUsername(username);

    /*
    if (person) {
      throw new PersonNotFoundException();
    }

    return person.get();
    */
  }

  /**
   * Creates a new person.
   */
  public PersonDto create(Person person) {
    Person newPerson = personRepository.save(person);
    return new PersonDto(newPerson.getId(), newPerson.getUsername(), newPerson.getRole());
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return personRepository.findByUsername(username);
  }

  /**
   * login user.
   *
   * @return jwt token
   */
  public String login(Person person) {
    UserDetails user = this.loadUserByUsername(person.getUsername());
    if (user == null) {
      throw new PersonNotFoundException();
    }
    if (!user.getPassword().equals(person.getPassword())) {
      return "Senha incorreta!!"; // Deveria estourar um erro
    }
    return jwtService.generateToken(user);
  }
}
