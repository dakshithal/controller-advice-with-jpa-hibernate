package com.hackerrank.restcontrolleradvice.model;

import org.springframework.stereotype.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pet {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="owner_id", nullable=false)
    private Person person;

    public String getOwnerName() {
        return this.person.getFirstName();
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

