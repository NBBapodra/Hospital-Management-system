package com.example.TokenAuthentication.dto;


import com.example.TokenAuthentication.dto.exception.Enum.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private long id;
    private String firstname;
    private String lastname;
    private String emailId;
    private String password;
    private long contact_no;
    private EmployeeStatus status;
    private Date createdAt;
    private LocalDateTime updatedAt;

//
//    public Employee dtoToEntity(EmployeeDto employeeDto)
//    {
//        Employee employee=new Employee();
//
//        employee.setId(employeeDto.getId());
//        employee.setFirstname(employeeDto.getFirstname());
//        employee.setLastname(employeeDto.getLastname());
//        employee.setEmailId(employeeDto.getEmailId());
//        employee.setPassword(employeeDto.getPassword());
//        employee.setContact_no(employeeDto.getContact_no());
//        employee.setStatus(employeeDto.getStatus());
//        employee.setCreatedAt(employeeDto.getCreatedAt());
//        employee.setUpdatedAt(employeeDto.getUpdatedAt());
//
//        return employee;
//    }
//
//    public EmployeeDto entityToDto(Employee employee)
//    {
//        EmployeeDto employeeDto=new EmployeeDto();
//
//        employeeDto.setFirstname(employee.getFirstname());
//        employeeDto.setFirstname(employee.getFirstname());
//        employeeDto.setLastname(employee.getLastname());
//        employeeDto.setEmailId(employee.getEmailId());
//        employeeDto.setPassword(employee.getPassword());
//        employeeDto.setContact_no(employee.getContact_no());
//        employeeDto.setStatus(employee.getStatus());
//        employeeDto.setCreatedAt(employee.getCreatedAt());
//        employeeDto.setUpdatedAt(employee.getUpdatedAt());
//
//        return employeeDto;
//    }

}
