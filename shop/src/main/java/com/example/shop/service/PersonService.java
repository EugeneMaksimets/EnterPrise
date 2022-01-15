package com.example.shop.service;

import com.example.shop.model.Person;

import java.util.List;

public interface PersonService {
    Person createPerson(Person person);

    Person updatePerson(Person person);

    void deletePerson(Person person);

    Person getPersonById(int id);

    List<Person> getAllPerson();

}
