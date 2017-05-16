package com.app.master.petagramsocial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FotoActual extends AppCompatActivity {

    ImageView perfil;
    TextView like,nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto_actual);
        Bundle bundle= getIntent().getExtras();
        perfil  =(ImageView) findViewById(R.id.perfil);
        like    =(TextView) findViewById(R.id.like);
        nombre  =(TextView) findViewById(R.id.nombre);


        like.setText(String.valueOf(bundle.getInt("like")));
        nombre.setText(bundle.getString("nombre"));
        Picasso.with(this).
                load(bundle.getString("urlFoto")).
                placeholder(R.drawable.imagen).
                into(perfil);

    }
}
