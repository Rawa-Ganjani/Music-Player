package com.kurdistan.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayingAdapter extends ArrayAdapter<Song> {
    public PlayingAdapter(Context context, ArrayList<Song> list) {
        super(context, 0, list);
    }

    public View getView(final int position, View convertView, final ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.playing_adapter, parent, false);
        }
        final Song song = getItem(position);
        TextView songName = listItem.findViewById(R.id.song_name_text_view);
        songName.setText(song.getSongName());
        TextView desc = listItem.findViewById(R.id.artist_text_view);
        desc.setText(song.getArtist().getArtistName());
        ImageView deleteImageView = listItem.findViewById(R.id.delete_button);
        deleteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayingAdapter.this.remove(song);
                ParentActivity.queue.remove(song);
                if (!ParentActivity.queue.contains(ParentActivity.playingSong)) {
                    ParentActivity.releaseMediaPlayer();
                }
            }
        });
        return listItem;
    }
}
