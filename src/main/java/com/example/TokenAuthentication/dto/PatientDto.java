package com.example.TokenAuthentication.dto;

import com.example.TokenAuthentication.exception.Enum.PatientStatus;
import com.example.TokenAuthentication.models.City;
import com.example.TokenAuthentication.models.Country;
import com.example.TokenAuthentication.models.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {


    private long id;
    private String firstname;
    private String lastname;
    private String emailId;
    private Date dob;
    private long age;
    private String image;
    private String blood_group;
    private String gender;
    private Date admission_date;
    private String address;
    private City city;
    private State state;
    private Country country;
    private long contact_no;
    private String guardian_name;
    private long guardian_contact_no;
    private long rating;
    private String occupation;
    private PatientStatus status;
    private Date createdAt;
    private LocalDateTime updatedAt;

}

