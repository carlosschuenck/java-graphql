package com.graphql.user.dto;

import com.graphql.user.dto.integration.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private String id;
    private String name;
    private Integer age;
    private AddressDTO address;
    private List<OrderDTO> orders;
}
