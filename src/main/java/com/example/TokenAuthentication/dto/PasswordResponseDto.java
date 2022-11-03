package com.example.TokenAuthentication.dto;


import com.example.TokenAuthentication.dto.exception.Enum.Otpstatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordResponseDto {

    private Otpstatus status;
    private String message;

}
