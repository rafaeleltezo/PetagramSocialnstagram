package com.app.master.petagramsocial.Vista;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

import com.app.master.petagramsocial.Modelo.Contacto;

import java.util.ArrayList;


/**
 * Created by Rafael p on 14/5/2017.
 */

public interface iFragmentReciclerView {
    public GridLayoutManager crearGridLayoutManager();
    public void establecerGidLayoutManager(GridLayoutManager layoutManager);
    public void establecerAdaptador(AdaptadorFragmentoRecicler adaptador);
    public AdaptadorFragmentoRecicler crearAdaptador(ArrayList<Contacto> contactos, Context context);
}
