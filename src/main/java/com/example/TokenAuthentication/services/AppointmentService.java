package com.example.TokenAuthentication.services;

import com.example.TokenAuthentication.models.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    Optional<Appointment> findById(Long id);

    List<Appointment> findAll();

    Appointment createAppointment(Appointment appointment);

    Appointment updateAppointment(Long id, Appointment appointment);

    void deleteById(Long id);

    Appointment getAppointmentById(Long id);
}
