package com.graphql.user.resolver.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressInput {
    private String number;
    private String street;
    private String zipCode;
}
