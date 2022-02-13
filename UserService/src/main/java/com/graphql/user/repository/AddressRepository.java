package com.graphql.user.repository;

import com.graphql.user.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, String> {
    Optional<AddressInfo> findByUser_Id(String id);
}