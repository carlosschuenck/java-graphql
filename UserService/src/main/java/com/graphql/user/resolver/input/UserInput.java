package com.graphql.user.resolver.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInput {
    private String name;
    private Integer age;
    private AddressInput address;
}
