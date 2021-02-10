package com.checkpoint4.api.repositories;

import java.util.Optional;

import com.checkpoint4.api.persistence.entities.Role;
import com.checkpoint4.api.persistence.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}
