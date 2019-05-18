package com.kurdistan.musicplayer;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;

public class AlbumsActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        if (isPlaying)
            showPlayingBar();
        AlbumAdapter albumAdapter = new AlbumAdapter(this, albums);
        listView.setAdapter(albumAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                position = 0;
                queue = albums.get(i).getSongs();
                isPlaying = true;
                playMusic();
            }
        });
        playingImageView.setImageTintList(ColorStateList.valueOf(Color.DKGRAY));
        songsImageView.setImageTintList(ColorStateList.valueOf(Color.DKGRAY));
        artistsImageView.setImageTintList(ColorStateList.valueOf(Color.DKGRAY));
        albumsImageView.setImageTintList(ContextCompat.getColorStateList(AlbumsActivity.this, R.color.green));
        playingTextView.setTextColor(Color.DKGRAY);
        songsTextView.setTextColor(Color.DKGRAY);
        artistTextView.setTextColor(Color.DKGRAY);
        albumTextView.setTextColor(ContextCompat.getColor(AlbumsActivity.this, R.color.green));

        playingLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlbumsActivity.this, PlayingActivity.class);
                startActivity(intent);
            }
        });
        songsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlbumsActivity.this, SongsActivity.class);
                startActivity(intent);
            }
        });
        artistsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlbumsActivity.this, ArtistsActivity.class);
                startActivity(intent);
            }
        });
        albumsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        playPauseButton.setOnClickListener(playPauseOnClickListener());
        nextSkipButton.setOnClickListener(nextSkipOnClickListener());
        previousSkipButton.setOnClickListener(previousSkipOnClickListener());
    }
}
