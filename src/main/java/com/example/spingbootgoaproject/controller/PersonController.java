package com.example.spingbootgoaproject.controller;

import com.example.spingbootgoaproject.module.Person;
import com.example.spingbootgoaproject.repository.PersonRepository;
import com.example.spingbootgoaproject.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    private PersonServices personServices;
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/getperson")
    public List<Person> getAllPerson(Person person) {
        return personServices.getAllPeople(person);
    }

    @PostMapping("/persons")
    public Person createPerson(@RequestBody Person person) {
        return personServices.createPerson(person);
    }
    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable Integer id) {
        Person person = personServices.findById(id);
        return person;
    }

    @DeleteMapping("/delete/{id}")
    public Person deleteUser(@PathVariable Integer id) {
        Person person = personServices.findById(id);
        personServices.delete(person);
        return person;

    }

    @PutMapping("/update/{id}")
    public Person updateUser(@PathVariable Integer id, @RequestBody Person personDetails) {
        Person person = personServices.findById(id);

        person.setFirstName(personDetails.getFirstName());
        person.setPhoneNumber(personDetails.getPhoneNumber());
        person.setLastName(personDetails.getLastName());
        person.setEmailAddress(personDetails.getEmailAddress());
        personServices.save(person);

        return person;
    }

}