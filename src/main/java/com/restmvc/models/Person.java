package com.restmvc.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="persons")
public class Person{
	@Id
	@Getter private int id;
	
	@Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;
    
    @Column(name = "position")
    private String position;
    
    @Column(nullable = true, name = "salary")
    private long salary;
    
    
    
   // @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "department_id", nullable=true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department department;
	
    
     
    
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	 
	public String getPosition() {
		return position;
	}
	public Department getDepartment() {
		return department;
	}
	 
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
