package com.restmvc.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restmvc.models.Department;
import com.restmvc.services.DeparmentsService;

@RestController
@RequestMapping("/departments")
public class DepartmentsConroller {
	
	private DeparmentsService ds;
	
	@Autowired
	public DepartmentsConroller(DeparmentsService ds) {
		this.ds = ds;
	}
	
	@GetMapping()
	public ResponseEntity<List<Department>> getThem(){
		
		List<Department> list = ds.getAll();
		return list!=null ? new ResponseEntity<>(list, HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.NO_CONTENT); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> getbyid(@PathVariable int id){
		
		Department department = ds.findById(id).get();
		return department!=null ? new ResponseEntity<>(department, HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.NOT_FOUND); 
	}
	
	@Transactional
	@PostMapping("/create")
	public ResponseEntity<Department> create(@RequestBody Department department){
		
		ds.save(department);
		return department!=null ? new ResponseEntity<>(department, HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
}
