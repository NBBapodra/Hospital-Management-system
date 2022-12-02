package com.example.TokenAuthentication.dto;


import com.example.TokenAuthentication.models.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDetailDto {

    private long id;
    private Category category;
    private String education;
    private Speciality speciality;
    private Time availability;
    private Long experience;
    private String achievements;
    private String awards;
    private Event event;
    private String certificates;
    private String documents;
    private Long consultationFees;
    private Services services;
    private DoctorGalleryImage galleryImage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
