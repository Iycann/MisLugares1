package com.example.mislugares.presentacion;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mislugares.Aplicacion;
import com.example.mislugares.R;
import com.example.mislugares.casos_uso.CasosUsoLugar;
import com.example.mislugares.datos.RepositorioLugares;
import com.example.mislugares.modelo.Lugar;

import java.text.DateFormat;
import java.util.Date;

public class VistaLugarActivity extends AppCompatActivity {

    private RepositorioLugares lugares;
    private CasosUsoLugar usoLugar;
    private int pos;
    private Lugar lugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.vista_lugar);
        Bundle extras = getIntent().getExtras();

        pos = extras.getInt("pos", 0);
        lugares = ((Aplicacion) getApplication()).lugares;

        usoLugar = new CasosUsoLugar(this, lugares);
        lugar = lugares.elemento(pos);

        actualizaVistas();
    }
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.vista_lugar, menu);
        return true;
    }*/
   public void actualizaVistas() {
       if (lugar == null) return; // Salir si el lugar es nulo

       TextView nombre = findViewById(R.id.nombre);
       if (nombre != null) nombre.setText(lugar.getNombre());

       ImageView logo_tipo = findViewById(R.id.logo_tipo);
       if (logo_tipo != null) logo_tipo.setImageResource(lugar.getTipo().getRecurso());

       TextView tipo = findViewById(R.id.tipo);
       if (tipo != null) tipo.setText(lugar.getTipo().getTexto());

       TextView direccion = findViewById(R.id.direccion);
       if (direccion != null) direccion.setText(lugar.getDireccion());

       TextView telefono = findViewById(R.id.telefono);
       if (telefono != null) telefono.setText(Integer.toString(lugar.getTelefono()));

       TextView url = findViewById(R.id.url);
       if (url != null) url.setText(lugar.getUrl());

       TextView comentario = findViewById(R.id.comentario);
       if (comentario != null) comentario.setText(lugar.getComentario());

       TextView fecha = findViewById(R.id.fecha);
       if (fecha != null) fecha.setText(DateFormat.getDateInstance().format(new Date(lugar.getFecha())));

       TextView hora = findViewById(R.id.hora);
       if (hora != null) hora.setText(DateFormat.getTimeInstance().format(new Date(lugar.getFecha())));

       RatingBar valoracion = findViewById(R.id.valoracion);
       if (valoracion != null) {
           valoracion.setRating(lugar.getValoracion());
           valoracion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
               @Override
               public void onRatingChanged(RatingBar ratingBar, float valor, boolean fromUser) {
                   lugar.setValoracion(valor);
               }
           });
       }
    }
}
