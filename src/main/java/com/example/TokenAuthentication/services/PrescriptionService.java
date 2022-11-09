package com.example.TokenAuthentication.services;


import com.example.TokenAuthentication.models.Prescription;

import java.util.List;

public interface PrescriptionService {

    List<Prescription> getAllPrescription();

   List<Prescription> getPrescriptionByPatientName(String patientName);

    Prescription createPrescription(Prescription prescription);

    Prescription updatePrescription(Long id,  Prescription prescription);

    void deletePrescription(Long id);

    Prescription getPrescriptionById(Long id);
}
