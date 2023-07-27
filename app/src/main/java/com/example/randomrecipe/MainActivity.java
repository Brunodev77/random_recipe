package com.example.randomrecipe;

import static androidx.lifecycle.ViewModelProvider.Factory.from;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.randomrecipe.databinding.ActivityMainBinding;
import com.example.randomrecipe.databinding.ActivityRecipeDetailsBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

    public void onClickRandomSearch(View view){
        Intent intent = new Intent(this, RecipeDetailsActivity.class);
        startActivity(intent);
    }
}