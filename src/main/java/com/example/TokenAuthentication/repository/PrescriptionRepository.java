package com.example.TokenAuthentication.repository;


import com.example.TokenAuthentication.models.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

    @Query(value = "SELECT p.patientName FROM Prescription p where p.patientName=:patientName")
    Prescription getPrescriptionByPatientName(@Param("patientName") String patientName);

}
