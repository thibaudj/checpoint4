package com.checkpoint4.api.services;

import com.checkpoint4.api.dto.SubscriptionDto;
import com.checkpoint4.api.exceptions.SubscriptionNotFoundException;
import com.checkpoint4.api.mappers.SubscriptionMapper;
import com.checkpoint4.api.persistence.entities.Subscription;
import com.checkpoint4.api.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionMapper subscriptionMapper;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    public Subscription createSubsciption(Long personId, SubscriptionDto dto) {
        return subscriptionRepository.save(subscriptionMapper.createSubscription(personId, dto));
    }

    public List<Subscription> findAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Subscription findSubscriptionById(Long subscriptionId) {
        return subscriptionRepository.findById(subscriptionId).orElseThrow(SubscriptionNotFoundException::new);
    }

    public Subscription updateSubscription(Long subscriprionId, SubscriptionDto dto) {
        Subscription subscriptionToUpdate = subscriptionRepository.findById(subscriprionId).orElseThrow(SubscriptionNotFoundException::new);
        subscriptionToUpdate = subscriptionMapper.updateSubscription(subscriprionId, dto);
        return subscriptionRepository.save(subscriptionToUpdate);
    }

    public void deleteSubscription(Long subscriptionId) {
        Optional<Subscription> subscriptionToDelete = subscriptionRepository.findById(subscriptionId);
        subscriptionToDelete.ifPresent(subscription -> subscriptionRepository.delete(subscription));
    }
}
