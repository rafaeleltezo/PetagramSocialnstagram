package com.app.master.petagramsocial.Vista;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.master.petagramsocial.FotoActual;
import com.app.master.petagramsocial.Modelo.Contacto;
import com.app.master.petagramsocial.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Rafael p on 14/5/2017.
 */

public class AdaptadorFragmentoRecicler extends RecyclerView.Adapter<AdaptadorFragmentoRecicler.AdaptadorFragmentoReciclerHolder> {

    private ArrayList<Contacto>contactos;
    private Context context;
    private Activity actividad;

    public AdaptadorFragmentoRecicler(ArrayList<Contacto>contactos, Context context, Activity actividad){
        this.contactos=contactos;
        this.context=context;
        this.actividad=actividad;
    }
    @Override
    public AdaptadorFragmentoReciclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.carta,parent,false);
        return new AdaptadorFragmentoReciclerHolder(vista);
    }

    @Override
    public void onBindViewHolder(AdaptadorFragmentoReciclerHolder holder, int position) {
        final Contacto contacto=contactos.get(position);
        holder.like.setText(String.valueOf(contacto.getLike()));
        //Toast.makeText(context, contacto.getUrlPerfil(), Toast.LENGTH_SHORT).show();
        Picasso.with(context).
                load(contacto.getUrlPerfil()).
                placeholder(R.drawable.imagen).
                into(holder.imagenPerfil);
        holder.imagenPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento=new Intent(actividad, FotoActual.class);
                intento.putExtra("nombre",contacto.getNombre());
                intento.putExtra("urlFoto",contacto.getUrlPerfil());
                intento.putExtra("likes",contacto.getLike());
                actividad.startActivity(intento);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class AdaptadorFragmentoReciclerHolder extends RecyclerView.ViewHolder{
        ImageView imagenPerfil;
        TextView like;

        public AdaptadorFragmentoReciclerHolder(View itemView) {
            super(itemView);
            imagenPerfil=(ImageView)itemView.findViewById(R.id.perfilCarta);
            like=(TextView)itemView.findViewById(R.id.likeCarta);
        }
    }
}
