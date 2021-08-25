package com.restmvc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restmvc.models.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer>{
	Optional<Person> findByEmail(String email);
}
