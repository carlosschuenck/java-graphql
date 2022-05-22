package com.graphql.user.service.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.graphql.user.dto.integration.OrderDTO;
import com.graphql.user.util.GraphqlSchemaReaderUtil;
import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {

    private static final String GET_ORDER = "graphql/integration/ordersByUserId.graphqls";
    private final GraphQLWebClient graphQLWebClient;

    public List<OrderDTO> getByUserId(String userId){
        final ObjectNode variables = new ObjectMapper().createObjectNode();

        var schema = GraphqlSchemaReaderUtil.getSchemaFromFileName("ordersByUserId");

        variables.put("userId", userId);

        GraphQLRequest request  = GraphQLRequest.builder()
                .query(schema)
                .variables(variables)
                .build();


        GraphQLResponse response = graphQLWebClient.post(request).block();

        List<OrderDTO> orders = response.getList("ordersByUserId", OrderDTO.class);
        return orders;
    }
}
