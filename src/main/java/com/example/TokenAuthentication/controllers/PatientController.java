package com.example.TokenAuthentication.controllers;




import com.example.TokenAuthentication.dto.PatientDto;
import com.example.TokenAuthentication.models.Patient;
import com.example.TokenAuthentication.repository.PatientRepository;
import com.example.TokenAuthentication.services.PatientService;
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
public class PatientController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientService patientService;


    @GetMapping("/patients")
    public List<PatientDto> getAllPatients() {
        return patientService.getAllPatients().stream().map(post -> modelMapper.map(post, PatientDto.class))
                .collect(Collectors.toList());
    }


    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientDto> getPatientsById(@PathVariable(value = "id") Long id)
    {
        Patient patient=patientService.getPatientById(id);
        PatientDto patientResponse = modelMapper.map(patient, PatientDto.class);
        if(patient==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(patientResponse);
    }

    @PostMapping("/patients")
    public ResponseEntity<PatientDto> createPatient(@Valid @RequestBody PatientDto patientDto) {

        // convert DTO to entity
        Patient patientRequest = modelMapper.map(patientDto, Patient.class);
       Patient patient= patientService.createPatient(patientRequest);
       // convert entity to DTO
        PatientDto  patientResponse = modelMapper.map(patient, PatientDto.class);

        return new ResponseEntity<PatientDto>(patientResponse, HttpStatus.CREATED);

    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable(value = "id") Long id,
                                                      @Valid @RequestBody PatientDto patientDto){

        // convert DTO to entity
        Patient patientRequest = modelMapper.map(patientDto, Patient.class);

        Patient patient= patientService.updatePatient(id,patientRequest);
        // convert entity to DTO
        PatientDto  patientResponse = modelMapper.map(patient, PatientDto.class);
        return ResponseEntity.ok().body(patientResponse);
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity deletePatient(@PathVariable(value = "id") Long id)
    {
        patientService.deletePatient(id);
        return ResponseEntity.ok().body("Patient deleted successFully");
    }


}
