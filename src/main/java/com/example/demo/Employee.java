package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name="employee_data")
//@SQLDelete(sql="UPDATE table employee_data Set deleted=true WHERE id =?")
//@Where(clause="deleted=false")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private int id;
	
	@Column(length=64)
 private String name;
 private String email;
 //private boolean deleted=Boolean.FALSE;
public Employee(String name, String email) {
	
	this.name = name;
	this.email = email;
}
public Employee() {
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setSalary(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", salary=" + email + "]";
}

}

