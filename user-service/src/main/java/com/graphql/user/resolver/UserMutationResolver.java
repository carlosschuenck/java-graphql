package com.graphql.user.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.user.dto.UserDTO;
import com.graphql.user.dto.UserInputDTO;
import com.graphql.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserMutationResolver implements GraphQLMutationResolver {
    private final UserService service;

    public UserDTO newUser(UserInputDTO userInput){
        return service.save(userInput);
    }
}
