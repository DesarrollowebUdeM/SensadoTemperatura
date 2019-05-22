package com.example.coldorhot_2.io;

import com.example.coldorhot_2.Model.Login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("temperature/actualtemperature")
        //Call<ArrayList<temperatura>> getTemperaturas();
    Call<Float> getTemperaturas(); //La respuesta será una temperatura

    @POST("register/newregister")
    Call<String> savePost(@Body String temp);
    //@FormUrlEncoded
    //Call<Login> savePost(@Field("nombre") String nombre,
    //@Field("propietario") String propietario,
    //@Field("id") String id);

}