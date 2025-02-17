package com.example.mislugares.casos_uso;

import android.app.Activity;
import android.content.Intent;

import com.example.mislugares.databinding.VistaLugarBinding;
import com.example.mislugares.datos.RepositorioLugares;

public class CasosUsoLugar {
    private Activity actividad;
    private RepositorioLugares lugares;
    public CasosUsoLugar(Activity actividad, RepositorioLugares lugares) {
        this.actividad = actividad;
        this.lugares = lugares;
    }
    public void mostrar(int pos) {
        Intent i = new Intent(actividad, com.example.mislugares.databinding.VistaLugarBinding.class);
        i.putExtra("pos", pos);
        actividad.startActivity(i);
    }
}


