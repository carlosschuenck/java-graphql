package com.graphql.user.entity.dto;

import com.graphql.user.entity.dto.integration.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto implements Serializable {
    private String id;
    private String name;
    private Integer age;
    private AddressDto address;
    private List<OrderDto> orders;
}
