package com.example.TokenAuthentication.controllers;




import com.example.TokenAuthentication.dto.DoctorDto;
import com.example.TokenAuthentication.dto.EmployeeDto;
import com.example.TokenAuthentication.dto.HCPDto;
import com.example.TokenAuthentication.models.Doctor;
import com.example.TokenAuthentication.models.Employee;
import com.example.TokenAuthentication.models.HCPProfile;
import com.example.TokenAuthentication.services.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class DoctorController{

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/doctors")
    public ResponseEntity<DoctorDto> createDoctors(@Valid @RequestBody DoctorDto doctorDto) {

        // convert DTO to entity
        Doctor doctorRequest = modelMapper.map(doctorDto, Doctor.class);
        Doctor doctor= doctorService.createDoctor(doctorRequest);
        // convert entity to DTO
        DoctorDto  doctorResponse = modelMapper.map(doctor, DoctorDto.class);

        return new ResponseEntity<DoctorDto>(doctorResponse, HttpStatus.CREATED);
    }


    @GetMapping("/doctors")
    public List<DoctorDto> getAllDoctors() {
        return doctorService.getAllDoctors().stream().map(post -> modelMapper.map(post, DoctorDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable(value = "id") Long id)
    {
        Doctor doctor=doctorService.getDoctorById(id);
        DoctorDto doctorResponse = modelMapper.map(doctor,DoctorDto.class);
        if(doctor==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(doctorResponse);
    }


    @PutMapping("/doctors/{id}")
    public ResponseEntity<DoctorDto> updateDoctors(@PathVariable(value = "id") Long id,
                                            @Valid @RequestBody DoctorDto doctorDto){
        // convert DTO to entity
        Doctor doctorRequest = modelMapper.map(doctorDto, Doctor.class);
        Doctor doctor=doctorService.updateDoctor(id,doctorRequest);
        // convert entity to DTO
        DoctorDto doctorResponse = modelMapper.map(doctor,DoctorDto.class);
        return ResponseEntity.ok().body(doctorResponse);
    }

    @DeleteMapping("/doctors/{id}")
    public ResponseEntity deleteDoctors(@PathVariable(value = "id") Long id)
    {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok().body("Doctor deleted successFully");
    }

    @GetMapping("/doctors/name/{name}")
    public ResponseEntity<List<Doctor>> getDoctorsByName(@PathVariable(value = "name") String name)
    {
        return new ResponseEntity<>(doctorService.getDoctorsByName(name),HttpStatus.OK);
    }


    @GetMapping("/doctors/status/{status}")
    public ResponseEntity<List<Doctor>> getDoctorsByStatus(@PathVariable(value = "status") String status)
    {
        return new ResponseEntity<>(doctorService.getDoctorsByStatus(status),HttpStatus.OK);
    }
}
