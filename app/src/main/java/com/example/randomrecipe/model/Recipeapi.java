package com.example.randomrecipe.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Recipeapi {

    @GET("random.php")
    Call<Meals> getRandomRecipe();

}
