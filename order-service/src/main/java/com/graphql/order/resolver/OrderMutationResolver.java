package com.graphql.order.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.order.entity.Order;
import com.graphql.order.repository.OrderRepository;
import com.graphql.order.resolver.input.OrderInput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@Component
public class OrderMutationResolver implements GraphQLMutationResolver {

    private final OrderRepository repository;

    public Order newOrder(OrderInput input){
        return repository.save(Order.builder()
                .id(UUID.randomUUID().toString())
                .description(input.getDescription())
                .userId(input.getUserId())
                .build());
    }
}
