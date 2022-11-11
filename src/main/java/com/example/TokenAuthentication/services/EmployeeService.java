package com.example.TokenAuthentication.services;

import com.example.TokenAuthentication.models.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Long employeeId,  Employee employee);

    void deleteEmployee(Long employeeId);

    Employee getEmployeeById(Long employeeId);

    Page<Employee> getEmployeePagination(Integer pageNo, Integer pageSize);
}
