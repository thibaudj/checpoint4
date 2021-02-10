package com.checkpoint4.api.mappers;

import com.checkpoint4.api.dto.PersonDto;
import com.checkpoint4.api.exceptions.PersonNotFoundException;
import com.checkpoint4.api.exceptions.UserNotFoundException;
import com.checkpoint4.api.persistence.entities.Person;
import com.checkpoint4.api.persistence.entities.User;
import com.checkpoint4.api.repositories.PersonRepository;
import com.checkpoint4.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    UserRepository userRepository;

    public Person createPerson(Long userId, PersonDto dto) {
        Person person = new Person();
        person.setFirstname(dto.getFirstname());
        person.setLastname(dto.getLastname());
        person.setBirthDate(dto.getBirthDate());
        person.setGender(dto.getGender());
        person.setMobileNumber(dto.getMobileNumber());
        person.setPhoneNumber(dto.getPhoneNumber());
        this.SetUser(userId, person);
        return person;
    }

    public Person updatePerson(Long personId, PersonDto dto) {
        Person person = personRepository.findById(personId).orElseThrow(PersonNotFoundException::new);
        person.setFirstname(dto.getFirstname());
        person.setLastname(dto.getLastname());
        person.setBirthDate(dto.getBirthDate());
        person.setGender(dto.getGender());
        person.setMobileNumber(dto.getMobileNumber());
        person.setPhoneNumber(dto.getPhoneNumber());
        return person;
    }

    private void SetUser(Long userId, Person person) {
        if(userId != null) {
            User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
            person.setUser(user);
        }
    }
}
