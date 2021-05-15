package com.dstanton;


import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private ArrayList<Song> songs;

    public Album(String name) {
        this.name = name;
        songs = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Song> getSongs() {
        return this.songs;
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public void printSongs() {
        System.out.println(this.name + " songs:");
        for (Song s: songs) {
            System.out.println((songs.indexOf(s) + 1) + ". " + s.toString());
        }
    }

    private Song findSong(String title) {
        for (Song checkedSong: this.songs) {
            if (checkedSong.getTitle().equalsIgnoreCase(title)) {
                return checkedSong;
            }
        }

        return null;
    }

}
