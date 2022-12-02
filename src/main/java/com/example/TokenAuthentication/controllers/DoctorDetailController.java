package com.example.TokenAuthentication.controllers;

import com.example.TokenAuthentication.dto.DoctorDetailDto;
import com.example.TokenAuthentication.models.DoctorDetails;
import com.example.TokenAuthentication.services.DoctorDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DoctorDetailController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DoctorDetailService doctorDetailService;

    @PostMapping("/doctorDetails")
    public ResponseEntity<DoctorDetailDto> createDoctorDetails(@RequestBody DoctorDetailDto doctorDetailDto) {

        // convert DTO to entity
        DoctorDetails doctorDetailsRequest = modelMapper.map(doctorDetailDto, DoctorDetails.class);
        DoctorDetails doctorDetails= doctorDetailService.createDoctorDetails(doctorDetailsRequest);
        // convert entity to DTO
        DoctorDetailDto doctorDetailResponse = modelMapper.map(doctorDetails,DoctorDetailDto.class);
        return new ResponseEntity<DoctorDetailDto>(doctorDetailResponse, HttpStatus.CREATED);
    }
}
