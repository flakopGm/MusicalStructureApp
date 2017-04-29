package com.example.joni.musicalstructureapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class ListaReproduccion extends AppCompatActivity {

    private ImageView listaAleatoria;
    private LinearLayout listasGuardadas;
    private ImageView botonListasGuardadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_reproduccion);

        // Localizamos el botón de crear lista musical aleatoria con el id lista_aleatoria.
        listaAleatoria = (ImageView) findViewById(R.id.lista_aleatoria);
        // **NO TIENE FUNCIONALIDAD AUN** Escucha para mostrar un toast.
        listaAleatoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListaReproduccion.this, "Lista aleatoria Creada automáticamente",
                        Toast.LENGTH_SHORT).show();
            }
        });
        // Localizamos el LinearLayout donde se muestran las listas guardadas.
        listasGuardadas = (LinearLayout) findViewById(R.id.cuadro_listas);
        // Localizamos el botón para acceder a las listas guardadas para utilizarlas o editarlas.
        botonListasGuardadas = (ImageView) findViewById(R.id.listasGuardadas);
        // Escucha para el botón de listas guardadas.
        botonListasGuardadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listasGuardadas.getVisibility() == View.VISIBLE) {
                    listasGuardadas.setVisibility(View.INVISIBLE);
                } else {
                    listasGuardadas.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
