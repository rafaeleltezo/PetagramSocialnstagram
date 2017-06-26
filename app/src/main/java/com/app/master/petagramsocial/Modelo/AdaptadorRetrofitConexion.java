package com.app.master.petagramsocial.Modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rafael p on 15/5/2017.
 */

public class AdaptadorRetrofitConexion {

    public Endpoint retrofit(Gson gson){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ConstantesConsultaMediaRecent.URLBASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(Endpoint.class);
    }
    public Gson construyeGsonDeserializador(){
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ContactoRespuesta.class,new DeserializadorInstagramMediaRecent());
        return gsonBuilder.create();
    }

    public  Endpoint establecerConexionToken(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ConstantesToken.URLBASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Endpoint.class);
    }

}
