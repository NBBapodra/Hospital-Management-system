package com.example.TokenAuthentication.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PrescriptionNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    public PrescriptionNotFoundException(String prescription, Long id)
    {
        super();
    }

    public PrescriptionNotFoundException(String message)
    {
        super(message);
    }

}
