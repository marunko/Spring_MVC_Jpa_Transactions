package com.restmvc.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SalaryManagerImp implements SalaryManager{
	
	  @Autowired
	  private EntityManager entityManager;
	  
	  
}
