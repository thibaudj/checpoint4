package com.checkpoint4.api.controllers;

import com.checkpoint4.api.dto.PersonDto;
import com.checkpoint4.api.persistence.entities.Person;
import com.checkpoint4.api.persistence.entities.User;
import com.checkpoint4.api.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public List<Person> findAllPersons() {
        return personService.findAllPersons();
    }

    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable Long id) {
        return personService.findPersonById(id);
    }

    @PostMapping
    public ResponseEntity<Person> person(@RequestBody PersonDto dto, Long userId) throws Exception {
        Person personToCreate = personService.createPerson(userId, dto);
        return new ResponseEntity<Person>(personToCreate, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody PersonDto dto) {
        return personService.updatePerson(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}
