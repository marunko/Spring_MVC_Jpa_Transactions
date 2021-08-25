package com.restmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restmvc.models.Person;
import com.restmvc.services.DeparmentsService;
import com.restmvc.services.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonsController {
	
	PersonService ps;
	@Autowired
	DeparmentsService ds;
	
	@Autowired
	public PersonsController(PersonService ps) {
		this.ps = ps;
	}
	
	@GetMapping()
	public ResponseEntity<List<Person>> get_all(){
		List<Person> list = ps.getAllStudents();
		//list.forEach(x->System.out.println(x.getName()));
		return (list != null) ? new ResponseEntity<>(list, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/create/{id}")
	public ResponseEntity<?> create(@RequestBody Person person, @PathVariable int id){
		 
		person.setDepartment(ds.findById(id).get()); // set department 
		Person p = ps.save(person);
		return p!=null ? new ResponseEntity<>(p, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.CREATED);
	}
	 
}
