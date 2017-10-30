package com.kan_tek.photographersignup;

/**
 * Created by WIKI on 29/10/2017.
 */
import java.io.File;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Body;
import retrofit2.http.Part;

public interface SignUpApi {
    @Multipart
    @POST("v1/serviceProvider/register")
    Call<SignUpResponseModel> signUpAccount(@Part("firstName") RequestBody firstName,
                                            @Part("lastName") RequestBody lastName,
                                            @Part("phoneNumber") RequestBody phoneNumber,
                                            @Part("emailId") RequestBody emailId,
                                            @Part("dateOfBirth") RequestBody dateOfBirth,
                                            @Part("ssn") RequestBody ssn,
                                            @Part("password") RequestBody password,
                                            @Part("backgroundCheck") RequestBody backgroundCheck,
                                            @Part("deviceToken") RequestBody deviceToken,
                                            @Part("deviceType") RequestBody deviceType,
                                            @Part MultipartBody.Part profileImage);
}
