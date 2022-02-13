package com.graphql.user.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private String id;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(length = 2,nullable = false)
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

}
