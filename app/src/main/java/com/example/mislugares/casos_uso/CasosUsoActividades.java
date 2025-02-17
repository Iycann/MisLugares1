package com.example.mislugares.casos_uso;

import android.content.Context;
import android.content.Intent;
import com.example.mislugares.AcercaDeActivity;

public class CasosUsoActividades {
    private Context contexto;

    public CasosUsoActividades(Context contexto) {
        this.contexto = contexto;
    }

    // 🔹 Método para lanzar la actividad "Acerca de"
    public void lanzarAcercaDe() {
        Intent intent = new Intent(contexto, AcercaDeActivity.class);
        contexto.startActivity(intent);
    }

}
