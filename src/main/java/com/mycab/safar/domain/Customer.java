package com.mycab.safar.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;
    private Gender gender;
    @OneToOne(cascade = CascadeType.ALL)
    private Location location;
}
