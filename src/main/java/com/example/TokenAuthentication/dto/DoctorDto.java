package com.example.TokenAuthentication.dto;


import com.example.TokenAuthentication.exception.Enum.DoctorStatus;
import com.example.TokenAuthentication.models.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto{

    private long id;
    private String name;
    private String emailId;
    private City city;
    private State state;
    private Country country;
    private String address;
    private String image;
    private DoctorStatus status;
    private Location location;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
