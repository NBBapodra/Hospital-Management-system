package com.example.TokenAuthentication.repository;

import com.example.TokenAuthentication.models.HCPProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HCPRepository extends JpaRepository<HCPProfile,Long> {

    @Query(value = "SELECT h FROM HCPProfile h where firstname=:firstname")
    List<HCPProfile> findByFirstName(@Param("firstname") String firstname);

    @Query(value = "SELECT h FROM HCPProfile h where lastname=:lastname")
    List<HCPProfile> findByLastName(@Param("lastname") String lastname);

    @Query(value = "SELECT h FROM HCPProfile h where education=:education")
    List<HCPProfile> findByEducation(@Param("education") String education);


}
