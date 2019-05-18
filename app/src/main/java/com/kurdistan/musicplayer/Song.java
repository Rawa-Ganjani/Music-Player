package com.kurdistan.musicplayer;

public class Song implements Comparable<Song> {
    private String songName;
    private int songResourceID;
    private Artist artist;
    private Album album;

    public Song(String songName, int songResourceID) {
        this.songName = songName;
        this.songResourceID = songResourceID;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getSongResourceID() {
        return songResourceID;
    }

    public String getSongName() {
        return songName;
    }

    @Override
    public int compareTo(Song o) {
        return this.getSongName().compareTo(o.getSongName());
    }
}
