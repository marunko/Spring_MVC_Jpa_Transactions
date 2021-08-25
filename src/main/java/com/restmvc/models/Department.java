package com.restmvc.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="department")
@Setter
public class Department {

	@Id
	private int id;
	
	private String department;
	
	private long budget;
	
	public int getId() {
		return id;	
	}
	public String getDepartment() {
		return department;	
	}
	public long getBudget() {
		return budget;	
	}
	
	public void setDepartment(String d) {
		department = d;
	}
	public void setBudget(long bud) {
		budget = bud;
	}
}
