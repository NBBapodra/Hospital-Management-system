package com.example.TokenAuthentication.services;


import com.example.TokenAuthentication.models.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getAllPatients();

    Patient createPatient(Patient patient);

    Patient updatePatient(Long id,Patient patient);

    void deletePatient(Long id);

    Patient getPatientById(Long id);
}
