package com.example.joni.musicalstructureapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ReproduccionActual extends AppCompatActivity {

    private ImageView pistas;
    private ImageView favorite;
    private ImageView shopping;
    private ImageView play;
    private ImageView stop;
    private ImageView pause;
    private TextView autor;
    private TextView titulo;
    private ImageView equalizer;
    private ImageView subirVol;
    private ImageView bajarVol;
    private ImageView mute;
    private ImageView listaRep;
    private LinearLayout fondo;
    private boolean estado;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reproduccion_actual);

        // Localizamos el botón de ir a las pistas de audio con el id pistas.
        pistas = (ImageView) findViewById(R.id.pistas);
        // Escucha para ir a la activity de la lista de pistas disponibles.
        pistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReproduccionActual.this, Pistas.class);
                startActivity(intent);
            }
        });

        // Localizamos el botón de canción favorita con el id like.
        favorite = (ImageView) findViewById(R.id.like);
        // Escucha para el botón de canción favorita. Si está falso será un icono, si está verdadero
        // será el mismo icono relleno.
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (estado == false) {
                    favorite.setImageResource(R.mipmap.ic_favorite_white_18dp);
                    Toast.makeText(ReproduccionActual.this, R.string.favorito,
                            Toast.LENGTH_SHORT).show();
                    estado = true;
                } else {
                    favorite.setImageResource(R.mipmap.ic_favorite_border_white_18dp);
                    Toast.makeText(ReproduccionActual.this, R.string.desfavorito,
                            Toast.LENGTH_SHORT).show();
                    estado = false;
                }
            }
        });

        // Localizamos el botón de tienda con el id shopping.
        shopping = (ImageView) findViewById(R.id.shopping);
        // Escucha para el botón de tienda y accedemos a una tienda externa. (Google play music).
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse
                        ("https://play.google.com/store/music"));
                startActivity(intent);
            }
        });

        // Localizamos el botón para parar la reproducción con el id stop.
        stop = (ImageView) findViewById(R.id.stop);
        // Escucha para el botón stop, ** NO ** tiene funcionalidad, muestra un toast.
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ReproduccionActual.this, "Reproducción detenida",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Localizamos el botón pause con el id pause.
        pause = (ImageView) findViewById(R.id.pause);
        // Escucha para el botón pause. ** NO ** tiene funcionalidad, muestra un toast.
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ReproduccionActual.this, "Reproducción pausada",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Localizamos el TextView informativo con el id infotext.
        info = (TextView) findViewById(R.id.infotext);
        // Escucha para el TextView de info, mostrar/ocultar si se pulsa.
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getVisibility() == View.VISIBLE) {
                    info.setVisibility(View.INVISIBLE);
                } else {
                    info.setVisibility(View.VISIBLE);
                }
            }
        });

        // Localizamos el fondo de la caratula de la canción con el id visor_reproductor.
        fondo = (LinearLayout) findViewById(R.id.visor_reproductor);
        // Recibimos en un intent la carátula de la canción seleccionada en la activity Pistas
        // y lo mostramos en el visor.
        fondo.setBackgroundResource(getIntent().getIntExtra("caratula", R.color.fondo));
        // Escucha para el fondo, al pulsarlo ocultamos el texto informativo.
        fondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getVisibility() == View.INVISIBLE) {
                    info.setVisibility(View.VISIBLE);
                } else {
                    info.setVisibility(View.INVISIBLE);
                }
            }
        });

        // Localizamos el TextView donde se expone el nombre del autor con el id autorActual.
        autor = (TextView) findViewById(R.id.autorActual);
        // Localizamos el TextView donde se expone el nombre de la canción actual con el id
        // tituloActual.
        titulo = (TextView) findViewById(R.id.tituloActual);
        // Recibimos en un intent el autor y lo mostramos en el TextView autor.
        autor.setText(getIntent().getStringExtra("autor"));
        // Recibimos en un intent el título de la canción y lo mostramos en el TextView titulo.
        titulo.setText(getIntent().getStringExtra("titulo"));
        // Recibimos en un intent el estado de la canción seleccionado por el usuario, para marcar
        // o desmarcar el icono de like.
        estado = getIntent().getBooleanExtra("estado", false);
        if (estado != false) {
            favorite.setImageResource(R.mipmap.ic_favorite_white_18dp);
        }

        // Localizamos el botón de ecualizador con el id equalizer.
        equalizer = (ImageView) findViewById(R.id.equalizer);
        // Escucha para el botón ecualizador, nueva activity, ecualizador simulado.
        // ** NO ** tiene funcionalidad.
        equalizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReproduccionActual.this, Ecualizer.class);
                startActivity(intent);
            }
        });

        // Localizamos el botón de subir el volumen con el id subirVol.
        subirVol = (ImageView) findViewById(R.id.subirVol);
        // Escucha para el botón de subir volumen. **NO** tiene funcionalidad, muestra un toast.
        subirVol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ReproduccionActual.this, "Volumen up", Toast.LENGTH_SHORT).show();
            }
        });

        // Localizamos el botón de bajar el volumen con el id bajarVol.
        bajarVol = (ImageView) findViewById(R.id.bajarVol);
        // Escucha para el botón de bajar volumen. **NO** tiene funcionalidad, muestra un toast.
        bajarVol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ReproduccionActual.this, "Volumen down", Toast.LENGTH_SHORT).show();
            }
        });

        // Localizamos el botón de silenciar volumen con el id mute.
        mute = (ImageView) findViewById(R.id.mute);
        // Escucha para el botón de silenciar volumen. **NO** tiene funcionalidad, muestra un toast.
        mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ReproduccionActual.this, "Volumen Silenciado",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Localizamos el botón de lista de reproducción con el id listaReproduccion.
        listaRep = (ImageView) findViewById(R.id.listaReproducion);
        // Escucha para el botón de lista de reproducción, va a la activity de lista de reproduccion.
        listaRep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReproduccionActual.this, ListaReproduccion.class);
                startActivity(intent);
            }
        });
    }
}
