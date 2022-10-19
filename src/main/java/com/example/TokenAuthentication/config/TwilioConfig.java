package com.example.TokenAuthentication.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@Data
public class TwilioConfig {

    private String accountSid="ACf8b2c9e4828a70dabd927528bcb50dd1";
    private String authToken="18eecd51515562969f60272bee12254f";
    private String trialNumber="+16305281517";

}
