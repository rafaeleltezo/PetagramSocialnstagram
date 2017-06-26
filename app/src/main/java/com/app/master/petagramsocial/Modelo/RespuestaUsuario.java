package com.app.master.petagramsocial.Modelo;

/**
 * Created by Rafael p on 25/6/2017.
 */

public class RespuestaUsuario {
    private String token,id;

    public RespuestaUsuario(String token, String id) {
        this.token = token;
        this.id = id;
    }

    public RespuestaUsuario() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
