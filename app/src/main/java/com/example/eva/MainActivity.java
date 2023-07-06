package com.example.eva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eva.adaptador.Adaptadorrevista;
import com.example.eva.clases.Revista;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Webservice.Asynchtask;
import Webservice.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lstrevista = (ListView)findViewById(R.id.ochy2);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, this,  MainActivity.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        ListView lstOpciones = (ListView)findViewById(R.id.ochy2);
        JSONObject JSONlista = new JSONObject(result);
        ArrayList<Revista> revistas;
        JSONArray JSONlistarevista= JSONlista.getJSONArray(" ");
        revistas = Revista.JsonObjectsBuild(JSONlistarevista);
        Adaptadorrevista adapatorRevista = new Adaptadorrevista(this,revistas );
        lstOpciones.setAdapter(adapatorRevista);
    }
}