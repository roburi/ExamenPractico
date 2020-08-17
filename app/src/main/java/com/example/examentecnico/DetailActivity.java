package com.example.examentecnico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.examentecnico.utility.HeroUtility;

public class DetailActivity extends AppCompatActivity {

    private TextView txtdetalleNombre, txtDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtdetalleNombre = findViewById(R.id.txtdetalleNombre);
        txtDetalle = findViewById(R.id.txtDetalle);

        txtdetalleNombre.setText(HeroUtility.listaHeroes.get(HeroUtility.position).getName());

        txtDetalle.setText(HeroUtility.listaHeroes.get(HeroUtility.position).getName()+", "+"" +"" +
                ""+HeroUtility.listaHeroes.get(HeroUtility.position).getBiography());
    }
}
