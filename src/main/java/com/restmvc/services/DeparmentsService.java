package com.restmvc.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.restmvc.models.Department;
import com.restmvc.repository.DepRepository;
import com.restmvc.repository.PersonRepo;

@Service
public class DeparmentsService implements IDepartments{

	private DepRepository repo;
	@Autowired
	private EntityManagerFactory emf;
	
	@Autowired
	public DeparmentsService(DepRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public List<Department> getAll() {
		// TODO Auto-generated method stub
		List<Department> list = repo.findAll();
		return list;
	}

	@Override
	public Optional<Department> findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	@Transactional
	public Department save(Department department) {
		EntityManager tr = emf.createEntityManager(); 
		tr.getTransaction().begin();
		try {
			tr.persist(department);
			tr.flush();
			tr.getTransaction().commit();
		}
		catch(Exception ex) {
			tr.getTransaction().rollback();
			throw new RuntimeException(ex);
		}
		return department;
	}
	 
}
