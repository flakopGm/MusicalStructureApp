package com.example.joni.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Pistas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_pistas);

        // Creación de una lista de canciones de ejemplo.
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Rag'n'Bone Man", "Human", R.drawable.ragbon, true));
        songs.add(new Song("Los del Rio", "Macarena", R.mipmap.ic_music_note_white_18dp, false));
        songs.add(new Song("Shakira ft Prince Royce", "Deja vu", R.mipmap.ic_music_note_white_18dp,
                true));
        songs.add(new Song("Ed Sheeran", "Shape of You", R.drawable.edsherran, true));
        songs.add(new Song("Luis Fonsi", "Despacito", R.mipmap.ic_music_note_white_18dp, false));
        songs.add(new Song("Bruno Mars", "24K Magic", R.drawable.brunomars, false));
        songs.add(new Song("Enrique Iglesias", "Subeme la Radio", R.mipmap.ic_music_note_white_18dp,
                false));
        songs.add(new Song("Isabel Pantoja", "Como una ola", R.mipmap.ic_music_note_white_18dp,
                false));

        // Creacion de {@link SongAdapter} cuyo origen de datos es la lista de {@link Song}s.
        SongAdapter adapter = new SongAdapter(this, songs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // song_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // {@link ListView} utiliza {@link SongAdapter} creado anteriormente para que
        // {@link ListView} muestre los elementos de la lista de cada {@link Song} en la lista.
        listView.setAdapter(adapter);
        // Escucha para la lista, al pulsar un item se envía su portada, el autor y el título de la
        // canción seleccionada, también el estado para saber si la canción está marcada como
        // favorita o no.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Pistas.this, ReproduccionActual.class);
                Song currentSong = songs.get(position);
                String autorSeleccionado = currentSong.getAutor();
                String tituloSeleccionado = currentSong.getTitulo();
                int caratulaSeleccionada = currentSong.getCaratula();
                boolean estadoElementoActual = currentSong.isEstadoLike();

                // Pasamos los datos de la canción seleccionada para mostrar en la pantalla
                // de reproducción en curos. //
                intent.putExtra("caratula", caratulaSeleccionada);
                intent.putExtra("autor", autorSeleccionado);
                intent.putExtra("titulo", tituloSeleccionado);
                intent.putExtra("estado", estadoElementoActual);

                // Lanzamos la activity
                startActivity(intent);
                finish();
            }
        });
    }
}
