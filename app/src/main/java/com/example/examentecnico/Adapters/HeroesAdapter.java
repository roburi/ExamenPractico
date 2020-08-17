package com.example.examentecnico.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examentecnico.DetailActivity;
import com.example.examentecnico.MainActivity;
import com.example.examentecnico.R;
import com.example.examentecnico.mdata.HeroId;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HeroesAdapter extends RecyclerView.Adapter<HeroHolder> {

    private ArrayList<HeroId> list ;
    private Context context;
    private int HeroesVisibles = 10;
    private int ultimoVisible, totalHeroes;


    public HeroesAdapter(RecyclerView recyclerLista, ArrayList<HeroId> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @Override
    public HeroHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View vis = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);

        return new HeroHolder(vis);

    }

    public void onBindViewHolder(HeroHolder holder, int position) {
        HeroId h = list.get(position);

        holder.nombreitemlista.setText(h.getName());
        Picasso.Builder builderF = new Picasso.Builder(context);

        String urll;
//        urll = h.getImage().getUrl().replaceAll("/","\\");
//        holder.imagenitemlista.setBackgroundResource(R.drawable.ic_launcher_background);

        Picasso.get().load(h.getImage().getUrl()).into(holder.imagenitemlista);

//        builderF.downloader(new OkHttp3Downloader(context));
//        builderF.build().load(h.getImage().getUrl()).placeholder(R.drawable.ic_launcher_background).error(R.mipmap.ic_launcher).centerCrop().into(holder.imagenitemlista);

        holder.nombreitemlista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                context.startActivity(intent);
            }
        });
    }
    
    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void insert(int position, HeroId data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    public void remove(HeroId data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }
}
