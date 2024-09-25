package com.devstack.healthcare.system.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    private long id;
    private String name;
    private String address;
    private String contact;
    private double salary;
}
