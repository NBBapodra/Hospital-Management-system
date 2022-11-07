package com.example.TokenAuthentication.services.serviceImpl;


import com.example.TokenAuthentication.config.TwilioConfig;
import com.example.TokenAuthentication.exception.Enum.Otpstatus;
import com.example.TokenAuthentication.dto.PasswordRequestDto;
import com.example.TokenAuthentication.dto.PasswordResponseDto;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class TwilioOTPService {

    @Autowired
    private TwilioConfig twilioConfig;

    Map<String,String> otpMap=new HashMap<>();

    public Mono<PasswordResponseDto> sendOTPForPasswordReset(PasswordRequestDto passwordRequestDto)
    {
        PasswordResponseDto passwordResponseDto =null;
        try {
            PhoneNumber to = new PhoneNumber(passwordRequestDto.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());

            String otp = generateOTP();
            String otpMessage = "Dear Customer,Your OTP is ##" + otp + "##. Use this OTP to Reset Your Password..  Thank You..";

            Message message = Message
                    .creator(to, from, otpMessage).create();

            otpMap.put(passwordRequestDto.getUserName(), otp);


            passwordResponseDto = new PasswordResponseDto(Otpstatus.DELIVERED, otpMessage);
        }catch(Exception e)
        {
           passwordResponseDto= new PasswordResponseDto(Otpstatus.FAILED,e.getMessage());
        }
        
        return Mono.justOrEmpty(passwordResponseDto);
    }


    public Mono<String> validateOTP(String otp,String userName)
    {
        if(otp.equals(otpMap.get(userName)))
        {
            return Mono.just("Your OTP is Validate..");
        }
        else
        {
            return Mono.error(new IllegalArgumentException("Invalid OTP Please Retry!"));
        }
    }

    // 6 digit OTP
    private String generateOTP()
    {
        return new DecimalFormat("000000").format(new Random().nextInt(999999));
    }
}
