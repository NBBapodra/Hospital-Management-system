package com.example.TokenAuthentication.services.serviceImpl;

import com.example.TokenAuthentication.exception.ResourceNotFoundException;
import com.example.TokenAuthentication.models.Patient;
import com.example.TokenAuthentication.repository.PatientRepository;
import com.example.TokenAuthentication.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;



    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {

        Patient patient1 ;
        try {
            patient1 = patientRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + id, "id", id));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }

        patient1.setId(patient.getId());
        patient1.setFirstname(patient.getFirstname());
        patient1.setLastname(patient.getLastname());
        patient1.setEmailId(patient.getEmailId());
        patient1.setDob(patient.getDob());
        patient1.setAge(patient.getAge());
        patient1.setImage(patient.getImage());
        patient1.setBlood_group(patient.getBlood_group());
        patient1.setGender(patient.getGender());
        patient1.setAddress(patient.getAddress());
        patient1.setAdmission_date(patient.getAdmission_date());
        patient1.setCity(patient.getCity());
        patient1.setState(patient.getState());
        patient1.setCountry(patient.getCountry());
        patient1.setContact_no(patient.getContact_no());
        patient1.setGuardian_name(patient.getGuardian_name());
        patient1.setGuardian_contact_no(patient.getGuardian_contact_no());
        patient1.setRating(patient.getRating());
        patient1.setOccupation(patient.getOccupation());
        patient1.setStatus(patient.getStatus());
        patient1.setCreatedAt(patient.getCreatedAt());
        patient1.setUpdatedAt(patient.getUpdatedAt());

        return patientRepository.save(patient1);
    }

    @Override
    public void deletePatient(Long id) {

        try {
            Patient patient = patientRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }

       patientRepository.deleteById(id);

    }

    @Override
    public Patient getPatientById(Long id) {

        Optional<Patient> patient=patientRepository.findById(id);

        if(patient.isPresent())
        {
            return patient.get();
        }
        else {
            try {
                throw new ResourceNotFoundException("Patient", "id" , id);
            } catch (ResourceNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
