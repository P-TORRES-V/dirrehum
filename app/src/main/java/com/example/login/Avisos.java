package com.example.login;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Avisos extends AppCompatActivity {
    private ListView lvItems;
    private Adapter adaptador;
    private ArrayList<Entidad>arrayentidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avisos);

        lvItems = (ListView)findViewById(R.id.lvItems);
        arrayentidad = GetArrayItems();
        adaptador =(Adapter) new Adaptador(this, arrayentidad);
        lvItems.setAdapter((ListAdapter)adaptador) ;

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Avisos.this, DetalleItem.class);
                i.putExtra("objetoData", arrayentidad.get(position));
                startActivity(i);


            }
        });

    }
    private ArrayList<Entidad> GetArrayItems(){
        ArrayList<Entidad>listItems = new ArrayList<Entidad>();
        listItems.add(new Entidad(R.drawable.pol, "RCG N° 004-2021-CG PNP", "personal DIRIN"));
        listItems.add(new Entidad(R.drawable.hilux, "DIVECO PNP", "Personal PNP"));
        listItems.add(new Entidad(R.drawable.hiluxx, "DOCENCIA", "Docente para Promocion 2019 II"));
        listItems.add(new Entidad(R.drawable.hiluxxx, "DIRREHUM PNP", "Comunicado para personal que asciende"));
        listItems.add(new Entidad(R.drawable.hyu, " PNP", "Aniversario de la PNP"));

        return listItems;


    }
}