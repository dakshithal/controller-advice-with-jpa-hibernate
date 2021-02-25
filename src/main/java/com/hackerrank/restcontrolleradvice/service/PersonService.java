package com.hackerrank.restcontrolleradvice.service;

import com.hackerrank.restcontrolleradvice.dto.PersonNotFoundException;
import com.hackerrank.restcontrolleradvice.model.Person;
import com.hackerrank.restcontrolleradvice.model.Pet;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

@Service
public class PersonService {
    private final EntityManager entityManager;

    PersonService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addPet(Long personId, String petName) {

        entityManager.getTransaction().begin();

        Person person = entityManager.find(Person.class,personId);
        if(person == null){
            throw new PersonNotFoundException();
        }

        Pet pet = new Pet();
        pet.setName(petName);

        if(person.getPets() == null){
            Set<Pet> newPet = new HashSet<>();
            newPet.add(pet);
            person.setPets(newPet);
        }else{
            person.getPets().add(pet);
        }
        entityManager.persist(person);
        entityManager.getTransaction().commit();

    }
}
