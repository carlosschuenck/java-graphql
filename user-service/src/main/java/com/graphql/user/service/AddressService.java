package com.graphql.user.service;

import com.graphql.user.dto.AddressDTO;
import com.graphql.user.dto.AddressInputDTO;
import com.graphql.user.entity.Address;

import com.graphql.user.entity.User;
import com.graphql.user.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class AddressService {

    private final AddressRepository repository;
    private final ModelMapper mapper;

    public void save(AddressInputDTO addressInput, UUID userId) {
        Address address = mapper.map(addressInput, Address.class).setUser(new User(userId));
        repository.save(address);
    }

    public AddressDTO findByUserId(UUID id) {
        return repository.findByUserId(id)
                .map(address -> mapper.map(address, AddressDTO.class))
                .orElse(null);
    }

    public void deleteByUserId(UUID id) {
        repository.deleteByUserId(id);
    }
}
