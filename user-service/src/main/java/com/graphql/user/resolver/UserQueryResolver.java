package com.graphql.user.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.user.dto.UserDTO;
import com.graphql.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@Slf4j
public class UserQueryResolver implements GraphQLQueryResolver {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<UserDTO> users() {
        return userRepository.findAllUserBy()
                .stream()
                .map(userInfo -> modelMapper.map(userInfo, UserDTO.class))
                .collect(Collectors.toList());
    }

}
