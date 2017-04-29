package com.example.joni.musicalstructureapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Ecualizer extends AppCompatActivity {

    // TextView informativo
    private TextView ecualizer;
    private RelativeLayout fondoEcualizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecualizer);

        // Localizamos el TextView informativo con el id ecualizer.
        ecualizer = (TextView) findViewById(R.id.ecualizer_TextView);
        // Localizamos el fondo con el id fondoEcualizador.
        fondoEcualizer = (RelativeLayout) findViewById(R.id.fondoEcualizador);
        // Escucha para ocultar/mostrar el texto informativo si se pulsa la pantalla.
        fondoEcualizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ecualizer.getVisibility() != View.VISIBLE) {
                    ecualizer.setVisibility(View.VISIBLE);
                } else {
                    ecualizer.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
