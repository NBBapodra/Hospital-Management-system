package com.example.TokenAuthentication.exception.Enum;



public enum HttpStatus1{

    CREATED(2001,"CREATED", "CREATED SUCCESSFULLY"),
    UPDATED(2002,"UPDATED","UPDATED SUCCESSFULLY"),
    DELETED(2003,"DELETED","DELETED SUCCESSFULLY"),
    OK(2004,"OK","OK");


    private final int code;
    private final String status;
    private final String description;

    HttpStatus1(int code,String status, String description) {
        this.code = code;
        this.status = status;
        this.description = description;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
