package com.mycab.safar.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Location {
    @Id
    private Integer x;
    @Id
    private Integer y;
}
