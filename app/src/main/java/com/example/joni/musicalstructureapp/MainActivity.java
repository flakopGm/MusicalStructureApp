package com.example.joni.musicalstructureapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView reproductor;
    private ImageView pistasReproductor;
    private ImageView tiendaMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caratula);

        // Localizamos el icono del reproductor con el id playing.
        reproductor = (ImageView) findViewById(R.id.playing);
        // Escucha para el icono del reproductor para lanzar su activity en caso de click.
        reproductor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReproduccionActual.class);
                startActivity(intent);
            }
        });

        // Localizamos el icono de la librería con el id libreria.
        pistasReproductor = (ImageView) findViewById(R.id.libreria);
        // Escucha para el botón de librería y lanzar su activity en caso de click.
        pistasReproductor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pistas.class);
                startActivity(intent);
            }
        });

        // Localizamos el botón de tienda con el id shop.
        tiendaMusica = (ImageView) findViewById(R.id.shop);
        // Escucha para el botón de tienda para lanzar su activity en caso de click.
        tiendaMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/music"));
                startActivity(intent);
            }
        });
    }
}
