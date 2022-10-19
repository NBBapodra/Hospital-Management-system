package com.example.TokenAuthentication.models;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "invoice_no",nullable = false)
    private String invoiceNo;

    @Column(name = "invoice_date",nullable = false)
    private Date invoiceDate;

    @Column(name = "patient_name",nullable = false)
    private String patientName;

    @Column(name = "age",nullable = false)
    private long age;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    @Column(name = "final_amount",nullable = false)
    private Double finalAmount;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}