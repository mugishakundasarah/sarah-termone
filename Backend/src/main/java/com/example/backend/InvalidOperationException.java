package com.example.backend;

public class InvalidOperationException extends Exception{
    public InvalidOperationException(String message){
        super(message);
    }
}
