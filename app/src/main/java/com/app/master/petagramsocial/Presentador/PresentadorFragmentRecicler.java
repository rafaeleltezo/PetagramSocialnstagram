package com.app.master.petagramsocial.Presentador;

import android.content.Context;

import com.app.master.petagramsocial.Modelo.Contacto;
import com.app.master.petagramsocial.Vista.iFragmentReciclerView;

import java.util.ArrayList;

/**
 * Created by Rafael p on 14/5/2017.
 */

public class PresentadorFragmentRecicler implements iPresentadorFramentRecicler {

    public iFragmentReciclerView iFragmentReciclerView;
    public Context context;

    public PresentadorFragmentRecicler(iFragmentReciclerView iFragmentReciclerView,Context context){
        this.iFragmentReciclerView=iFragmentReciclerView;
        this.context=context;
    }

    @Override
    public void establecerLayout() {
        iFragmentReciclerView.establecerGidLayoutManager(iFragmentReciclerView.crearGridLayoutManager());
    }

    @Override
    public void establecerAdaptador() {
        iFragmentReciclerView.establecerAdaptador(iFragmentReciclerView.crearAdaptador(contactos(),context));
    }

    public ArrayList<Contacto> contactos(){
        ArrayList<Contacto> contactos=new ArrayList();
        contactos.add(new Contacto(1221,2,"rafael","www.wwewewe.we"));
        return contactos;
    }
}
