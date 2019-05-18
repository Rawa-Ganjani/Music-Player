package com.kurdistan.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumAdapter extends ArrayAdapter<Album> {

    public AlbumAdapter(Context context, ArrayList<Album> list) {
        super(context, 0, list);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.album_layout, parent, false);
        }
        Album album = getItem(position);
        ImageView imageView = listItem.findViewById(R.id.album_layout_image_view);
        imageView.setImageResource(album.getImageResourceID());
        TextView albumName = listItem.findViewById(R.id.album_layout_album_name_text_view);
        albumName.setText(album.getAlbumName());
        TextView trackNumber = listItem.findViewById(R.id.album_layout_track_numbers_text_view);
        int n = album.getSongs().size();
        trackNumber.setText((n + " Tracks"));
        return listItem;
    }
}
