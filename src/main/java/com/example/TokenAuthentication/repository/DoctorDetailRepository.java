package com.example.TokenAuthentication.repository;

import com.example.TokenAuthentication.models.DoctorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDetailRepository extends JpaRepository<DoctorDetails,Long> {
}
