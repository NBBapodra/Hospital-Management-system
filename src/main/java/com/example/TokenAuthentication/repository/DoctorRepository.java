package com.example.TokenAuthentication.repository;

import com.example.TokenAuthentication.models.Doctor;
import com.example.TokenAuthentication.models.HCPProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    @Query(value = "SELECT d FROM Doctor d where name=:name")
    List<Doctor> findByName(@Param("name") String name);

    @Query(value = "SELECT d FROM Doctor d where location=:location")
    List<Doctor> findByLocation(@Param("location") String location);

    @Query(value = "SELECT d FROM Doctor d where status=:status")
    List<Doctor> findByStatus(@Param("status") String status);
}
