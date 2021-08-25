package com.restmvc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restmvc.models.Person;
import com.restmvc.repository.PersonRepo;

@Service
public class PersonService implements IPerson{
	
	PersonRepo repository;

	@Autowired
	public PersonService(PersonRepo repository) {
		this.repository = repository;
	}
	 
	
	public List<Person> getAllStudents() {
		 
		return this.repository.findAll();
	}

	public Optional<Person> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Person> findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public Person save(Person std) {
		// TODO Auto-generated method stub
		repository.save(std);
		return std;
	}

	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
