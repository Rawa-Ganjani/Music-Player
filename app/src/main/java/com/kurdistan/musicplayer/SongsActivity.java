package com.kurdistan.musicplayer;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;

public class SongsActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        if (isPlaying) {
            showPlayingBar();
        }
        SongAdapter songAdapter = new SongAdapter(this, songs);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (position != i || i == 0) {
                    queue = songs;
                    isPlaying = true;
                    position = i;
                    playMusic();
                }
            }
        });
        listView.setAdapter(songAdapter);
        playingImageView.setImageTintList(ColorStateList.valueOf(Color.DKGRAY));
        songsImageView.setImageTintList(ContextCompat.getColorStateList(SongsActivity.this, R.color.orange));
        artistsImageView.setImageTintList(ColorStateList.valueOf(Color.DKGRAY));
        albumsImageView.setImageTintList(ColorStateList.valueOf(Color.DKGRAY));
        playingTextView.setTextColor(Color.DKGRAY);
        songsTextView.setTextColor(ContextCompat.getColor(SongsActivity.this, R.color.orange));
        artistTextView.setTextColor(Color.DKGRAY);
        albumTextView.setTextColor(Color.DKGRAY);

        playingLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SongsActivity.this, PlayingActivity.class);
                startActivity(intent);
            }
        });
        songsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        artistsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SongsActivity.this, ArtistsActivity.class);
                startActivity(intent);
            }
        });
        albumsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SongsActivity.this, AlbumsActivity.class);
                startActivity(intent);
            }
        });

        playPauseButton.setOnClickListener(playPauseOnClickListener());
        nextSkipButton.setOnClickListener(nextSkipOnClickListener());
        previousSkipButton.setOnClickListener(previousSkipOnClickListener());
    }
}
