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
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAll();
        HeroUtility.listaHeroes = new ArrayList<>();


        HiloD a = new HiloD();
        a.onPostExecute(true);



        Toast.makeText(getApplicationContext(), String.valueOf(HeroUtility.listaHeroes.size()), Toast.LENGTH_LONG).show();

        adapter = new HeroesAdapter(recyclerLista, HeroUtility.listaHeroes, MainActivity.this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerLista.setLayoutManager(gridLayoutManager);
        recyclerLista.setAdapter(adapter);
        recyclerLista.setHasFixedSize(true);

        recyclerLista.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

                View child = rv.findChildViewUnder(e.getX(), e.getY());

                    int position = rv.getChildAdapterPosition(child);

                    HeroUtility.position = position;

                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });



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
            Call<HeroId> llamar = obtenerDatos.goBuscarHero(HeroUtility.x);

            llamar.enqueue(new Callback<HeroId>() {
                @Override
                public void onResponse(Call<HeroId> call, Response<HeroId> response) {
                    if (response.body() != null) {

                        HeroUtility.listaHeroes.add(response.body());
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

    private class HiloD extends AsyncTask<Void, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {



            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onPostExecute(Boolean result) {
            if(result)

                HeroUtility.x = 1;

                for(int i=1; i<=20; i++) {
                    try {
                        obtenerTodos();
                        HeroUtility.x = HeroUtility.x + 1;
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }

        @Override
        protected void onCancelled() {
            Toast.makeText(MainActivity.this, "Tarea cancelada!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}