package com.example.examentecnico.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.examentecnico.R;

import androidx.recyclerview.widget.RecyclerView;

public class HeroHolder extends RecyclerView.ViewHolder {

    ImageView imagenitemlista;
    TextView nombreitemlista;

    public HeroHolder(View v) {
        super(v);
        imagenitemlista = v.findViewById(R.id.imagenitemlista);
        nombreitemlista = v.findViewById(R.id.nombreitemlista);


    }
}
