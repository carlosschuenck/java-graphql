package com.graphql.user.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.user.entity.User;
import com.graphql.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserQueryResolver implements GraphQLQueryResolver {


    private final UserRepository userRepository;

    public List<User> users() {
        return userRepository.findAll();
    }
}
