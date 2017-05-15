package com.app.master.petagramsocial;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.master.petagramsocial.Modelo.Contacto;
import com.app.master.petagramsocial.Vista.AdaptadorFragmentoRecicler;
import com.app.master.petagramsocial.Vista.iFragmentReciclerView;
import com.app.master.petagramsocial.Presentador.PresentadorFragmentRecicler;
import java.util.ArrayList;

/**
 * Created by Rafael p on 14/5/2017.
 */

public class FragmentReciclerView extends Fragment implements iFragmentReciclerView {

    RecyclerView recyclerView;
    PresentadorFragmentRecicler presentador;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.recilerview,container,false);
        recyclerView=(RecyclerView)v.findViewById(R.id.recycler);
        presentador=new PresentadorFragmentRecicler(this,getContext());
        presentador.establecerLayout();
        presentador.establecerAdaptador();
        return v;
    }

    @Override
    public GridLayoutManager crearGridLayoutManager() {
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        return gridLayoutManager;
    }

    @Override
    public void establecerGidLayoutManager(GridLayoutManager layoutManager) {
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void establecerAdaptador(AdaptadorFragmentoRecicler adaptador) {
        recyclerView.setAdapter(adaptador);
    }

    @Override
    public AdaptadorFragmentoRecicler crearAdaptador(ArrayList<Contacto>contactos, Context context) {
        AdaptadorFragmentoRecicler adaptador=new AdaptadorFragmentoRecicler(contactos,context);
        return adaptador;
    }
}
