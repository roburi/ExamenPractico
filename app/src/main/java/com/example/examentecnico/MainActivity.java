package com.example.examentecnico;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examentecnico.Adapters.HeroesAdapter;
import com.example.examentecnico.mdata.HeroId;
import com.example.examentecnico.utility.Conexiones.HerosAccesos;
import com.example.examentecnico.utility.Conexiones.HerosApiConexion;
import com.example.examentecnico.utility.HeroUtility;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppCompatEditText editTxtbuscar;
    private TextView txtPrueba;
    private RecyclerView recyclerLista;
    private HeroesAdapter adapter;
    private ProgressDialog progressDialog;
    private  int x;
    private ArrayList<HeroId> listaHeroes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAll();
        listaHeroes = new ArrayList<>();
        x = 1;
        do {

            obtenerTodos();
            x +=x;
        }while (x == 11);

        Toast.makeText(getApplicationContext(), String.valueOf(listaHeroes.size()), Toast.LENGTH_LONG).show();

        adapter = new HeroesAdapter(recyclerLista, listaHeroes, getApplicationContext());
        recyclerLista.setAdapter(adapter);
        recyclerLista.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerLista.setLayoutManager(gridLayoutManager);

//        progressDialog.dismiss();
    }

    private void initAll() {
        editTxtbuscar = findViewById(R.id.editTxtbuscar);
        recyclerLista = findViewById(R.id.recyclerLista);

//        progressDialog = new ProgressDialog(MainActivity.this);
//        progressDialog.setMessage("Cargando heroe");
//        progressDialog.show();

    }

    private void obtenerTodos() {

            HerosAccesos obtenerDatos = HerosApiConexion.getHeroInstance();
            Call<HeroId> llamar = obtenerDatos.goBuscarHero(x);

            llamar.enqueue(new Callback<HeroId>() {
                @Override
                public void onResponse(Call<HeroId> call, Response<HeroId> response) {
                    if (response.body() != null) {
                        listaHeroes.add(response.body());
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