package com.kurdistan.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class ParentActivity extends AppCompatActivity {
    protected static MediaPlayer mediaPlayer;
    static ArrayList<Artist> artists;
    protected ArrayList<Album> albums;
    protected ArrayList<Song> songs;
    static ArrayList<Song> queue;
    static int position;
    protected static boolean isPlaying = false;
    protected ImageView playPauseButton;
    protected ImageView nextSkipButton;
    protected ImageView previousSkipButton;
    protected LinearLayout playingLayout;
    protected LinearLayout songsLayout;
    protected LinearLayout artistsLayout;
    protected LinearLayout albumsLayout;
    protected ImageView playingImageView;
    protected ImageView songsImageView;
    protected ImageView artistsImageView;
    protected ImageView albumsImageView;
    protected TextView playingTextView;
    protected TextView songsTextView;
    protected TextView artistTextView;
    protected TextView albumTextView;
    protected ListView listView;
    public static LinearLayout layout;
    static Song playingSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        albums = new ArrayList<>();
        songs = new ArrayList<>();
        for (Artist artist : artists) {
            for (Album album : artist.getAlbums()) {
                for (Song song1 : album.getSongs()) {
                    song1.setArtist(artist);
                    song1.setAlbum(album);
                    songs.add(song1);
                }
            }
            albums.addAll(artist.getAlbums());
        }
        Collections.sort(songs);
        Collections.sort(albums);
        playingLayout = findViewById(R.id.playing_layout);
        songsLayout = findViewById(R.id.songs_layout);
        artistsLayout = findViewById(R.id.artists_layout);
        albumsLayout = findViewById(R.id.albums_layout);
        playingImageView = findViewById(R.id.playing_image_view);
        songsImageView = findViewById(R.id.songs_image_view);
        artistsImageView = findViewById(R.id.artists_image_view);
        albumsImageView = findViewById(R.id.albums_image_view);
        playingTextView = findViewById(R.id.playing_text_view);
        songsTextView = findViewById(R.id.songs_text_view);
        artistTextView = findViewById(R.id.artists_text_view);
        albumTextView = findViewById(R.id.albums_text_view);
        playPauseButton = findViewById(R.id.play_pause_image_view);
        nextSkipButton = findViewById(R.id.next_image_view);
        previousSkipButton = findViewById(R.id.previous_image_view);
        listView = findViewById(R.id.list_layout);
        playPauseButton.setOnClickListener(playPauseOnClickListener());
        nextSkipButton.setOnClickListener(nextSkipOnClickListener());
        previousSkipButton.setOnClickListener(previousSkipOnClickListener());
        layout = findViewById(R.id.playing_bar_layout);
    }

    protected void playMusic() {
        releaseMediaPlayer();
        showPlayingBar();
        playingSong = queue.get(position);
        int resourceID = playingSong.getSongResourceID();
        mediaPlayer = MediaPlayer.create(this, resourceID);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                position++;
                if (position == queue.size()) {
                    position = 0;
                }
                playMusic();
            }
        });
    }

    protected View.OnClickListener playPauseOnClickListener() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                if (mediaPlayer != null)
                    if (isPlaying) {
                        mediaPlayer.pause();
                        isPlaying = false;
                        playPauseButton.setImageResource(R.drawable.baseline_play_arrow_white_24);
                    } else {
                        mediaPlayer.start();
                        isPlaying = true;
                        playPauseButton.setImageResource(R.drawable.baseline_pause_white_24);
                    }
            }
        };
    }


    protected View.OnClickListener nextSkipOnClickListener() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                if (position != queue.size() - 1)
                    position++;
                else
                    position = 0;
                if (isPlaying)
                    playMusic();
                else {
                    mediaPlayer = MediaPlayer.create(ParentActivity.this, queue.get(position).getSongResourceID());
                    showPlayingBar();
                }
            }
        };
    }

    protected View.OnClickListener previousSkipOnClickListener() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                if (position == 0)
                    position = queue.size() - 1;
                else
                    position--;
                if (isPlaying)
                    playMusic();
                else {
                    mediaPlayer = MediaPlayer.create(ParentActivity.this, queue.get(position).getSongResourceID());
                    showPlayingBar();
                }
            }
        };
    }

    protected void showPlayingBar() {
        layout.setVisibility(View.VISIBLE);
        TextView songName = findViewById(R.id.playing_song_name);
        songName.setText(queue.get(position).getSongName());
        TextView artistName = findViewById(R.id.playing_artist_name);
        artistName.setText(queue.get(position).getArtist().getArtistName());
    }

    static void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            layout.setVisibility(View.GONE);
            isPlaying = false;
        }
    }


}
