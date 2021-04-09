package com.san.spring_boot_rest_api_crud_jpa_mysql.restcontroller;

import com.san.spring_boot_rest_api_crud_jpa_mysql.entity.Employee;
import com.san.spring_boot_rest_api_crud_jpa_mysql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class Employees {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
         return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable (value="id") Long id)
            throws ResourceNotFoundException {
        Employee employee= employeeRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("employee not found"));
        return ResponseEntity.ok().body(employee);
    }


    //WITHOUT 201 MESSAGE, Use ResonseEntity to show HTTP Response
    @PostMapping("/employee")
    public String createEmployee(@RequestBody Employee emp) {
        employeeRepository.save(emp);
        return "{\"msg\":\"created\"}";
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createNewEmployee(@RequestBody Employee emp) {
        Employee emp1=employeeRepository.save(emp);
        return new ResponseEntity(emp1, HttpStatus.CREATED);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable (value="id") Long id) {
        Employee emp=employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found"));
        employeeRepository.delete(emp);
        return new ResponseEntity(emp,HttpStatus.OK);
    }
}
