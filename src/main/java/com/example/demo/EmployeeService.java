package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import java.util.List;

import com.example.demo.Employee;
import com.example.demo.EmployeeRepository;

@Service
public class EmployeeService {
  
  @Autowired
  EmployeeRepository emprepo;
  
  public List<Employee>getAllEmployee()
  {
		    List<Employee> employee = new ArrayList<>();
		    emprepo.findAll().forEach(employee::add);
		    return employee;
		}
  
  public Employee getEmployeeid(int id)
  {
	  return emprepo.findById(id).get();
  }
  public void saveOrUpdate(Employee employee) {
	  emprepo.save(employee);
  }
  public void delete(int id)
  {
	  emprepo.deleteById(id);
  }
  public void update(Employee employee,int id)
  {
	  emprepo.save(employee);
  }
}





