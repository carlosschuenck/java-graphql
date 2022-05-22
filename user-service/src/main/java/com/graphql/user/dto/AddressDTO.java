package com.graphql.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO implements Serializable {
    private String id;
    private String number;
    private String street;
    private String zipCode;
}
