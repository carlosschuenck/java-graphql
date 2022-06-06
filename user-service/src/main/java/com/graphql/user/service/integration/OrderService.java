package com.graphql.user.service.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.graphql.user.dto.integration.OrderDTO;
import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.graphql.user.util.GraphqlSchemaReaderUtil.getSchemaFromFileName;

@AllArgsConstructor
@Service
public class OrderService {

    private final GraphQLWebClient graphQLWebClient;

    public List<OrderDTO> getByUserId(String userId) {
        final ObjectNode variables = new ObjectMapper().createObjectNode();
        variables.put("userId", userId);

        var schema = getSchemaFromFileName("ordersByUserId");

        GraphQLRequest request = GraphQLRequest.builder()
                .query(schema)
                .variables(variables)
                .build();

        return graphQLWebClient.post(request).block().getList("ordersByUserId", OrderDTO.class);
    }
}
