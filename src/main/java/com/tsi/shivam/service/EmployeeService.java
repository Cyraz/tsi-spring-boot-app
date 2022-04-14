package com.tsi.shivam.service;

import com.tsi.shivam.model.Employee;
import com.tsi.shivam.model.ErrorResponse;
import com.tsi.shivam.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    /**
     * Get list of all employees from database using {@link EmployeeRepository}
     *
     * @return list of employees
     */
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    /**
     * Get employee by id using {@link EmployeeRepository}
     *
     * @param id Employee ID
     * @return Employee
     */
    public ResponseEntity<Object> getEmployeeById(long id) {
        var employee = employeeRepository.findById(id);

        if(employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(
                            ErrorResponse.builder()
                                    .errorCode("EMPLOYEE_NOT_FOUND")
                                    .errorMessage("Employee does not exist with id:" + id)
                                    .referenceId(UUID.randomUUID().toString())
                                    .build()
                    );
        }
    }

    /**
     * Save employee using {@link EmployeeRepository}
     * @param employee Employee data
     * @return saved Employee
     */
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    /**
     * Delete employee by id
     * @param id employee id
     * @return deleted employee id
     */
    public long deleteEmployee(long id) {
        employeeRepository.deleteById(id);
        return id;
    }

}
