package com.example.TokenAuthentication.services;

import com.example.TokenAuthentication.models.Doctor;


import java.util.List;

public interface DoctorService{

    List<Doctor> getAllDoctors();

    Doctor createDoctor(Doctor doctor);
}
