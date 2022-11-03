package com.example.TokenAuthentication.dto;


import com.example.TokenAuthentication.dto.exception.Enum.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {

    private long id;
    private LocalDateTime appointmentDate;
    private String description;
    private AppointmentStatus appointmentStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
