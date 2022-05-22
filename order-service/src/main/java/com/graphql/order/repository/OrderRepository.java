package com.graphql.order.repository;

import com.graphql.order.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByUserId(@NonNull String userId);
}