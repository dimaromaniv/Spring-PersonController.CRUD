package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class PersonController {
    @Autowired
    PersonRepository people;

    @RequestMapping("/people")
    ResponseEntity<Person> createPerson(@RequestBody Person p) {
        return new ResponseEntity<>(people.save(p), HttpStatus.CREATED);
    }

    @RequestMapping("/people/{id}")
    ResponseEntity<Person> getPerson(@PathVariable Long id) {
        //Person p = people.findOne(id);
        return new ResponseEntity<>(people.findOne(id), HttpStatus.OK);
    }

    @RequestMapping("/people")
    List<Person> getPersonList() {
        List<Person> personList = new ArrayList<>();
        people.findAll().forEach(personList::add);
        if (personList.isEmpty()) {
            return (List<Person>) new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return (List<Person>) new ResponseEntity<>(personList, HttpStatus.OK);
        //people.findAll().forEach();
    }

    @RequestMapping("/people/{id}")
    ResponseEntity<Person> updatePerson(@RequestBody Person p) {
        return new ResponseEntity<>(people.save(p),HttpStatus.CREATED);
    }

    @RequestMapping("/people/{id}")
    void DeletePerson(@PathVariable Long id) {
        people.delete(id);
    }
}
