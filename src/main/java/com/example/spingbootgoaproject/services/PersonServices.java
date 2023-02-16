package com.example.spingbootgoaproject.services;

import com.example.spingbootgoaproject.module.Person;
import com.example.spingbootgoaproject.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServices {
    @Autowired
    private PersonRepository personRepository;

    // get all

    public List< Person> getAllPeople(Person person){
        return  personRepository.findAll();
    }

    // update a person record

//    public Person updatePerson(Person person,Integer id){
//      Person  person1= personRepository.findById(id).get();
//      return personRepository.save(person1);

//    }


    // delete
    public void delete(Person person) {
        personRepository.delete(person);
    }



    // post
    public Person createPerson(Person person){
        return personRepository.save(person);
    }


    public Person findById(Integer id) {
        Optional<Person> personResult = personRepository.findById(id);
        Person person = null;
        if (personResult.isPresent()) {
            person = personResult.get();
        }
        return person;
    }
    public void save(Person person) {
        personRepository.save(person);
    }
}
