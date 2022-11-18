package com.example.TokenAuthentication.services;

import com.example.TokenAuthentication.models.Doctor;
import com.example.TokenAuthentication.models.HCPProfile;


import java.util.List;

public interface DoctorService{

    List<Doctor> getAllDoctors();

    Doctor createDoctor(Doctor doctor);

    Doctor getDoctorById(Long id);

    Doctor updateDoctor(Long id, Doctor doctor);

    void deleteDoctor(Long id);
    List<Doctor> getDoctorsByName(String name);

    List<Doctor> getDoctorsByStatus(String status);
}
