package com.kan_tek.photographersignup;

/**
 * Created by WIKI on 29/10/2017.
 */
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Body;

public interface SignUpApi {
    @POST("v1/serviceProvider/register")
    Call<SignUpResponseModel> signUpAccount(@Body SignUpRequestModel userRegister);
}
