package com.example.randomrecipe;

import android.app.Application;
import android.util.Log;

import com.example.randomrecipe.dados.MealsRepo;
import com.example.randomrecipe.model.Recipeapi;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeApplication extends Application {

    private ExecutorService executorService = Executors.newFixedThreadPool(1);

    private Recipeapi recipeapi;

    private MealsRepo mrepo;

    public Recipeapi getApi() {
        if (this.recipeapi != null) return this.recipeapi;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        recipeapi = retrofit.create(Recipeapi.class);

        return recipeapi;
    }

    public Executor getExecutor() {
        return executorService;
    }

    public MealsRepo getMealsRepo() {
        if (mrepo != null) return mrepo;
        Log.d("MealsRepo","MealsRepo");
        mrepo = new MealsRepo(getApi());
        return mrepo;
    }

}
