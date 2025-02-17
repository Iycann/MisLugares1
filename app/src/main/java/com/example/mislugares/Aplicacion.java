package com.example.mislugares;

import android.app.Application;

import com.example.mislugares.datos.LugaresLista;
import com.example.mislugares.datos.RepositorioLugares;

public class Aplicacion extends Application {
    public RepositorioLugares lugares = new LugaresLista();

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
