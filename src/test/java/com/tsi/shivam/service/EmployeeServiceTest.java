package com.tsi.shivam.service;

import com.tsi.shivam.model.Employee;
import com.tsi.shivam.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@DisplayName("EmployeeService Test")
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    private EmployeeService employeeService;

    @Mock
    EmployeeRepository employeeRepositoryMock;

    @Test
    @DisplayName("Get employee")
    void shouldReturnAnEmployee() {
        var employee = new Employee();
        employee.setName("john");
        Mockito.when(employeeRepositoryMock.findById(1l)).thenReturn(Optional.of(employee));

        employeeService = new EmployeeService(employeeRepositoryMock);

        var employeeResponse = employeeService.getEmployeeById(1);

        Assertions.assertNotNull(employeeResponse);

    }
}
