package com.looke.looke.service;

import android.content.Context;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.looke.looke.userinterface.common.DateDeserializer;


public class MobileServiceBuilder {

    public static String getUrlRest() {

        return "https://sampletestingproject-4a8fc.web.app/";
    }

    public static MobileService montarServico(Context pContexto)
    {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()

                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)

                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request.Builder newRequest = chain.request().newBuilder()
                                .addHeader("Content-Type", "application/json");

                        return chain.proceed(newRequest.build());
                    }
                });

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder.addInterceptor(interceptor);

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(getUrlRest())
                        .addConverterFactory(
                                GsonConverterFactory.create(gsonBuilder.create())
                        );

        Retrofit retrofit =
                builder
                        .client(
                                httpClientBuilder.build()
                        )
                        .build();

        return retrofit.create(MobileService.class);
    }
}
