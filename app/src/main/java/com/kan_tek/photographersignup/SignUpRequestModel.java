package com.kan_tek.photographersignup;

import java.io.File;

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

    private String firstName;
    private String lastName;
    private String emailId;
    private String ssn;
    private String password;
    private String phoneNumber;
    private String backgroundCheck;
    private String dateOfBirth;
    private File profileImage;
//    private String profileImage;
    private String deviceType;
    private String deviceToken;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBackgroundCheck() {
        return backgroundCheck;
    }

    public void setBackgroundCheck(String backgroundCheck) {
        this.backgroundCheck = backgroundCheck;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public File getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(File profileImage) {
        this.profileImage = profileImage;
    }

//    public String getProfileImage() {
//        return profileImage;
//    }
//
//    public void setProfileImage(String profileImage) {
//        this.profileImage = profileImage;
//    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
