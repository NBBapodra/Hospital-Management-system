package com.example.TokenAuthentication;

import com.example.TokenAuthentication.config.TwilioConfig;
import com.twilio.Twilio;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Hospital Management API", version = "2.0", description = "Hospital Management Information"))

public class SpringBootSecurityJwtApplication {

	@Autowired
	private TwilioConfig twilioConfig;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@PostConstruct
	public void initTwilio(){
		Twilio.init(twilioConfig.getAccountSid(),twilioConfig.getAuthToken());
	}


	public static void main(String[] args) {
    SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}

}
