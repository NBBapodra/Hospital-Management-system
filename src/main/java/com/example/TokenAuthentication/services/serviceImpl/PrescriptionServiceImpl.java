package com.example.TokenAuthentication.services.serviceImpl;

import com.example.TokenAuthentication.exception.PrescriptionNotFoundException;
import com.example.TokenAuthentication.models.Prescription;
import com.example.TokenAuthentication.repository.PrescriptionRepository;
import com.example.TokenAuthentication.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;


    @Override
    public List<Prescription> getAllPrescription() {
        return prescriptionRepository.findAll();
    }

    @Override
    public List<Prescription> getPrescriptionByPatientName(String patientName) {
        return prescriptionRepository.getPrescriptionByPatientName(patientName);
    }

    @Override
    public Prescription createPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription updatePrescription(Long id, Prescription prescription) {

        Prescription prescription1;

        try {
            prescription1 = prescriptionRepository.findById(id)
                    .orElseThrow(() -> new PrescriptionNotFoundException("Prescription not found for this id:",id));
        } catch (PrescriptionNotFoundException e) {
            throw new RuntimeException(e);
        }

        prescription1.setId(prescription.getId());
        prescription1.setDosage(prescription.getDosage());
        prescription1.setTime(prescription.getTime());
        prescription1.setQuantity(prescription.getQuantity());
        prescription1.setPatientName(prescription.getPatientName());
        prescription1.setCreatedAt(prescription.getCreatedAt());
        prescription1.setUpdatedAt(prescription.getUpdatedAt());

        return prescriptionRepository.save(prescription1);
    }

    @Override
    public void deletePrescription(Long id) {

        try {
            Prescription prescription=prescriptionRepository.findById(id)
                    .orElseThrow(() -> new PrescriptionNotFoundException("Prescription NOT Found For this id:",id));
        } catch (PrescriptionNotFoundException e) {
            throw new RuntimeException(e);
        }
        prescriptionRepository.deleteById(id);
    }

    @Override
    public Prescription getPrescriptionById(Long id) {

        Optional<Prescription> prescription=  prescriptionRepository.findById(id);

        if(prescription.isPresent()) {
            return prescription.get();
        }else {
            try {
                throw new PrescriptionNotFoundException("Prescription NOT Found For this id:", id);
            } catch (PrescriptionNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
