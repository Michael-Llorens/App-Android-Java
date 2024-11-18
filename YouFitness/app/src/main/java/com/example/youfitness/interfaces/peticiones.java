package com.example.youfitness.interfaces;

import com.example.youfitness.modelo.Pokedex;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface peticiones {
    @GET("pokemon/{id}")
    Call <Pokedex> consultar(@Path("id") String id);
}
