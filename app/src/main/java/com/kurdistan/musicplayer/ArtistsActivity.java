package com.kurdistan.musicplayer;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;

public class ArtistsActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        if (isPlaying)
            showPlayingBar();
        ArtistAdapter artistAdapter = new ArtistAdapter(this, artists);
        listView.setAdapter(artistAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                position = 0;
                queue = songs;
                isPlaying = true;
                playMusic();

            }
        });
        playingImageView.setImageTintList(ColorStateList.valueOf(Color.DKGRAY));
        songsImageView.setImageTintList(ColorStateList.valueOf(Color.DKGRAY));
        artistsImageView.setImageTintList(ContextCompat.getColorStateList(ArtistsActivity.this, R.color.purple));
        albumsImageView.setImageTintList(ColorStateList.valueOf(Color.DKGRAY));
        playingTextView.setTextColor(Color.DKGRAY);
        songsTextView.setTextColor(Color.DKGRAY);
        artistTextView.setTextColor(ContextCompat.getColor(ArtistsActivity.this, R.color.purple));
        albumTextView.setTextColor(Color.DKGRAY);

        playingLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArtistsActivity.this, PlayingActivity.class);
                startActivity(intent);
            }
        });
        songsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArtistsActivity.this, SongsActivity.class);
                startActivity(intent);
            }
        });
        artistsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        albumsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArtistsActivity.this, AlbumsActivity.class);
                startActivity(intent);
            }
        });
        playPauseButton.setOnClickListener(playPauseOnClickListener());
        nextSkipButton.setOnClickListener(nextSkipOnClickListener());
        previousSkipButton.setOnClickListener(previousSkipOnClickListener());

    }

}
