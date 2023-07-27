package com.example.randomrecipe;

import static androidx.lifecycle.ViewModelProvider.Factory.from;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.randomrecipe.databinding.ActivityRecipeDetailsBinding;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class RecipeDetailsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityRecipeDetailsBinding binding = ActivityRecipeDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecipeViewModel vm = new ViewModelProvider(this, from(RecipeViewModel.initializer)).get(RecipeViewModel.class);

        vm.getLoading().observe(this, (newV) -> binding.progressBar.setVisibility(newV));
        vm.getNome().observe(this, (newV) -> binding.name.setText(newV));
        vm.getStrImageSource().observe(this, (newV) -> Picasso.get().load(newV).into(binding.imageView));
        vm.getStrInstructions().observe(this, (newV) -> binding.instructions.setText(newV));
        vm.getStrIngredient().observe(this,(newV) -> binding.ingredient.setText(newV));
        vm.getStrMeasure().observe(this, (newV) -> binding.measure.setText(newV));



        vm.loadRecipe();

        /*
        try {
            Log.d("inciotryactiv","inicioatcivity");
            vm.loadRecipe();
        } catch (IOException e) {
            Log.d("inciocath","inicioatcivity");
            throw new RuntimeException(e);
        }

         */
    }
}