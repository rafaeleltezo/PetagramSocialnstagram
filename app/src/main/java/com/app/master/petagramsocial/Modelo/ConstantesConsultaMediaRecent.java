package com.app.master.petagramsocial.Modelo;

/**
 * Created by Rafael p on 14/5/2017.
 */

public class ConstantesConsultaMediaRecent {
    public final static String URL="https://api.instagram.com";
    public final static String VERSION="/v1/";
    public final static String URLBASE=URL+VERSION;
    public final static String CONSULTA="users/self/media/recent/?access_token=";
    public final static String TOKEN="1041594776.a671e79.260048636a4746c88b6382d53576aec1";
    public final static String URLCONSULTA=URLBASE+CONSULTA+TOKEN;
}
