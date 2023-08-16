package io.zipcoder.crudapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
    String firstName;
    String lastName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idNumber;

    Person(String name, String lastName) {
        this.firstName = name;
        this.lastName = lastName;
        //this.idNumber = idNumber;
    }


}
