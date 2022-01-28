package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class EmployeeTests {
@Autowired
private EmployeeRepository repo;
   
@Test
//@Rollback(false)
public void testCreateEmployee()
{
	Employee employee= new Employee("somu","somu123@gmail.com");
	Employee savedEmployee=repo.save(employee);
	assertNotNull(savedEmployee);
}

@Test
public void testFindEmployeeByNameExits()
{
	String name="somu";
	Employee employee=repo.findByName(name);
	assertThat(employee.getName()).isEqualTo(name);
}
@Test
public void testFindEmployeeByNameNotExist()
{
	String name="lucy";
	Employee employee=repo.findByName(name);
	assertNull(employee);
}
@Test
//@Rollback(false)
public void testUpdateEmployee()
{
   String employeeName="Somya";
   Employee employee=new Employee(employeeName,"lucy@123.l@gmail.com");
   employee.setId(3);
   repo.save(employee);
   Employee updatedEmployee=repo.findByName(employeeName);
   assertThat(updatedEmployee.getName()).isEqualTo(employeeName);
}
@Test
public void testListEmployees()
{
  List<Employee> employees= (List<Employee>) repo.findAll();
  for(Employee employee:employees)
  {
	  System.out.println(employee);
  }
  assertThat(employees).size().isGreaterThan(0);
}
@Test
//@Rollback(false)
public void testDeleteProduct()
{
	Integer id =3;
	boolean isExistBeforeDelete=repo.findById(id).isPresent();
	repo.deleteById(id);
	boolean notExistAforeDelete=repo.findById(id).isPresent();
	assertTrue(isExistBeforeDelete);
	assertFalse(notExistAforeDelete);
}
}
