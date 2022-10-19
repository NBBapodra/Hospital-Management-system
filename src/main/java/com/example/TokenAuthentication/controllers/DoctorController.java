package com.example.TokenAuthentication.controllers;




import com.example.TokenAuthentication.models.Doctor;
import com.example.TokenAuthentication.services.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class DoctorController{

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/doctors")
    public ResponseEntity<Doctor> createDoctors(@Valid @RequestBody Doctor doctor) {

        Doctor doctor1=doctorService.createDoctor(doctor);
        return new ResponseEntity<Doctor>(doctor1,HttpStatus.CREATED);
    }


}
