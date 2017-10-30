package com.kan_tek.photographersignup;

import java.io.File;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by WIKI on 29/10/2017.
 */

public class SignUpRequestModel {

    /**
     * firstName : string
     * lastName : string
     * emailId : test0001@gmail.com
     * ssn : 4444
     * password : string
     * phoneNumber : 0123456789
     * backgroundCheck : YES
     * dateOfBirth : 1990-01-20
     * profileImage : file
     * deviceType : ANDROID
     * deviceToken : 1
     */

    private RequestBody firstName;
    private RequestBody lastName;
    private RequestBody emailId;
    private RequestBody ssn;
    private RequestBody password;
    private RequestBody phoneNumber;
    private RequestBody backgroundCheck;
    private RequestBody dateOfBirth;
    private MultipartBody.Part profileImage;
//    private String profileImage;
    private RequestBody deviceType;
    private RequestBody deviceToken;

    public RequestBody getFirstName() {
        return firstName;
    }

    public void setFirstName(RequestBody firstName) {
        this.firstName = firstName;
    }

    public RequestBody getLastName() {
        return lastName;
    }

    public void setLastName(RequestBody lastName) {
        this.lastName = lastName;
    }

    public RequestBody getEmailId() {
        return emailId;
    }

    public void setEmailId(RequestBody emailId) {
        this.emailId = emailId;
    }

    public RequestBody getSsn() {
        return ssn;
    }

    public void setSsn(RequestBody ssn) {
        this.ssn = ssn;
    }

    public RequestBody getPassword() {
        return password;
    }

    public void setPassword(RequestBody password) {
        this.password = password;
    }

    public RequestBody getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(RequestBody phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public RequestBody getBackgroundCheck() {
        return backgroundCheck;
    }

    public void setBackgroundCheck(RequestBody backgroundCheck) {
        this.backgroundCheck = backgroundCheck;
    }

    public RequestBody getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(RequestBody dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public MultipartBody.Part getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(MultipartBody.Part profileImage) {
        this.profileImage = profileImage;
    }

//    public String getProfileImage() {
//        return profileImage;
//    }
//
//    public void setProfileImage(String profileImage) {
//        this.profileImage = profileImage;
//    }

    public RequestBody getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(RequestBody deviceType) {
        this.deviceType = deviceType;
    }

    public RequestBody getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(RequestBody deviceToken) {
        this.deviceToken = deviceToken;
    }
}
