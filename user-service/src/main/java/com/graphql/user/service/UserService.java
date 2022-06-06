package com.graphql.user.service;

import com.graphql.user.dto.UserDTO;
import com.graphql.user.dto.UserInputDTO;
import com.graphql.user.entity.User;
import com.graphql.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final AddressService addressService;
    private final ModelMapper mapper;

    @Transactional
    public UserDTO save(UserInputDTO userInput) {
        var user = mapper.map(userInput, User.class);
        var newUser = repository.save(user);
        addressService.save(userInput.getAddress(), newUser.getId());
        return mapper.map(newUser, UserDTO.class);
    }
}
