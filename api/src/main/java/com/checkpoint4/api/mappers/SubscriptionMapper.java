package com.checkpoint4.api.mappers;

import com.checkpoint4.api.dto.SubscriptionDto;
import com.checkpoint4.api.exceptions.PersonNotFoundException;
import com.checkpoint4.api.exceptions.SubscriptionNotFoundException;
import com.checkpoint4.api.persistence.entities.Person;
import com.checkpoint4.api.persistence.entities.Subscription;
import com.checkpoint4.api.repositories.PersonRepository;
import com.checkpoint4.api.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionMapper {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    PersonRepository personRepository;

    public Subscription createSubscription(Long personId, SubscriptionDto dto) {
        Subscription subscription = new Subscription();
        subscription.setSubscriptionDate(dto.getSubscriptionDate());
        subscription.setExpirationDate(dto.getExpirationDate());
        subscription.setCategorie(dto.getCategorie());
        subscription.setPrice(dto.getPrice());
        subscription.setServiceName(dto.getServiceName());
        subscription.setType(dto.getType());
        this.setPerson(personId, subscription);
        return subscription;
    }

    public Subscription updateSubscription(Long subscriptionId, SubscriptionDto dto) {
        Subscription subscription = subscriptionRepository.findById(subscriptionId).orElseThrow(SubscriptionNotFoundException::new);
        subscription.setSubscriptionDate(dto.getSubscriptionDate());
        subscription.setExpirationDate(dto.getExpirationDate());
        subscription.setCategorie(dto.getCategorie());
        subscription.setPrice(dto.getPrice());
        subscription.setServiceName(dto.getServiceName());
        subscription.setType(dto.getType());
        return subscription;
    }

    private void setPerson(Long personId, Subscription subscription) {
        Person person = personRepository.findById(personId).orElseThrow(PersonNotFoundException::new);
        subscription.setPerson(person);
    }
}
