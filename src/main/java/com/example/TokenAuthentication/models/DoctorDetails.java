package com.example.TokenAuthentication.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctor_details")
public class DoctorDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "education")
    private String education;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    @Column(name = "availability")
    private Time availability;

    @Column(name = "experience")
    private Long experience;

    @Column(name = "achievements")
    private String achievements;

    @Column(name = "award")
    private String awards;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "certificates")
    private String certificates;

    @Column(name = "documents")
    private String documents;

    @Column(name = "consultation_fees")
    private Long consultationFees;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_id")
    private Services services;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gallery_id")
    private DoctorGalleryImage galleryImage;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
