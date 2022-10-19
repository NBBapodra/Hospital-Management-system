package com.example.TokenAuthentication.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordRequestDto {

 private String phoneNumber;
 private String userName;
 private String oneTimePassword;

}


