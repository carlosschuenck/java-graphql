package com.graphql.user.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
@Builder
public class AddressDto implements Serializable {
    private String id;
    private String number;
    private String street;
    private String zipCode;
}
