package com.app.master.petagramsocial.Modelo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Rafael p on 14/5/2017.
 */

public interface Endpoint {

    @GET(ConstantesConsultaMediaRecent.URLCONSULTA)
    public Call<ContactoRespuesta> getRecientes();

    @FormUrlEncoded
    @POST(ConstantesToken.URL)
    public Call<RespuestaUsuario>getToken(@Field("token")String token);
}
