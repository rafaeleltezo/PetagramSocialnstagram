package com.app.master.petagramsocial.Modelo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rafael p on 15/5/2017.
 */

public class AdaptadorRetrofitConexion {

    public Endpoint retrofit(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ConstantesConsultaMediaRecent.URLBASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Endpoint.class);
    }
}
