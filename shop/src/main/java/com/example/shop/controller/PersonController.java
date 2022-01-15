package com.example.shop.controller;

import com.example.shop.model.Person;
import com.example.shop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/person/create")
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping("/person/update")
    public Person updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }

    @DeleteMapping("/person/delete")
    public void deletePerson(@RequestBody Person person) {
        personService.deletePerson(person);
    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable int id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/person/all")
    public List<Person> getAll() {
        return personService.getAllPerson();
    }

}