package com.example.TokenAuthentication.controllers;

import com.example.TokenAuthentication.dto.EmployeeDto;
import com.example.TokenAuthentication.models.Employee;
import com.example.TokenAuthentication.repository.EmployeeRepository;
import com.example.TokenAuthentication.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;



    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees().stream().map(post -> modelMapper.map(post, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(value = "id") Long employeeId)
    {
        Employee employee=employeeService.getEmployeeById(employeeId);

        EmployeeDto employeeResponse = modelMapper.map(employee, EmployeeDto.class);

        if(employee==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(employeeResponse);
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {

        // convert DTO to entity
        Employee employeeRequest = modelMapper.map(employeeDto, Employee.class);

        Employee employee= employeeService.createEmployee(employeeRequest);

        // convert entity to DTO
        EmployeeDto  employeeResponse = modelMapper.map(employee, EmployeeDto.class);

        return new ResponseEntity<EmployeeDto>(employeeResponse, HttpStatus.CREATED);

    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                   @Valid @RequestBody EmployeeDto employeeDto){

        // convert DTO to entity
        Employee employeeRequest = modelMapper.map(employeeDto, Employee.class);

        Employee employee= employeeService.updateEmployee(employeeId,employeeRequest);
        // convert entity to DTO
        EmployeeDto  employeeResponse = modelMapper.map(employee, EmployeeDto.class);
        return ResponseEntity.ok().body(employeeResponse);
    }

    @DeleteMapping("/employees/{id}")
     public ResponseEntity deleteEmployee(@PathVariable(value = "id") Long employeeId)
    {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok().body("Employee deleted successFully");
    }


    @GetMapping("/employees/pages")
    public Page<Employee> employeePagination(@RequestParam Integer pageNo,@RequestParam Integer pageSize)
    {
        return employeeService.getEmployeePagination(pageNo,pageSize);
    }

}
