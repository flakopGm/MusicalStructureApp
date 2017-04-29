package com.example.joni.musicalstructureapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by flkpgm on 27/04/2017.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Compruebe si se está reutilizando una vista existente, de lo contrario infle la vista.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_pistas, parent, false);
        }
        // Obtenga el objeto {@link Song} ubicado en esta posición en la lista
        final Song currentSong = getItem(position);
        // Busque TextView en el layout activity_pistas.xml con el ID autor.
        TextView autorSong = (TextView) listItemView.findViewById(R.id.autor);
        // Obtenga el autor del objeto currentSong y configure este texto en el autor TextView.
        autorSong.setText(currentSong.getAutor());
        // Busque TextView en el layout activity_pistas.xml con el ID title_song.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.title_Song);
        // Obtenga el titulo del objeto currentSong y configure este texto en el title_song TextView
        defaultTextView.setText(currentSong.getTitulo());
        //Encuentra la imagen en la list_item.xml layout con el ID image.
        ImageView iconoRef = (ImageView) listItemView.findViewById(R.id.photoMusic);
        // Muestra la imagen de la carátula en el visor.
        iconoRef.setImageResource(currentSong.getCaratula());
        // Estado para la canción.
        Boolean estadoLike = currentSong.isEstadoLike();
        // Localizamos el icono like y su estado y según el resultado, mostramos un icono u otro.
        ImageView iconoLike = (ImageView) listItemView.findViewById(R.id.like_Song);

        if (estadoLike != false) {
            iconoLike.setImageResource(R.mipmap.ic_favorite_white_18dp);
            currentSong.setEstadoLike(true);
        } else {
            iconoLike.setImageResource(R.mipmap.ic_favorite_border_white_18dp);
            currentSong.setEstadoLike(false);
        }
        return listItemView;
    }
}
