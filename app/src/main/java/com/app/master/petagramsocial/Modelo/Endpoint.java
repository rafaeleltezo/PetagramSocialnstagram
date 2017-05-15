package com.app.master.petagramsocial.Modelo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Rafael p on 14/5/2017.
 */

public interface Endpoint {

    @GET(ConstantesConsultaMediaRecent.URLCONSULTA)
    public Call<ContactoRespuesta> getRecientes();
}
