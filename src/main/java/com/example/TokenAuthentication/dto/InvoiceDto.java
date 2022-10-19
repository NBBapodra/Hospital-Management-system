package com.example.TokenAuthentication.dto;



import com.example.TokenAuthentication.models.Medicine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {

    private long id;
    private String invoiceNo;
    private Date invoiceDate;
    private String patientName;
    private long age;
    private Medicine medicine;
    private Double finalAmount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
