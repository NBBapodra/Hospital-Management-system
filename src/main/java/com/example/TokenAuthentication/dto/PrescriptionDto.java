package com.example.TokenAuthentication.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionDto {

    private long id;
    private String patientName;
    private String dosage;
    private long quantity;
    private LocalDateTime time;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
