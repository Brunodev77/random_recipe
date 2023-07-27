package com.example.randomrecipe;

import static androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.ViewModelInitializer;

import com.example.randomrecipe.model.Meals;
import com.example.randomrecipe.model.Recipe;

import java.io.IOException;

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
            } catch (IOException e){
                throw new RuntimeException(e);
            }
            finally {
                loading.postValue(View.GONE);
            }
        });
    }

    private String extratorRecipe(Meals m) {
        String recipe = "";
        for (Recipe r : m.meals) {
            nome.postValue(r.strMeal);
            strImageSource.postValue(r.strImageSource);
            strInstructions.postValue(r.strInstructions);
        }
        return recipe;
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
