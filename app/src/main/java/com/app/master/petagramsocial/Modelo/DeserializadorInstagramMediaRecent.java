package com.app.master.petagramsocial.Modelo;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Rafael p on 15/5/2017.
 */

public class DeserializadorInstagramMediaRecent implements JsonDeserializer<ContactoRespuesta> {
    @Override
    public ContactoRespuesta deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        ContactoRespuesta contactoRespuesta = gson.fromJson(json, ContactoRespuesta.class);
        JsonArray jsonArrayData = json.getAsJsonObject().getAsJsonArray(ConstantesJsonGetRecentMedia.DATA_OBJECT);
        contactoRespuesta.setContactos(deserializadorContacto(jsonArrayData));
        return contactoRespuesta;
    }

    public ArrayList<Contacto> deserializadorContacto(JsonArray jsonArray) {
        ArrayList<Contacto> contactos = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            Contacto contacto = new Contacto();
            JsonObject jsonObjeto = jsonArray.get(i).getAsJsonObject();

            JsonObject jsonUser = jsonObjeto.getAsJsonObject(ConstantesJsonGetRecentMedia.USUARIO_OBJECT);
            contacto.setNombre(jsonUser.get(ConstantesJsonGetRecentMedia.NOMBRE).getAsString());
            contacto.setId(jsonUser.get(ConstantesJsonGetRecentMedia.ID).getAsInt());


            JsonObject jsonLike = jsonObjeto.getAsJsonObject(ConstantesJsonGetRecentMedia.LIKE_OBJECT);
            contacto.setLike(jsonLike.get(ConstantesJsonGetRecentMedia.LIKE).getAsInt());

            JsonObject jsonFoto=jsonObjeto.getAsJsonObject(ConstantesJsonGetRecentMedia.IMAGEN_OBJECT)
                    .getAsJsonObject(ConstantesJsonGetRecentMedia.IMAGEN_RESOLUCION_OBJECT);
            contacto.setUrlPerfil(jsonFoto.get(ConstantesJsonGetRecentMedia.URL_IMAGEN).getAsString());

            contactos.add(contacto);
        }
        return contactos;
    }
}
