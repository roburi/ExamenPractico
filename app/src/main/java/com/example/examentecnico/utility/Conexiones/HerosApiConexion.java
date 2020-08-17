package com.example.examentecnico.utility.Conexiones;

import com.example.examentecnico.utility.Conexiones.HerosAccesos;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HerosApiConexion {
    private static HerosAccesos herosAccesos;
    private static String API_URL = "https://superheroapi.com/api.php//10156112965520834/";

    public HerosApiConexion() {}

    private static Retrofit crearServicioB(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .readTimeout(200, TimeUnit.SECONDS)
                .connectTimeout(200, TimeUnit.SECONDS);

        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        return retrofit;
    }

    public static HerosAccesos getHeroInstance(){
        if (herosAccesos == null){
            herosAccesos = crearServicioB().create(HerosAccesos.class);
        }
        return herosAccesos;
    }
}
