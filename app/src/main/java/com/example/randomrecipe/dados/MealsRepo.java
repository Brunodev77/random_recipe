package com.example.randomrecipe.dados;

import android.util.Log;

import com.example.randomrecipe.model.Meals;
import com.example.randomrecipe.model.Recipeapi;

import java.io.IOException;

public class MealsRepo {
    private Recipeapi api;

    public MealsRepo(Recipeapi api) {
        this.api = api;
    }

    public Meals randomRecipe() throws IOException {
        Meals m = api.getRandomRecipe().execute().body();
        Log.d("Meals randomRecipe", "fim"+m);
        return m;
    }
}
