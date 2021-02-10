package com.checkpoint4.api.services;

import com.checkpoint4.api.dto.PersonDto;
import com.checkpoint4.api.exceptions.PersonNotFoundException;
import com.checkpoint4.api.mappers.PersonMapper;
import com.checkpoint4.api.persistence.entities.Person;
import com.checkpoint4.api.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper personMapper;

    public Person createPerson(Long userId, PersonDto dto) {
        return personRepository.save(personMapper.createPerson(userId, dto));
    }

    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public Person findPersonById(Long personId) {
        return personRepository.findById(personId).orElseThrow(PersonNotFoundException::new);
    }

    public Person updatePerson(Long personId, PersonDto dto) {
        Person personToUpdate = personRepository.findById(personId).orElseThrow(PersonNotFoundException::new);
        personToUpdate = personMapper.updatePerson(personId, dto);
        return personRepository.save(personToUpdate);
    }

    public void deletePerson(Long personId) {
        Optional<Person> personToDelete = personRepository.findById(personId);
        personToDelete.ifPresent(person -> personRepository.delete(person));
    }
}
