package com.kurdistan.musicplayer;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class Artist implements Comparable<Artist> {
    private String artistName;
    private ArrayList<Album> albums;

    public Artist(String artistName, ArrayList<Album> albums) {
        this.artistName = artistName;
        this.albums = albums;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public String getArtistName() {
        return artistName;
    }

    @Override
    public int compareTo(@NonNull Artist o) {
        return this.getArtistName().compareTo(o.getArtistName());
    }
}
