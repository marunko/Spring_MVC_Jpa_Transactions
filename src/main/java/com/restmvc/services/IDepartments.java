package com.restmvc.services;

import java.util.List;
import java.util.Optional;

import com.restmvc.models.Department;

public interface IDepartments {

	List<Department> getAll();
	Optional<Department> findById(int id);
	Department save(Department department);
	
}
