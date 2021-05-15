package com.dstanton;

import java.util.ListIterator;
import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
/*
        Create a program that implements a playlist for songs.
        Create a Song class having Title and Duration for a song.
        The program will have an Album class containing a list of songs.
        The albums will be stored in an ArrayList.

        Songs from different albums can be added to the playlist and will appear in
        the list in the order they are added.

        Once the songs have been added to the playlist, create a menu of options to:
        - Quit,
        - Skip forward to the next song,
        - skip backwards to a previous song.
        - Replay the current song.
        - List the songs in the playlist

        A song must exist in an album before it can be added to the
        playlist (so you can only play songs that you own).

        Hint:  To replay a song, consider what happened when we went back and forth
        from a city before we started tracking the direction we were going.

        As an optional extra, provide an option to remove the current song from the
        playlist (hint: listiterator.remove()
*/

        ArrayList<Album> albums = new ArrayList<>();

        Album darkSide = new Album("Dark Side of the Moon");

        darkSide.addSong("Speak to Me",1.13);
        darkSide.addSong("Breath",2.43);
        darkSide.addSong("On the Run",3.36);
        darkSide.addSong("Time",6.53);
        darkSide.addSong("The Great Gig in the Sky",4.36);

        albums.add(darkSide);

        Album meetTheBeatles = new Album("Meet the Beatles!");
        meetTheBeatles.addSong("I Want To Hold Your Hand",2.24);
        meetTheBeatles.addSong("I Saw Her Standing There",2.50);
        meetTheBeatles.addSong("This Boy",2.11);
        meetTheBeatles.addSong("It Won't Be Long",2.11);
        meetTheBeatles.addSong("All I've Got To Do",2.05);
        meetTheBeatles.addSong("All My Loving",2.04);

        albums.add(meetTheBeatles);


        Album theDoors = new Album("The Doors");
        theDoors.addSong("Break on Through",2.25);
        theDoors.addSong("Soul Kitchen",3.30);
        theDoors.addSong("The Crystal Ship",2.30);
        theDoors.addSong("Twentieth Century Fox",2.30);
        theDoors.addSong("Alabama Song (Whiskey Bar)",3.15);
        theDoors.addSong("Light My Fire",6.50);

        albums.add(theDoors);

//        for (Album a: albums) {
//            a.printSongs();
//        }


        System.out.println();

        Playlist playlist = new Playlist("My Playlist");

        playlist.addSong(albums, "Soul Kitchen");
        playlist.addSong(albums, "The Great Gig in the Sky");
        playlist.addSong(albums, "This Boy");
        playlist.addSong(albums, "The Crystal Ship");
        playlist.addSong(albums, "It Won't Be Long");

        //playlist.printPlayList();

        menu();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        int action;

        ListIterator<Song> playListIterator = playlist.getPlaylist().listIterator();


        while (!quit) {
            action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0: // - Quit,
                    quit = true;
                    break;
                case 1: // - Skip forward to the next song,
                    if (!goingForward) {
                             if (playListIterator.hasNext()) {
                                 playListIterator.next();
                             }
                             goingForward = true;
                    }

                    System.out.println("Next song");
                    if (playListIterator.hasNext()) {
                        System.out.println("Now playing " + playListIterator.next().getTitle());
                    } else {
                        System.out.println("End of playlist");
                        goingForward = false;
                    }

                    break;
                case 2: // - skip backwards to a previous song.
                    if (goingForward) {
                        if (playListIterator.hasPrevious()) {
                            playListIterator.previous();
                        }
                        goingForward = false;
                    }
                    System.out.println("Previous song");
                    if (playListIterator.hasPrevious()) {
                        System.out.println("Now playing " + playListIterator.previous().getTitle());
                    } else {
                        System.out.println("Beginning of playlist");
                        goingForward = true;
                    }
                    break;
                case 3: // - Replay the current song.
                    System.out.println("Replay the current song");

                    if (goingForward) {
                        if (playListIterator.hasPrevious()) {
                            System.out.println("Now playing " + playListIterator.previous().getTitle());
                        } else {
                            System.out.println("Beginning of playlist");
                        }
                    } else {
                        System.out.println("Now playing " + playListIterator.next().getTitle());
                        if (playListIterator.hasNext()) {

                        } else {
                            System.out.println("End of playlist");
                        }
                    }
                    goingForward = ! goingForward;

                    break;
                case 4: // - List the songs in the playlist
                    System.out.println("List the songs in the playlist");
                    playlist.printPlayList();
                    break;
                case 5:  // - Menu
                    menu();
                    break;
                default:
                    System.out.println("Press 5 for a menu of commands");
            } //switch (action)

        } // while (!quit)
    } // psv Main

    public static void menu() {
        System.out.println("Playlist menu");
        System.out.println("0 - Quit");
        System.out.println("1 - Skip forward");
        System.out.println("2 - Skip back");
        System.out.println("3 - Replay");
        System.out.println("4 - List songs");
        System.out.println("5 - Menu");
        System.out.println();
    }
} // Class Main
