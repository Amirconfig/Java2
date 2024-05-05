package assignment;

import java.util.Date;

public class Song implements Comparable<Song> {
    private String songTitle;
    private String songArtist;
    private String songAlbum;
    private Date songReleaseDate;
    private String songGenre;
    private String songLength;
    private String songWriters;
    private String songProducers;
    private String songAwards;
    private static int id = 0;
    private int songID;

    public Song() {
        id += 1;
        this.songID = id;
    }

    public Song(String title, String artist, String album,
                Date releaseDate, String genre, String length,
                String writers, String producers, String awards) {
        this.songTitle = title;
        this.songArtist = artist;
        this.songAlbum = album;
        this.songReleaseDate = releaseDate;
        this.songGenre = genre;
        this.songLength = length;
        this.songWriters = writers;
        this.songProducers = producers;
        this.songAwards = awards;
        id += 1;
        this.songID = id;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public String getSongAlbum() {
        return songAlbum;
    }

    public void setSongAlbum(String songAlbum) {
        this.songAlbum = songAlbum;
    }

    public Date getSongReleaseDate() {
        return songReleaseDate;
    }

    public void setSongReleaseDate(Date songReleaseDate) {
        this.songReleaseDate = songReleaseDate;
    }

    public String getSongGenre() {
        return songGenre;
    }

    public void setSongGenre(String songGenre) {
        this.songGenre = songGenre;
    }

    public String getSongLength() {
        return songLength;
    }

    public void setSongLength(String songLength) {
        this.songLength = songLength;
    }

    public String getSongWriters() {
        return songWriters;
    }

    public void setSongWriters(String songWriters) {
        this.songWriters = songWriters;
    }

    public String getSongProducers() {
        return songProducers;
    }

    public void setSongProducers(String songProducers) {
        this.songProducers = songProducers;
    }

    public String getSongAwards() {
        return songAwards;
    }

    public void setSongAwards(String songAwards) {
        this.songAwards = songAwards;
    }

    public int getSongID() {
        return this.songID;
    }
    public String toString() {
        return String.format("""
                        Title: %s
                        Artist: %s
                        Album: %s
                        Release Date: %s
                        Genre: %s
                        Length: %s
                        Writers: %s
                        Producers: %s
                        Awards: %s
                        """, this.songTitle,
                this.songArtist, this.songAlbum, this.songReleaseDate,
                this.songGenre, this.songLength,
                this.songWriters, this.songProducers, this.songAwards);
    }

    @Override
    public int compareTo(Song song) {
        return this.songTitle.compareTo(song.songTitle);
    }
}
