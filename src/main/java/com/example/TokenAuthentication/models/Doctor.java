package com.example.TokenAuthentication.models;

import com.example.TokenAuthentication.exception.Enum.DoctorStatus;
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
@Table(name = "doctor_profile")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email_id", nullable = false)
    private String emailId;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "state_id")
    private State state;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "address")
    private String address;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "education")
    private String education;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
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

    @Column(name = "image")
    private String image;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "certificates")
    private String certificates;

    @Column(name = "documents")
    private String documents;

    @Column(name = "consultation_fees")
    private Long consultationFees;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20)
    private DoctorStatus status;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "service_id")
    private Services services;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "gallery_id")
    private DoctorGalleryImage galleryImage;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}
