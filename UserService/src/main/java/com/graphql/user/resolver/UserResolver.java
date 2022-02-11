package com.graphql.user.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphql.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@Component
public class UserResolver implements GraphQLResolver<User> {

    public BigDecimal teste(User user) {
        log.info("CHAMOU O MÉTODO " + UUID.randomUUID().toString());
        return BigDecimal.TEN;
    }
}
