package com.kan_tek.photographersignup;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by WIKI on 29/10/2017.
 */

public class SignUpApiHandler {
    public static final String BASE_URL = "http://52.89.66.217:8181/api/";

    public static void signUpAccount(Context context, SignUpRequestModel rqt,
                                  SmartCallBack<SignUpResponseModel> callback) {
        Retrofit retrofit = buildRetrofit(context);
        SignUpApi signUpApi = retrofit.create(SignUpApi.class);
        Call<SignUpResponseModel> call = signUpApi.signUpAccount(rqt.getFirstName(), rqt.getLastName(),
                rqt.getPhoneNumber(), rqt.getEmailId(), rqt.getDateOfBirth(), rqt.getSsn(), rqt.getPassword(),
                rqt.getBackgroundCheck(),rqt.getDeviceToken(), rqt.getDeviceType(), rqt.getProfileImage());
        call.enqueue(callback);
    }

    public static Retrofit buildRetrofit(Context context) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
                                Request original = chain.request();
                                Request.Builder requestBuilder = original.newBuilder()
                                        .method(original.method(), original.body());
                                Request request = requestBuilder.build();
                                return chain.proceed(request);
                            }
                        })
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}


