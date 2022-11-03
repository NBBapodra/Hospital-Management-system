package com.example.TokenAuthentication.services.serviceImpl;


import com.example.TokenAuthentication.dto.exception.InvoiceNotFoundException;
import com.example.TokenAuthentication.dto.exception.ResourceNotFoundException;
import com.example.TokenAuthentication.models.Appointment;
import com.example.TokenAuthentication.models.Invoice;
import com.example.TokenAuthentication.repository.AppointmentRepository;
import com.example.TokenAuthentication.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {


    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Optional<Appointment> findById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }


    @Override
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Long id, Appointment appointment) {

        Appointment appointment1 ;
        try {
            appointment1 = appointmentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Appointment not found for this id :: " + id, "id", id));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
        appointment1.setId(appointment.getId());
        appointment1.setAppointmentDate(appointment.getAppointmentDate());
        appointment1.setAppointmentStatus(appointment.getAppointmentStatus());
        appointment1.setDescription(appointment.getDescription());
        appointment1.setUpdatedAt(appointment.getUpdatedAt());
        appointment1.setCreatedAt(appointment.getCreatedAt());

        return appointmentRepository.save(appointment1);
    }


    @Override
    public void deleteById(Long id) {
      appointmentRepository.deleteById(id);
    }

    @Override
    public Appointment getAppointmentById(Long id) {

        Optional<Appointment> appointment=appointmentRepository.findById(id);
        if(appointment.isPresent())
        {
            return appointment.get();
        }
        else {
            try {
                throw new InvoiceNotFoundException("Appointment not found");
            } catch (InvoiceNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
