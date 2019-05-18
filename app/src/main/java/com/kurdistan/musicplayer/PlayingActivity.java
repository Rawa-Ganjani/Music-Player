package com.kurdistan.musicplayer;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;

public class PlayingActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        if (isPlaying)
            showPlayingBar();
        PlayingAdapter playingAdapter = new PlayingAdapter(this, queue);
        if (queue != null) {
            listView.setAdapter(playingAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    isPlaying = true;
                    position = i;
                    playMusic();
                }
            });
        }
        playingImageView.setImageTintList(ContextCompat.getColorStateList(PlayingActivity.this, R.color.red));
        songsImageView.setImageTintList(ColorStateList.valueOf(Color.DKGRAY));
        artistsImageView.setImageTintList(ColorStateList.valueOf(Color.DKGRAY));
        albumsImageView.setImageTintList(ColorStateList.valueOf(Color.DKGRAY));
        playingTextView.setTextColor(ContextCompat.getColor(PlayingActivity.this, R.color.red));
        songsTextView.setTextColor(Color.DKGRAY);
        artistTextView.setTextColor(Color.DKGRAY);
        albumTextView.setTextColor(Color.DKGRAY);

        playingLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        songsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayingActivity.this, SongsActivity.class);
                startActivity(intent);
            }
        });
        artistsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayingActivity.this, ArtistsActivity.class);
                startActivity(intent);
            }
        });
        albumsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayingActivity.this, AlbumsActivity.class);
                startActivity(intent);
            }
        });


    }

}
