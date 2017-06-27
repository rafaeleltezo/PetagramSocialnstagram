package com.app.master.petagramsocial.Presentador;

import android.content.Context;
import android.widget.Toast;

import com.app.master.petagramsocial.Modelo.AdaptadorRetrofitConexion;
import com.app.master.petagramsocial.Modelo.Contacto;
import com.app.master.petagramsocial.Modelo.ContactoRespuesta;
import com.app.master.petagramsocial.Modelo.DeserializadorInstagramMediaRecent;
import com.app.master.petagramsocial.Modelo.Endpoint;
import com.app.master.petagramsocial.Vista.iFragmentReciclerView;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rafael p on 14/5/2017.
 */

public class PresentadorFragmentRecicler implements iPresentadorFramentRecicler {

    public iFragmentReciclerView iFragmentReciclerView;
    private ArrayList<Contacto>contactos;
    public Context context;

    public PresentadorFragmentRecicler(iFragmentReciclerView iFragmentReciclerView,Context context){
        this.iFragmentReciclerView=iFragmentReciclerView;
        this.context=context;
        obtenerMediosRecientes();
    }

    @Override
    public void establecerLayout() {
        iFragmentReciclerView.establecerGidLayoutManager(iFragmentReciclerView.crearGridLayoutManager());
    }

    @Override
    public void establecerAdaptador() {
        iFragmentReciclerView.establecerAdaptador(iFragmentReciclerView.crearAdaptador(contactos,context));
        for (Contacto c:contactos) {
            Toast.makeText(context, String.valueOf(c.getId()), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void obtenerMediosRecientes() {
        AdaptadorRetrofitConexion adaptador=new AdaptadorRetrofitConexion();
        Gson gson=adaptador.construyeGsonDeserializador();
        Endpoint endpoint=adaptador.retrofit(gson);
        Call<ContactoRespuesta>call=endpoint.getRecientes();
        call.enqueue(new Callback<ContactoRespuesta>() {
            @Override
            public void onResponse(Call<ContactoRespuesta> call, Response<ContactoRespuesta> response) {
                ContactoRespuesta contactoRespuesta=response.body();
                 contactos = contactoRespuesta.getContactos();
                establecerAdaptador();
            }

            @Override
            public void onFailure(Call<ContactoRespuesta> call, Throwable t) {
                Toast.makeText(context, "Error al conectar al servidor de Instagram", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
