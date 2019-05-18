package com.kurdistan.musicplayer;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class Album implements Comparable<Album> {
    private String albumName;
    private ArrayList<Song> songs;
    private int imageResourceID;

    public Album(String albumName, ArrayList<Song> songs, int imageResourceID) {
        this.albumName = albumName;
        this.songs = songs;
        this.imageResourceID = imageResourceID;
    }

    public String getAlbumName() {
        return albumName;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    @Override
    public int compareTo(@NonNull Album o) {
        return this.getAlbumName().compareTo(o.getAlbumName());
    }
}
