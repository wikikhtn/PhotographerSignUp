package com.kan_tek.photographersignup;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.InetAddress;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by WIKI on 29/10/2017.
 */

public abstract class SmartCallBack<T> implements Callback<T> {
    public abstract Context getCurrentContext();

    public abstract void onSuccess(T response);

    public abstract void onError();

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.code() == HttpURLConnection.HTTP_CREATED) {
            if (getCurrentContext() != null) {
                onSuccess(response.body());
            }
        } else if (response.code() == HttpURLConnection.HTTP_BAD_REQUEST) {
            onError();
            Log.d("----API Error----", "" + response.code());
            if (getCurrentContext() != null)
                Toast.makeText(getCurrentContext(), getCurrentContext().getString(R.string.error400), Toast.LENGTH_LONG).show();
        } else if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
            onError();
            if (getCurrentContext() != null)
                Toast.makeText(getCurrentContext(), getCurrentContext().getString(R.string.error401), Toast.LENGTH_LONG).show();
            Log.d("----API Error----", "" + response.code());
        } else if (response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
            onError();
            Log.d("----API Error----", "" + response.code());
            if (getCurrentContext() != null)
                Toast.makeText(getCurrentContext(), getCurrentContext().getString(R.string.error404), Toast.LENGTH_LONG).show();
        } else if (response.code() == HttpURLConnection.HTTP_CONFLICT) {
            onError();
            Log.d("----API Error----", "" + response.code());
            if (getCurrentContext() != null)
                Toast.makeText(getCurrentContext(), getCurrentContext().getString(R.string.error409), Toast.LENGTH_LONG).show();
        } else if (response.code() == HttpURLConnection.HTTP_UNSUPPORTED_TYPE) {
            onError();
            Log.d("----API Error----", "" + response.code());
            if (getCurrentContext() != null)
                Toast.makeText(getCurrentContext(), getCurrentContext().getString(R.string.error415), Toast.LENGTH_LONG).show();
        } else if (response.code() == HttpURLConnection.HTTP_INTERNAL_ERROR) {
            onError();
            Log.d("----API Error----", "" + response.code());
            if (getCurrentContext() != null)
                Toast.makeText(getCurrentContext(), getCurrentContext().getString(R.string.error500), Toast.LENGTH_LONG).show();
        } else {
            onError();
            Log.d("----API Error----", "" + response.code());
            if (getCurrentContext() != null)
                Toast.makeText(getCurrentContext(), "Error code: " + response.code(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        boolean isNetworkConnected = isNetworkConnected(getCurrentContext());
        boolean isInternetAvailable = isInternetAvailable();
        if (isNetworkConnected == false || isInternetAvailable == false) {
            Toast.makeText(getCurrentContext(), getCurrentContext().getString(R.string.no_internet), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getCurrentContext(), "Error" + t.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    //Check state wifi
    private boolean isNetworkConnected(Context activity) {
        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        return networkInfo != null; //=true if has internet
    }

    //Check internet connect
    public boolean isInternetAvailable() {
        try {
            InetAddress ipAdd = InetAddress.getByName("google.com.vn");
            return ipAdd.equals(""); //=true if has internet

        } catch (Exception e) {
            return false;
        }
    }
}
