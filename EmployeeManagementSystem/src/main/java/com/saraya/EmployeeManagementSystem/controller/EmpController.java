package com.saraya.EmployeeManagementSystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind. annotation.RestController;

import com.saraya.EmployeeManagementSystem.entitie.Employee;
import com.saraya.EmployeeManagementSystem.exception.ResourceNotFoundException;
import com.saraya.EmployeeManagementSystem.repos.EmpRepository;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmpController {

	
	
	@Autowired private EmpRepository repos;
	
	@GetMapping
	public List<Employee> getAll(){
		
		return repos.findAll();
	}
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee){
		
		return repos.save(employee);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEMployeeById(@PathVariable Long id){
		Employee emple = repos.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("the employee with id :" +id + "does not exist in the database"));
		return ResponseEntity.ok(emple);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> editEmployee(@PathVariable Long id,
			                                    @RequestBody Employee employeeDetail){
		Employee emple = repos.findById(id).orElseThrow(()-> 
		new ResourceNotFoundException("the employee of"+ id + "does not exist in the database"));
		emple.setFullname(employeeDetail.getFullname());
		emple.setAddress(employeeDetail.getAddress());
		emple.setEmail(employeeDetail.getEmail());
		emple.setIdentityCard(employeeDetail.getIdentityCard());
		emple.setSalary(employeeDetail.getSalary());
		emple.setId(employeeDetail.getId());
		
		Employee employeeUpdated = repos.save(emple);
        return   ResponseEntity.ok(employeeUpdated);	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteById(@PathVariable Long id){
		Employee emple = repos.findById(id).orElseThrow(()-> 
	
	new ResourceNotFoundException("the employee with id :" +id + "does not exist in the database"));
	repos.delete(emple);
	Map<String, Boolean> response = new HashMap<>();
	  response.put("Deleted Succesfully", Boolean.TRUE);
	  return ResponseEntity.ok(response);
	}	
}
