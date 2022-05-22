package com.graphql.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

import static lombok.EqualsAndHashCode.Include;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {
    @Id
    @Include
    @GeneratedValue(generator = "UUID")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(nullable = false, length = 20)
    private String number;
    @Column(nullable = false)
    private String street;
    @Column(name = "zip_code")
    private String zipCode;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",nullable = false)
    private User user;
}