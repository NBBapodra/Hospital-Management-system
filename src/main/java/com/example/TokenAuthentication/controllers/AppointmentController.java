package com.example.TokenAuthentication.controllers;


import com.example.TokenAuthentication.dto.AppointmentDto;
import com.example.TokenAuthentication.dto.InvoiceDto;
import com.example.TokenAuthentication.models.Appointment;
import com.example.TokenAuthentication.models.Invoice;
import com.example.TokenAuthentication.services.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto) {

        // convert DTO to entity
        Appointment appointmentRequest = modelMapper.map(appointmentDto, Appointment.class);
        Appointment appointment= appointmentService.createAppointment(appointmentRequest);
        // convert entity to DTO

        AppointmentDto appointmentResponse = modelMapper.map(appointment,AppointmentDto.class);
        return new ResponseEntity<AppointmentDto>(appointmentResponse, HttpStatus.CREATED);
    }

    @GetMapping("/appointments")
    public List<AppointmentDto> getAllAppointment()
    {
        return appointmentService.findAll().stream().map(post -> modelMapper.map(post,AppointmentDto.class))
                .collect(Collectors.toList());
    }


    @GetMapping("/appointments/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable(value = "id") Long id)
    {
       Appointment appointment=appointmentService.getAppointmentById(id);
        AppointmentDto appointmentResponse = modelMapper.map(appointment,AppointmentDto.class);
        if(appointment==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(appointmentResponse);
    }

    @PutMapping("/appointments/{id}")
    public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable(value = "id") Long id,
                                                    @Valid @RequestBody AppointmentDto appointmentDto){
        // convert DTO to entity
        Appointment appointmentRequest = modelMapper.map(appointmentDto, Appointment.class);

        Appointment appointment=appointmentService.updateAppointment(id,appointmentRequest);
        // convert entity to DTO
        AppointmentDto appointmentResponse = modelMapper.map(appointment,AppointmentDto.class);
        return ResponseEntity.ok().body(appointmentResponse);
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity deletePatient(@PathVariable(value = "id") Long id)
    {
        appointmentService.deleteById(id);
        return ResponseEntity.ok().body("Appointment deleted successFully");
    }

}
