package com.graphql.user.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.user.entity.Address;
import com.graphql.user.entity.User;
import com.graphql.user.entity.dto.UserDto;
import com.graphql.user.repository.UserRepository;
import com.graphql.user.resolver.input.AddressInput;
import com.graphql.user.resolver.input.UserInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@Component
public class UserMutation implements GraphQLMutationResolver {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserDto newUser(UserInput userInput){
        AddressInput addressInput = userInput.getAddress();
        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .name(userInput.getName())
                .age(userInput.getAge())
                .build();

        if(Objects.nonNull(addressInput)){
            user.setAddress(
                Address.builder()
                        .id(UUID.randomUUID().toString())
                        .number(addressInput.getNumber())
                        .street(addressInput.getStreet())
                        .zipCode(addressInput.getZipCode())
                        .build());
        }

        return modelMapper.map(userRepository.save(user), UserDto.class);

    }
}
