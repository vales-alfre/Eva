package com.example.eva.clases;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista {
    private String Revista;
private String aver;
private String urlima;
private String iden;

    public String getRevista() {
        return Revista;
    }

    public void setRevista(String revista) {
        Revista = revista;
    }

    public String getAver() {
        return aver;
    }

    public void setAver(String aver) {
        this.aver = aver;
    }

    public String getUrlima() {
        return urlima;
    }

    public void setUrlima(String urlima) {
        this.urlima = urlima;
    }

    public String getIden() {
        return iden;
    }

    public void setIden(String iden) {
        this.iden = iden;
    }

    public Revista(JSONObject a) throws JSONException {
        Revista =a.getString("name").toString();
        aver = a.getString("abbreviation").toString() ;
        urlima = a.getString("portada").toString() ;
        iden = a.getString("journal_id").toString() ;
    }
    public static ArrayList<Revista> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Revista> revistas = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            revistas.add(new Revista(datos.getJSONObject(i)));
        }
      return revistas;
    }
}
