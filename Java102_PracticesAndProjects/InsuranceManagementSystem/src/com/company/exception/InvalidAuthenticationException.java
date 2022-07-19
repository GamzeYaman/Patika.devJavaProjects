package com.company.exception;

public class InvalidAuthenticationException extends Exception{

    public InvalidAuthenticationException(String message){
        super(message);
    }
}
