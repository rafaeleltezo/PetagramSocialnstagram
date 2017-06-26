package com.app.master.petagramsocial.Presentador;

import android.content.Intent;
import android.widget.Toast;

import com.app.master.petagramsocial.MainActivity;
import com.app.master.petagramsocial.Modelo.AdaptadorRetrofitConexion;
import com.app.master.petagramsocial.Modelo.Endpoint;
import com.app.master.petagramsocial.Modelo.RespuestaUsuario;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rafael p on 25/6/2017.
 */

public class enviarToken extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        registarToken(refreshedToken);
    }

    private void registarToken(String token){
        AdaptadorRetrofitConexion conexion=new AdaptadorRetrofitConexion();
        Endpoint endpoint=conexion.establecerConexionToken();
        Call<RespuestaUsuario>respuesta=endpoint.getToken(token);
        Intent i=new Intent(this, MainActivity.class);
        i.putExtra("token",token);
        startActivity(i);
        respuesta.enqueue(new Callback<RespuestaUsuario>() {
            @Override
            public void onResponse(Call<RespuestaUsuario> call, Response<RespuestaUsuario> response) {
                String token=response.body().getToken();
                Toast.makeText(enviarToken.this,"token= "+token, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RespuestaUsuario> call, Throwable t) {
                Toast.makeText(enviarToken.this, "Error al enviar token", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
