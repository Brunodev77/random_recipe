package com.example.randomrecipe;

import android.app.Application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThemeamApplication extends Application {

    private ExecutorService executorService = Executors.newFixedThreadPool(1);


}
