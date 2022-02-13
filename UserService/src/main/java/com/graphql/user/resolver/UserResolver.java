package com.graphql.user.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphql.user.entity.dto.UserDto;
import com.graphql.user.entity.dto.integration.OrderDto;
import com.graphql.user.repository.AddressInfo;
import com.graphql.user.repository.AddressRepository;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import graphql.servlet.GenericGraphQLError;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Component
public class UserResolver implements GraphQLResolver<UserDto> {

    private final AddressRepository addressRepository;

    private final GraphQLWebClient graphQLWebClient;

    public DataFetcherResult<List<OrderDto>> orders(UserDto user){
        GraphQLRequest request  = GraphQLRequest.builder().query("query {\n" +
                "    ordersByUserId(userId: \""+user.getId()+"\") {\n" +
                "        id\n" +
                "        description\n" +
                "        userId\n" +
                "    }\n" +
                "}").build();

        GraphQLResponse response = graphQLWebClient.post(request).block();

        List<OrderDto> orders = response.getList("ordersByUserId", OrderDto.class);
        return new DataFetcherResult<>(orders, Collections.emptyList());
    }

    public DataFetcherResult<AddressInfo> address(UserDto user){
        Optional<AddressInfo> address = addressRepository.findByUser_Id(user.getId());
        if(address.isPresent())
            return new DataFetcherResult<>(address.get(), Collections.emptyList());
        return new DataFetcherResult<>(null, List.of(new GenericGraphQLError("No address for this user")));
    };
}


