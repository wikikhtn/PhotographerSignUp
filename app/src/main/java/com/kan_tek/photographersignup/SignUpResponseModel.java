package com.kan_tek.photographersignup;

import java.util.List;

/**
 * Created by WIKI on 29/10/2017.
 */

public class SignUpResponseModel {

    /**
     * statusCode : 201
     * message : You are Registered successfully.
     */

    private Integer statusCode;
    private String message;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}