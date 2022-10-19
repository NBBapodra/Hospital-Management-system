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
    private Category category;
    private String education;
    private Speciality speciality;
    private Time availability;
    private Long experience;
    private String achievements;
    private String awards;
    private String image;
    private Event event;
    private String certificates;
    private String documents;
    private Long consultationFees;
    private DoctorStatus status;
    private Location location;
    private Services services;
    private DoctorGalleryImage galleryImage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
