package com.example.TokenAuthentication.controllers;




import com.example.TokenAuthentication.dto.PrescriptionDto;
import com.example.TokenAuthentication.models.Prescription;
import com.example.TokenAuthentication.services.PrescriptionService;
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
public class PrescriptionController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PrescriptionService prescriptionService;


    @PostMapping("/prescriptions")
    public ResponseEntity<PrescriptionDto> createPrescription(@RequestBody PrescriptionDto  prescriptionDto) {

        // convert DTO to entity
        Prescription prescriptionRequest = modelMapper.map(prescriptionDto, Prescription.class);
        Prescription prescription= prescriptionService.createPrescription(prescriptionRequest);
        // convert entity to DTO

        PrescriptionDto prescriptionResponse = modelMapper.map(prescription,PrescriptionDto.class);
        return new ResponseEntity<PrescriptionDto>(prescriptionResponse, HttpStatus.CREATED);
    }

    @GetMapping("/prescriptions")
    public List<PrescriptionDto> getAllPrescription()
    {
        return prescriptionService.getAllPrescription().stream().map(post -> modelMapper.map(post,PrescriptionDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/prescriptions/{id}")
    public ResponseEntity<PrescriptionDto> getPrescriptionById(@PathVariable(value = "id") Long id)
    {
        Prescription prescription=prescriptionService.getPrescriptionById(id);
        PrescriptionDto prescriptionResponse = modelMapper.map(prescription,PrescriptionDto.class);
        if(prescription==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(prescriptionResponse);
    }

    @GetMapping("/prescriptions/{name}")
    public ResponseEntity<PrescriptionDto> getPrescriptionByPatientName(@PathVariable(value = "name") String patientName)
    {
        Prescription prescription=prescriptionService.getPrescriptionByPatientName(patientName);

        PrescriptionDto prescriptionResponse=modelMapper.map(prescription,PrescriptionDto.class);

        if(prescription==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(prescriptionResponse);
    }

    @PutMapping("/prescriptions/{id}")
    public ResponseEntity<PrescriptionDto> updatePrescription(@PathVariable(value = "id") Long id,
                                                            @Valid @RequestBody PrescriptionDto prescriptionDto){
        // convert DTO to entity
        Prescription prescriptionRequest = modelMapper.map(prescriptionDto, Prescription.class);

        Prescription prescription=prescriptionService.updatePrescription(id,prescriptionRequest);
        // convert entity to DTO
        PrescriptionDto prescriptionResponse = modelMapper.map(prescription,PrescriptionDto.class);
        return ResponseEntity.ok().body(prescriptionResponse);
    }

    @DeleteMapping("/prescriptions/{id}")
    public ResponseEntity deletePrescription(@PathVariable(value = "id") Long id)
    {
        prescriptionService.deletePrescription(id);
        return ResponseEntity.ok().body("Prescription deleted successFully");
    }


}
