package com.example.TokenAuthentication.services.serviceImpl;

import com.example.TokenAuthentication.exception.ResourceNotFoundException;
import com.example.TokenAuthentication.models.Doctor;
import com.example.TokenAuthentication.repository.DoctorRepository;
import com.example.TokenAuthentication.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.saveAndFlush(doctor);
    }

    @Override
    public Doctor getDoctorById(Long id) {

        Optional<Doctor> doctor=doctorRepository.findById(id);

        if(doctor.isPresent()) {
            return doctor.get();
        }else {
            try {
                throw new ResourceNotFoundException("Doctor not Found", "id", id);
            } catch (ResourceNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctor) {


        Doctor doctor1;

        try {
            doctor1 = doctorRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Doctor not found for this id :: " + id, "id", id));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }

        doctor1.setId(doctor.getId());
        doctor1.setName(doctor.getName());
        doctor1.setImage(doctor.getImage());
        doctor1.setAddress(doctor.getAddress());
        doctor1.setCity(doctor.getCity());
        doctor1.setState(doctor.getState());
        doctor1.setCountry(doctor.getCountry());
        doctor1.setEmailId(doctor.getEmailId());
        doctor1.setLocation(doctor.getLocation());
        doctor1.setStatus(doctor.getStatus());
        doctor1.setCreatedAt(doctor.getCreatedAt());
        doctor1.setUpdatedAt(doctor.getUpdatedAt());

        return doctorRepository.save(doctor1);
    }

    @Override
    public void deleteDoctor(Long id) {


        try {
            Doctor doctor1 = doctorRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Doctor not found for this id :: " + id, "id", id));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
        doctorRepository.deleteById(id);
    }

    @Override
    public List<Doctor> getDoctorsByName(String name) {
        return doctorRepository.findByName(name);
    }

    @Override
    public List<Doctor> getDoctorsByStatus(String status) {
        return doctorRepository.findByStatus(status);
    }


}
