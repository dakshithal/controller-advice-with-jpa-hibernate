package com.hackerrank.restcontrolleradvice.model;

import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    @OneToMany(mappedBy="pet")
    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return this.pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
