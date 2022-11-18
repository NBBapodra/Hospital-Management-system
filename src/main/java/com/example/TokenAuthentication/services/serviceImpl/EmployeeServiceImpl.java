package com.example.TokenAuthentication.services.serviceImpl;



import com.example.TokenAuthentication.exception.ResourceNotFoundException;
import com.example.TokenAuthentication.models.Employee;
import com.example.TokenAuthentication.repository.EmployeeRepository;
import com.example.TokenAuthentication.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
      return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public Employee updateEmployee(Long employeeId, Employee employeeRequest) {
        Employee employee1 ;
        try {
            employee1 = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId, "id", employeeId));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }

        employee1.setId(employeeRequest.getId());
        employee1.setFirstname(employeeRequest.getFirstname());
        employee1.setLastname(employeeRequest.getLastname());
        employee1.setEmailId(employeeRequest.getEmailId());
        employee1.setContact_no(employeeRequest.getContact_no());
        employee1.setPassword(employeeRequest.getPassword());
        employee1.setStatus(employeeRequest.getStatus());

      return employeeRepository.save(employee1);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        try {
            Employee employee = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {

      Optional<Employee> employee=  employeeRepository.findById(employeeId);

        if(employee.isPresent()) {
            return employee.get();
        }else {
            try {
                throw new ResourceNotFoundException("Employee", "id", employeeId);
            } catch (ResourceNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public Page<Employee> getEmployeePagination(Integer pageNo, Integer pageSize)   {
        Pageable pageable= PageRequest.of(pageNo,pageSize,Sort.by(Sort.Order.asc("id")));
        return employeeRepository.findAll(pageable);
    }
}
