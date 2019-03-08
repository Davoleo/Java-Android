package net.davoleo.java_android.movie_player;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import net.davoleo.java_android.R;

import java.util.ArrayList;

public class ActivityMoviePlayer extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_player);

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        0);
        }

        ArrayList<Movie> movieList = new ArrayList<>();

        //Array of the various columns headings
        String[] mediaColumns = {
                MediaStore.Video.Media._ID,
                MediaStore.Video.Media.TITLE,
                MediaStore.Video.Media.DURATION,
                MediaStore.Video.Media.DATA,
                MediaStore.Video.Media.MIME_TYPE
        };

        //Thumbnails columns headings
        String[] thumbnailColumns = {MediaStore.Video.Thumbnails.DATA};

        //Video Database cursor
        Cursor mediaCursor = getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, null);

        if ((mediaCursor != null) && mediaCursor.moveToFirst())
        {
            do {
                //video ID
                int id = mediaCursor.getInt(mediaCursor.getColumnIndex(MediaStore.Video.Media._ID));

                Cursor thumbnailCursor = getContentResolver()
                        .query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, thumbnailColumns,
                                MediaStore.Video.Thumbnails.VIDEO_ID + "=" + id, null, null);

                //Creation of a movie object with all the data about the movie and add it to the list of movies
                Movie movie = new Movie(mediaCursor, thumbnailCursor);
                movieList.add(movie);
            }while (mediaCursor.moveToNext());

            mediaCursor.close();
        }


        MovieListAdapter movieListAdapter = new MovieListAdapter(this, movieList);
        ListView movieListView = (ListView) findViewById(R.id.movieList);

        movieListView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        //Chosen video
        Movie movie = (Movie) parent.getAdapter().getItem(position);

        //Plays the video
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse(movie.getVideoPath()), movie.getMimeType());
        startActivity(intent);
    }
}
