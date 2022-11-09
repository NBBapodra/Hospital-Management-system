package com.example.TokenAuthentication.repository;


import com.example.TokenAuthentication.models.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

    @Query(value = "SELECT p FROM Prescription p where patientName=:patientName")
    List<Prescription> getPrescriptionByPatientName(@Param("patientName") String patientName);

}
