package com.example.login;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleItem extends AppCompatActivity {

    private Entidad Item;
    private TextView tvTitulo, tvDescripcion;
    private ImageView imgFoto;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detalle_item);

        Item = (Entidad) getIntent().getSerializableExtra("objetoData");
        tvTitulo = findViewById(R.id.tvTitulo2);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        imgFoto = findViewById(R.id.imgFoto);

        tvTitulo.setText(Item.getTitulo());
        imgFoto.setImageResource(Item.getImgFoto());
    }
}
