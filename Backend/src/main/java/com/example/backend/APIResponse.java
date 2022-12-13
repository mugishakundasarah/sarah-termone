package com.example.backend;

public class APIResponse {

    private boolean status;
    private double data;

    private String message;


    public APIResponse() {
        super();
    }
    public APIResponse(boolean status, String message, double data) {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

