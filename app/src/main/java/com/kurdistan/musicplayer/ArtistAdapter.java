package com.kurdistan.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistAdapter extends ArrayAdapter<Artist> {
    public ArtistAdapter(Context context, ArrayList<Artist> list) {
        super(context, 0, list);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.artist_layout, parent, false);
        }
        Artist artist = getItem(position);
        ImageView imageView = listItem.findViewById(R.id.artist_layout_image_view);
        imageView.setImageResource(artist.getAlbums().get(0).getImageResourceID());
        TextView artistName = listItem.findViewById(R.id.artist_layout_artist_name_text_view);
        artistName.setText(artist.getArtistName());
        TextView trackNumber = listItem.findViewById(R.id.artist_layout_track_numbers_text_view);
        int n = 0;
        for (Album album : artist.getAlbums()) {
            n += album.getSongs().size();
        }
        trackNumber.setText((n + " Tracks"));
        return listItem;
    }
}
