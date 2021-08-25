package com.restmvc.services;

import java.util.List;
import java.util.Optional;

import com.restmvc.models.Person;

public interface IPerson {
	List<Person> getAllStudents();
    Optional<Person> findById(int id);
    Optional<Person> findByEmail(String email);
    Person save(Person std);
    void deleteById(int id);
}
