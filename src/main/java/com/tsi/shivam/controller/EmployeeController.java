package com.tsi.shivam.controller;

import com.tsi.shivam.model.Employee;
import com.tsi.shivam.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity getEmployeeById(@PathVariable Long id) {
       return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
       return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        var saveEmployee = employeeService.addEmployee(employee);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saveEmployee);

    }

}
