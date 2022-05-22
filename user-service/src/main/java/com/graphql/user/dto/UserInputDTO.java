package com.graphql.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInputDTO {
    private String name;
    private Integer age;
    private AddressInputDTO address;
}
