package com.graphql.user.repository;

import com.graphql.user.entity.Address;
import com.graphql.user.repository.projection.AddressProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, String> {
    Optional<AddressProjection> findByUserId(UUID id);
    void deleteByUserId(UUID id);
}