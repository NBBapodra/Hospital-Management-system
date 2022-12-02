package com.example.TokenAuthentication.services.serviceImpl;

import com.example.TokenAuthentication.models.DoctorDetails;
import com.example.TokenAuthentication.repository.DoctorDetailRepository;
import com.example.TokenAuthentication.services.DoctorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorDetailsServiceImpl implements DoctorDetailService {

    @Autowired
    private DoctorDetailRepository doctorDetailRepository;

    @Override
    public List<DoctorDetails> getAllDoctorsDetails() {
        return doctorDetailRepository.findAll();
    }

    @Override
    public DoctorDetails createDoctorDetails(DoctorDetails doctorDetails) {
        return doctorDetailRepository.save(doctorDetails);
    }
}
