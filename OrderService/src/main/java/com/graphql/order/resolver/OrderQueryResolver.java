package com.graphql.order.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.order.entity.Order;
import com.graphql.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class OrderQueryResolver implements GraphQLQueryResolver {

    private final OrderRepository repository;

    public List<Order> orders(){
        return repository.findAll();
    }

    public List<Order> ordersByUserId(String userId){
        return repository.findByUserId(userId);
    }
}
