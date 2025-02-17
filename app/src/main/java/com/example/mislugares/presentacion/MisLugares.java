package com.example.mislugares.presentacion;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mislugares.Aplicacion;
import com.example.mislugares.R;
import com.example.mislugares.casos_uso.CasosUsoActividades;
import com.example.mislugares.casos_uso.CasosUsoLugar;
import com.example.mislugares.datos.RepositorioLugares;

public class MisLugares extends AppCompatActivity {
    private RepositorioLugares lugares;
    private CasosUsoLugar usoLugar;

    private CasosUsoActividades usoActividades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mis_lugares);
        // Set content view using traditional method (no binding)

        // Set toolbar
        Toolbar toolbar = findViewById(R.id.toolbar); // Replace with your toolbar ID
        setSupportActionBar(toolbar);  // Esta línea ahora usará el método de AppCompatActivity

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button bSalir = findViewById(R.id.button04);
        bSalir.setOnClickListener(view -> finish());
        lugares = ((Aplicacion) getApplication()).lugares;
        usoLugar = new CasosUsoLugar(this, lugares);
        // 🔹 Inicializar `CasosUsoActividades`
        usoActividades = new CasosUsoActividades(this);
    }

    // 🔹 Método para inflar el menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mis_lugares, menu);
        return true;
    }

    // 🔹 Método para manejar eventos del menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_buscar) {
            lanzarVistaLugar(null);
            return true;
        }

        if (id == R.id.action_settings) {
            // Acción para Configuración (puedes agregar algo aquí)
            return true;
        }
        if (id == R.id.acercaDe) {
            lanzarAcercaDe();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    public void lanzarVistaLugar(View view) {
        usoLugar.mostrar(0);
    }

    public void lanzarAcercaDe() {
        usoActividades.lanzarAcercaDe();

    }

    public void salir(View view) {
        finish();
    }
}
