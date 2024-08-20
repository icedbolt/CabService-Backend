package com.mycab.safar.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String vehicleNumber;
}
