package com.dstanton;


import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private ArrayList<Song> songs;

    public Album(String name) {
        this.name = name;
        songs = new ArrayList<Song>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Song> getSongs() {
        return this.songs;
    }

    public void addSong(String song, double duration) {
        songs.add(new Song(song, duration));
    }

    public void printSongs() {
        System.out.println(this.name + " songs:");
        for (Song s: songs) {
            System.out.println((songs.indexOf(s) + 1) + ". " + s.toString());
        }
    }

}
