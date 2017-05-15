package com.app.master.petagramsocial.Modelo;

/**
 * Created by Rafael p on 14/5/2017.
 */

public class Contacto {
    int id,like;
    String nombre,urlPerfil;

    public Contacto(int id, int like, String nombre, String urlPerfil) {
        this.id = id;
        this.like = like;
        this.nombre = nombre;
        this.urlPerfil = urlPerfil;
    }

    public Contacto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlPerfil() {
        return urlPerfil;
    }

    public void setUrlPerfil(String urlPerfil) {
        this.urlPerfil = urlPerfil;
    }
}
