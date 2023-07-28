package com.example.randomrecipe;

import static androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.ViewModelInitializer;

import com.example.randomrecipe.model.Meals;
import com.example.randomrecipe.model.Recipe;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;

public class RecipeViewModel extends ViewModel {

    private RecipeApplication app;

    private MutableLiveData<Integer> loading;

    private MutableLiveData<String> nome;

    private MutableLiveData<String> strImageSource;

    private MutableLiveData<String> strInstructions;

    private MutableLiveData<String> strIngredient;

    private MutableLiveData<String> strMeasure;


    public static ViewModelInitializer<RecipeViewModel> initializer = new ViewModelInitializer<>(
            RecipeViewModel.class,
            creationExtras -> new RecipeViewModel((RecipeApplication) creationExtras.get(APPLICATION_KEY)));

    public RecipeViewModel(RecipeApplication app) {
        this.app = app;
        loading = new MutableLiveData<>(View.GONE);
        nome = new MutableLiveData<>();
        strImageSource = new MutableLiveData<>();
        strInstructions = new MutableLiveData<>();
        strIngredient = new MutableLiveData<>();
        strMeasure = new MutableLiveData<>();



    }

    public void loadRecipe() {
        loading.setValue(View.VISIBLE);
        app.getExecutor().execute(() -> {
            try {
                Meals m = app.getMealsRepo().randomRecipe();
                extratorRecipe(m);
            } catch (IOException | IllegalAccessException e){
                throw new RuntimeException(e);
            }
            finally {
                loading.postValue(View.GONE);
            }
        });
    }

    private void extratorRecipe(Meals m) throws IllegalAccessException {
        String ingredient = "";
        String measure = "";
        for (Recipe r : m.meals) {
            nome.postValue(r.strMeal);
            strImageSource.postValue(r.strImageSource);
            strInstructions.postValue(r.strInstructions);

            if (r.strIngredient1 != "") ingredient += r.strIngredient1+"\n";
            if (r.strIngredient2 != "") ingredient += r.strIngredient2+"\n";
            if (r.strIngredient3 != "") ingredient += r.strIngredient3+"\n";
            if (r.strIngredient4 != "") ingredient += r.strIngredient4+"\n";
            if (r.strIngredient5 != "") ingredient += r.strIngredient5+"\n";
            if (r.strIngredient6 != "") ingredient += r.strIngredient6+"\n";
            if (r.strIngredient7 != "") ingredient += r.strIngredient7+"\n";
            if (r.strIngredient8 != "") ingredient += r.strIngredient8+"\n";
            if (r.strIngredient9 != "") ingredient += r.strIngredient9+"\n";
            if (r.strIngredient10 != "") ingredient += r.strIngredient10+"\n";
            if (r.strIngredient11 != "") ingredient += r.strIngredient11+"\n";
            if (r.strIngredient12 != "") ingredient += r.strIngredient12+"\n";
            if (r.strIngredient13 != "") ingredient += r.strIngredient13+"\n";
            if (r.strIngredient14 != "") ingredient += r.strIngredient14+"\n";
            if (r.strIngredient15 != "") ingredient += r.strIngredient15+"\n";
            if (r.strIngredient16 != "") ingredient += r.strIngredient16+"\n";
            if (r.strIngredient17 != "") ingredient += r.strIngredient17+"\n";
            if (r.strIngredient18 != "") ingredient += r.strIngredient18+"\n";
            if (r.strIngredient19 != "") ingredient += r.strIngredient19+"\n";
            if (r.strIngredient20 != "") ingredient += r.strIngredient20+"\n";

            if (r.strMeasure1 != "") measure += r.strMeasure1 +"\n";
            if (r.strMeasure2 != "") measure += r.strMeasure2 +"\n";
            if (r.strMeasure3 != "") measure += r.strMeasure3 +"\n";
            if (r.strMeasure4 != "") measure += r.strMeasure4 +"\n";
            if (r.strMeasure5 != "") measure += r.strMeasure5 +"\n";
            if (r.strMeasure6 != "") measure += r.strMeasure6 +"\n";
            if (r.strMeasure7 != "") measure += r.strMeasure7 +"\n";
            if (r.strMeasure8 != "") measure += r.strMeasure8 +"\n";
            if (r.strMeasure9 != "") measure += r.strMeasure9 +"\n";
            if (r.strMeasure10 != "") measure += r.strMeasure10 +"\n";
            if (r.strMeasure11 != "") measure += r.strMeasure11 +"\n";
            if (r.strMeasure12 != "") measure += r.strMeasure12 +"\n";
            if (r.strMeasure13 != "") measure += r.strMeasure13 +"\n";
            if (r.strMeasure14 != "") measure += r.strMeasure14 +"\n";
            if (r.strMeasure15 != "") measure += r.strMeasure15 +"\n";
            if (r.strMeasure16 != "") measure += r.strMeasure16 +"\n";
            if (r.strMeasure17 != "") measure += r.strMeasure17 +"\n";
            if (r.strMeasure18 != "") measure += r.strMeasure18 +"\n";
            if (r.strMeasure19 != "") measure += r.strMeasure19 +"\n";
            if (r.strMeasure20 != "") measure += r.strMeasure20 +"\n";
        }
        strIngredient.postValue(ingredient.trim());
        strMeasure.postValue(measure.trim());

    }


    public LiveData<Integer> getLoading() {
        return loading;
    }

    public LiveData<String> getNome() {
        return nome;
    }

    public LiveData<String> getStrImageSource() {
        return strImageSource;
    }

    public LiveData<String> getStrInstructions() {
        return strInstructions;
    }

    public LiveData<String> getStrIngredient() {
        return strIngredient;
    }

    public LiveData<String> getStrMeasure() {
        return strMeasure;
    }

}
