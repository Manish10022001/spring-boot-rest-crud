package com.restapi.demo.rest;
//  custome exception class
public class StudentNotFoundException extends RuntimeException{
    //call super constructor i.e using inheritanc

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
