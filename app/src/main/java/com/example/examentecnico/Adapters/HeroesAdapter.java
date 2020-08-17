package com.example.examentecnico.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerLista.getLayoutManager();
        recyclerLista.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                totalHeroes = linearLayoutManager.getItemCount();
                ultimoVisible = linearLayoutManager.findLastVisibleItemPosition();

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

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

        builderF.downloader(new OkHttp3Downloader(context));
        builderF.build().load(h.getImage().getUrl()).placeholder(R.drawable.ic_launcher_background).error(R.mipmap.ic_launcher).centerCrop().into(holder.imagenitemlista);
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
