package com.example.demo.Controller;

import java.util.List;
//import com.somu.testing.service.*;
import com.example.demo.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Employee;
//import tech.employee.service.EmployeeController;
import com.example.demo.EmployeeService;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@GetMapping("/emply")
	private List<Employee>getAllEmployee()
	{
		return employeeService.getAllEmployee(); 
	}
	@GetMapping("/emply/{id}")
	private Employee getEmployee(@PathVariable("id")int id)
	{
		return employeeService.getEmployeeid(id);
	}
	@DeleteMapping("/emply/{id}")
	private void deleteEmployee(@PathVariable("id")int id)
	{
		employeeService.delete(id);
	}
	@PostMapping("/emply")
	private int saveEmployee(@RequestBody Employee employee)
	{
		employeeService.saveOrUpdate(employee);
		return employee.getId();
	}
	@PutMapping("/emply")
	private Employee update(@RequestBody Employee employee)
	{
		employeeService.saveOrUpdate(employee);
		return employee;
	}
	
}