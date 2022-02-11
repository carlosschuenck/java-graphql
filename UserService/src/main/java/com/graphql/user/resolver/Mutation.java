package com.graphql.user.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.user.entity.User;
import com.graphql.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@Component
public class Mutation implements GraphQLMutationResolver {

    private final UserRepository userRepository;

    public User newUser(String name, Integer age){
        User user = User.builder().id(UUID.randomUUID().toString()).name(name).age(age).build();
        userRepository.save(user);
        return user;
    }
}
