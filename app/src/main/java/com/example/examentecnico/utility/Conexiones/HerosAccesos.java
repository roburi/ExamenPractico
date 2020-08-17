package com.example.examentecnico.utility.Conexiones;

import com.example.examentecnico.mdata.HeroId;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface HerosAccesos {


//    @GET("{id}")
//    Call<List<HeroId>> goBuscarHeroes(@Path("id") Integer id);


    @GET("{id}")
    Call<HeroId> goBuscarHero(@Path("id") Integer id);


}
