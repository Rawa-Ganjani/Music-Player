package com.kurdistan.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Context context, ArrayList<Song> list) {
        super(context, 0, list);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.song_layout, parent, false);
        }
        Song song = getItem(position);
        ImageView imageView = listItem.findViewById(R.id.song_image_view);
        imageView.setImageResource(song.getAlbum().getImageResourceID());
        TextView songName = listItem.findViewById(R.id.song_name_text_view);
        songName.setText(song.getSongName());
        TextView desc = listItem.findViewById(R.id.artist_text_view);
        desc.setText(song.getArtist().getArtistName());
        TextView albumTextView = listItem.findViewById(R.id.album_text_view);
        albumTextView.setText(song.getAlbum().getAlbumName());
        return listItem;
    }
}
