package com.checkpoint4.api.controllers;

import com.checkpoint4.api.dto.SubscriptionDto;
import com.checkpoint4.api.persistence.entities.Subscription;
import com.checkpoint4.api.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @GetMapping
    public List<Subscription> findAllSubscriptions() {
        return subscriptionService.findAllSubscriptions();
    }

    @GetMapping("/{id}")
    public Subscription findSubscriptionById(@PathVariable Long id) {
        return subscriptionService.findSubscriptionById(id);
    }

    @PostMapping
    public ResponseEntity<Subscription> person(@RequestBody SubscriptionDto dto, Long personId) throws Exception {
        Subscription subscriptionToCreate = subscriptionService.createSubsciption(personId, dto);
        return new ResponseEntity<Subscription>(subscriptionToCreate, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Subscription updateSubscription(@PathVariable Long id, @RequestBody SubscriptionDto dto) {
        return subscriptionService.updateSubscription(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
    }
}
