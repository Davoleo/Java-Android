package net.davoleo.java_android.movie_player;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import net.davoleo.java_android.R;

import java.util.ArrayList;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 08/03/2019 / 20:03
 * Class: MovieListAdapter
 * Project: Java-Android
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class MovieListAdapter extends BaseAdapter {

    private Context context;
    ArrayList<Movie> videoList;

    public MovieListAdapter(Context context, ArrayList<Movie> videoList)
    {
        this.context = context;
        this.videoList = videoList;
    }

    @Override
    public int getCount()
    {
        return videoList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return videoList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // se non è una view già usata creala con il suo layout
        if (convertView == null) {
            LayoutInflater layoutInflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.movie_item, null);
        }

        //otteniamo il video alla posizione richiesta
        Movie movie = (Movie) getItem(position);

        // thumbnail
        ImageView thumbnail =
                (ImageView) convertView.findViewById(R.id.thumbnail);

        if (movie.getThumbnailPath() != null) {
            thumbnail.setImageURI(Uri.parse(movie.getThumbnailPath()));
        } else {
            thumbnail.setImageResource(R.drawable.ic_launcher_foreground);
        }

        //titolo
        TextView titolo = (TextView) convertView.findViewById(R.id.titolo);
        titolo.setText(movie.getTitle());

        //durata
        TextView durata = (TextView) convertView.findViewById(R.id.durata);
        durata.setText(getDurationAsString(movie.getDuration()));

        return convertView;
    }

    private static String getDurationAsString(long duration)
    {
        long seconds = duration / 1000;
        long milliseconds = duration % 1000;

        long minutes = seconds / 60;
        seconds %= 60;

        long hours = minutes / 60;
        minutes %= 60;

        return String.format("%1$02d:%2$02d:%3$02d.%4$03d", hours, minutes, seconds, milliseconds);
    }
}
