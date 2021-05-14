package com.dstanton;

import java.util.LinkedList;
import java.util.ArrayList;

class Playlist {
    private LinkedList<Song> playlist;
    private String name;

    public Playlist(String name) {
        this.name = name;
        playlist = new LinkedList<Song>();
    }

    public String getName() {
        return this.name;
    }

    public LinkedList<Song> getPlaylist() {
        return this.playlist;
    }

    public boolean addSong(ArrayList<Album> albums, String song) {

        for (Album a: albums) {
            ArrayList<Song> songs = a.getSongs();

            for (Song s: songs) {
                if (s.getTitle().equalsIgnoreCase(song)) {
                    playlist.add(s);
                    return true;
                }
            }
        }
        return false;
    }

    public void printPlayList() {
        for(Song s:playlist) {
            System.out.println(s.toString());
        }
    }
}
