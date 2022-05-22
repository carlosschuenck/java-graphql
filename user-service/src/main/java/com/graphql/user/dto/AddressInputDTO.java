package com.graphql.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressInputDTO {
    private String number;
    private String street;
    private String zipCode;
}
