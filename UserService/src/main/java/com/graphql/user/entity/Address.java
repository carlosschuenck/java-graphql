package com.graphql.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @Column(nullable = false)
    private String id;
    @Column(nullable = false, length = 20)
    private String number;
    @Column(nullable = false)
    private String street;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private User user;
}