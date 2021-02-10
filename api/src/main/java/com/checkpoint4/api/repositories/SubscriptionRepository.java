package com.checkpoint4.api.repositories;

import com.checkpoint4.api.persistence.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
