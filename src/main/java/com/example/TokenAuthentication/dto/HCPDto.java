package com.example.TokenAuthentication.dto;


import com.example.TokenAuthentication.models.City;
import com.example.TokenAuthentication.models.Country;
import com.example.TokenAuthentication.models.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HCPDto {

    private long id;
    private String firstname;
    private String lastname;
    private String emailId;
    private String image;
    private String education;
    private Long experience;
    private Long aadharCardNo;
    private String panNo;
    private String gender;
    private long contact_no;
    private String address;
    private City city;
    private State state;
    private Country country;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
