package com.example.TokenAuthentication.services;

import com.example.TokenAuthentication.models.DoctorDetails;

import java.util.List;

public interface DoctorDetailService {

    List<DoctorDetails> getAllDoctorsDetails();

    DoctorDetails createDoctorDetails(DoctorDetails doctorDetails);
}
