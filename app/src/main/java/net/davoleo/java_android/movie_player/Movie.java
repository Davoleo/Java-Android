package net.davoleo.java_android.movie_player;

import android.database.Cursor;
import android.provider.MediaStore;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 08/03/2019 / 19:51
 * Class: Movie
 * Project: Java-Android
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class Movie {

    private String title;
    private String videoPath;
    private String mimeType;
    private long duration;
    private String thumbnailPath;

    public Movie(Cursor mediaCursor, Cursor thumbnailCursor)
    {
        title = mediaCursor.getString(mediaCursor.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE));
        videoPath = mediaCursor.getString(mediaCursor.getColumnIndex(MediaStore.Video.Media.DATA));
        mimeType = mediaCursor.getString(mediaCursor.getColumnIndex(MediaStore.Video.Media.MIME_TYPE));
        duration = mediaCursor.getLong(mediaCursor.getColumnIndex(MediaStore.Video.Media.DURATION));

        if (thumbnailCursor != null && thumbnailCursor.moveToFirst())
            thumbnailPath = thumbnailCursor.getString(thumbnailCursor.getColumnIndex(MediaStore.Video.Thumbnails.DATA));
        else
            thumbnailPath = null;
    }

    public String getTitle()
    {
        return title;
    }

    public String getVideoPath()
    {
        return videoPath;
    }

    public String getMimeType()
    {
        return mimeType;
    }

    public long getDuration()
    {
        return duration;
    }

    public String getThumbnailPath()
    {
        return thumbnailPath;
    }

    @Override
    public String toString()
    {
        return "Video [title=" + title + ", path=" + videoPath + ", mimeType=" + mimeType + ", duration=" + duration + ", thumbnailPath=" + thumbnailPath + "]";
    }
}
