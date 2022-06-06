package com.graphql.user.entity;

import lombok.*;

import static lombok.EqualsAndHashCode.Include;

import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @Id
    @Include
    @GeneratedValue(generator = "UUID")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(length = 2, nullable = false)
    private Integer age;

    public User(UUID id) {
        this.id = id;
    }
}
