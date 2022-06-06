package com.graphql.user.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphql.user.dto.AddressDTO;
import com.graphql.user.dto.UserDTO;
import com.graphql.user.dto.integration.OrderDTO;
import com.graphql.user.service.AddressService;
import com.graphql.user.service.integration.OrderService;
import graphql.execution.DataFetcherResult;
import graphql.servlet.GenericGraphQLError;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.List.of;
import static java.util.Objects.isNull;
import static java.util.UUID.fromString;

@Slf4j
@AllArgsConstructor
@Component
public class UserResolver implements GraphQLResolver<UserDTO> {

    public static final String MSG_NO_ADDRESS = "No address for this user";
    private final AddressService addressService;
    private final OrderService orderService;

    public DataFetcherResult<List<OrderDTO>> orders(UserDTO user) {
        return new DataFetcherResult<>(orderService.getByUserId(user.getId()), of());
    }

    public DataFetcherResult<AddressDTO> address(UserDTO user) {
        AddressDTO address = addressService.findByUserId(fromString(user.getId()));
        if (isNull(address))
            return new DataFetcherResult<>(null, of(new GenericGraphQLError(MSG_NO_ADDRESS)));
        return new DataFetcherResult<>(address, of());
    }
}


