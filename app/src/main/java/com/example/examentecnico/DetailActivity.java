package com.example.examentecnico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examentecnico.mdata.HeroId;
import com.example.examentecnico.mdata.Image;
import com.example.examentecnico.utility.Conexiones.HerosAccesos;
import com.example.examentecnico.utility.Conexiones.HerosApiConexion;
import com.example.examentecnico.utility.HeroUtility;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private TextView txtdetalleNombre, txtDetalle;
    private ImageView imageViewDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtdetalleNombre = findViewById(R.id.txtdetalleNombre);
        txtDetalle = findViewById(R.id.txtDetalle);
        imageViewDetalle = findViewById(R.id.imageViewDetalle);


        obtenerHero();


        //
//        txtdetalleNombre.setText(HeroUtility.listaHeroes.get(HeroUtility.position).getName());
//
//        txtDetalle.setText(HeroUtility.listaHeroes.get(HeroUtility.position).getName()+"\n" +
//                ""+HeroUtility.listaHeroes.get(HeroUtility.position).getBiography()+"\n" +
//                ""+HeroUtility.listaHeroes.get(HeroUtility.position).getAppearance());
//


    }

    private void obtenerHero() {
        HerosAccesos obtenerDatos = HerosApiConexion.getHeroInstance();
        Call<HeroId> llamar = obtenerDatos.goBuscarHero(HeroUtility.position);

        llamar.enqueue(new Callback<HeroId>() {
            @Override
            public void onResponse(Call<HeroId> call, Response<HeroId> response) {
                if (response.body() != null) {
                    Picasso.get().load(response.body().getImage().getUrl()).into(imageViewDetalle);
                } else {
                    Toast.makeText(getApplicationContext(), "Vacio", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<HeroId> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error al conectar", Toast.LENGTH_LONG).show();
            }
        });
    }
}
