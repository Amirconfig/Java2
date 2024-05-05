package assignment;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SongList {
    private ArrayList<Song> songList;

    public SongList() {
        this.songList = new ArrayList<Song>();
    }

    public SongList(File file) {
        this.loadFromFile(file);
    }

    public SongList(String file) {
        this.loadFromFile(file);
    }

    public Song get(int index) {
        return songList.get(index);
    }

    public void addSong(Song song) {
        songList.add(song);
    }

    public void insert(Song song, int index) {
        songList.add(index, song);
    }

    public void deleteSong(Song song) {
        songList.remove(song);
    }

    public void set(Song song, int index) {
        songList.set(index, song);
    }

    public int indexOf(Song song) {
        return songList.indexOf(song);
    }

    public int size() {
        return songList.size();
    }

    public void clean() {
        songList.clear();
    }

    public void loadFromFile(File file) {
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                String record = sc.nextLine();
                // split the records to generate the required fields:
                // assuming the fields are separated using comma
                String[] fields = record.split(",");
                if (fields.length != 10) {
                    throw new InvalidObjectException("Corrupt database file!");
                }
                Song song = new Song();
                // we are not adding the song id since that will be added by
                // default when each song object is constructed
                song.setSongTitle(fields[1]);
                song.setSongArtist(fields[2]);
                song.setSongAlbum(fields[3]);
                song.setSongReleaseDate(new SimpleDateFormat("dd/MM/yyyy").parse(fields[4]));
                song.setSongLength(fields[5]);
                song.setSongWriters(fields[6]);
                song.setSongWriters(fields[7]);
                song.setSongProducers(fields[8]);
                song.setSongAwards(fields[9]);
                // now add this song to the songList
                songList.add(song);
            }
            sc.close();
        } catch (FileNotFoundException | ParseException | InvalidObjectException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                String record = sc.nextLine();
                // split the records to generate the required fields:
                // assuming the fields are separated using comma
                if (!record.isBlank()) {
                    String[] fields = record.split(",");
                    if (fields.length != 10) {
                        throw new InvalidObjectException("Corrupt database file!");
                    }
                    Song song = new Song();
                    // we are not adding the song id since that will be added by
                    // default when each song object is constructed
                    song.setSongTitle(fields[1].trim());
                    song.setSongArtist(fields[2].trim());
                    song.setSongAlbum(fields[3].trim());
                    song.setSongReleaseDate(new SimpleDateFormat("yyyy").parse(fields[4].trim()));
                    song.setSongGenre(fields[5].trim());
                    song.setSongLength(fields[6].trim());
                    song.setSongWriters(fields[7].trim());
                    song.setSongProducers(fields[8].trim());
                    song.setSongAwards(fields[9].trim());
                    // now add this song to the songList
                    songList.add(song);
                }
            }
        } catch (FileNotFoundException | ParseException | InvalidObjectException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(File file) {
        // write the songList to the file with same format
        // as read.
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Song song: songList) {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dataString = dateFormat.format(song.getSongReleaseDate());
                String record = String.format("%d,%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
                        song.getSongID(), song.getSongTitle(), song.getSongArtist(),
                        song.getSongAlbum(), dataString, song.getSongGenre(), song.getSongLength(),
                        song.getSongWriters(), song.getSongProducers(), song.getSongAwards());
                printWriter.print(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeToFile(String fileName) {
        // write the songList to the file with same format
        // as read.
        try {
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Song song: songList) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy");
                String dataString = dateFormat.format(song.getSongReleaseDate());
                String record = String.format("%d,%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
                        song.getSongID(), song.getSongTitle(), song.getSongArtist(),
                        song.getSongAlbum(), dataString, song.getSongGenre(), song.getSongLength(),
                        song.getSongWriters(), song.getSongProducers(), song.getSongAwards());
                printWriter.print(record);
            }

            fileWriter.close();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public SongList findSongsByTitle(String title) {
        SongList songsByTitle = new SongList();
        for (Song song : songList) {
            if ((song.getSongTitle().equalsIgnoreCase(title)) ||
                    (song.getSongTitle().toLowerCase().contains(title.trim())))
            {
                songsByTitle.addSong(song);
            }
        }
        return songsByTitle;
    }

    public SongList findSongsByArtist(String artist) {
        SongList songsByArtist = new SongList();
        for (Song song: songList) {
            if ((song.getSongArtist().equalsIgnoreCase(artist)) ||
                    (song.getSongArtist().toLowerCase().contains(artist.trim()))) {
                songsByArtist.addSong(song);
            }
        }
        return songsByArtist;
    }

    public SongList findSongsByGenre(String genre) {
        SongList songsByGenre = new SongList();
        for (Song song: songList) {
            if ((song.getSongGenre().equalsIgnoreCase(genre)) ||
                    (song.getSongGenre().toLowerCase().contains(genre.trim()))) {
                songsByGenre.addSong(song);
            }
        }
        return songsByGenre;
    }

    public void sortSongs() {
        Collections.sort(songList);
    }
}
