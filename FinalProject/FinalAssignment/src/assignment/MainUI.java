package assignment;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.*;
import javafx.scene.text.*;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Optional;

public class MainUI extends Application {
    private SongList songList;
    private ComboBox genreList;
    ObservableList<String> songs =FXCollections.observableArrayList();
    ListView<String> songNames = new ListView<>();
    TextField songName = new TextField();
    TextField artistName = new TextField();
    TextField genreName = new TextField();
    TextField albumName = new TextField();
    TextField releaseDate = new TextField();
    TextField producers = new TextField();
    TextField songLength = new TextField();
    TextField writers = new TextField();
    TextField awards = new TextField();
    GridPane grid = new GridPane();

    @Override
    public void start(Stage primaryStage) throws Exception{
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

        Scene scene = new Scene(grid, 600, 400);
        primaryStage.setTitle("Beat Browser");
        primaryStage.setScene(scene);
        // primaryStage.setMaxHeight(400);
        // primaryStage.setMinHeight(400);
        // primaryStage.setMaxWidth(600);
        // primaryStage.setMaxWidth(600);

        StackPane titlePane = new StackPane();
        Text sceneTitle = new Text("Beat Browser");
        sceneTitle.prefWidth(200);
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        sceneTitle.setTextAlignment(TextAlignment.CENTER);
        titlePane.getChildren().add(sceneTitle);
        StackPane.setAlignment(sceneTitle, Pos.CENTER);
        ImageView titleImage = new ImageView(new File("images/logo2.png").toURI().toString());
        grid.add(titleImage, 3, 0, 2, 1);
        grid.add(titlePane, 4, 0, 3, 1);

        this.songList = new SongList();
        songList.loadFromFile("data.dat");

        displayGenres();

        ScrollPane sp = new ScrollPane();
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setPadding(new Insets(5, 5, 5, 5));
        sp.setContent(grid2);
        grid.add(sp, 5, 2, 3, 3);

        Label songNameLabel = new Label("Song Name: ");
        Label artistNameLabel = new Label("Artist Name: ");
        Label genreNameLabel = new Label("Genre: ");
        Label albumNameLabel = new Label("Album: ");
        Label releaseDateLabel = new Label("Release Date: ");
        Label producersLabel = new Label("Producers: ");
        Label songLengthLabel = new Label("Length: ");
        Label writersLabel = new Label("Writers: ");
        Label awardsLabel = new Label("Awards: ");

        songName.setPrefWidth(200);
        artistName.setPrefWidth(200);
        genreName.setPrefWidth(200);
        albumName.setPrefWidth(200);
        releaseDate.setPrefWidth(200);
        producers.setPrefWidth(200);
        songLength.setPrefWidth(200);
        writers.setPrefWidth(200);
        awards.setPrefWidth(200);


        grid2.add(songName, 4, 2, 2, 1);
        grid2.add(artistName, 4, 3, 2, 1);
        grid2.add(genreName, 4, 4, 2, 1);
        grid2.add(albumName, 4, 5, 2, 1);
        grid2.add(releaseDate, 4, 6, 2, 1);
        grid2.add(producers, 4, 7, 2, 1);
        grid2.add(songLength, 4, 8, 2, 1);
        grid2.add(writers, 4, 9, 2, 1);
        grid2.add(awards, 4, 10, 2, 1);


        grid2.add(songNameLabel, 3, 2, 1, 1);
        grid2.add(artistNameLabel, 3, 3, 1, 1);
        grid2.add(genreNameLabel, 3, 4, 1, 1);
        grid2.add(albumNameLabel, 3, 5, 1, 1);
        grid2.add(releaseDateLabel, 3, 6, 1, 1);
        grid2.add(producersLabel, 3, 7, 1, 1);
        grid2.add(songLengthLabel, 3, 8, 1, 1);
        grid2.add(writersLabel, 3, 9, 1, 1);
        grid2.add(awardsLabel, 3, 10, 1, 1);

        Label listOfSongsLabel = new Label("List of Songs: ");
        grid.add(listOfSongsLabel, 0, 3, 2, 1);
        displaySongList(true);

        Button addNew = new Button("Add New", new ImageView(new File("images/add.png").toURI().toString()));
        ((ImageView) addNew.getGraphic()).setFitWidth(20); // set the width to 20 pixels
        ((ImageView) addNew.getGraphic()).setFitHeight(20); // set the height to 20 pixels
        
        Button edit = new Button("Edit", new ImageView(new File("images/edit.png").toURI().toString()));
        ((ImageView) edit.getGraphic()).setFitWidth(20); // set the width to 20 pixels
        ((ImageView) edit.getGraphic()).setFitHeight(20); // set the height to 20 pixels
        
        Button save = new Button("Save", new ImageView(new File("images/save.png").toURI().toString()));
        ((ImageView) save.getGraphic()).setFitWidth(20); // set the width to 20 pixels
        ((ImageView) save.getGraphic()).setFitHeight(20); // set the height to 20 pixels
        
        Button delete = new Button("Delete", new ImageView(new File("images/delete.png").toURI().toString()));
        ((ImageView) delete.getGraphic()).setFitWidth(20); // set the width to 20 pixels
        ((ImageView) delete.getGraphic()).setFitHeight(20); // set the height to 20 pixels
        
        Button search = new Button("Search", new ImageView(new File("images/search.png").toURI().toString()));
        ((ImageView) search.getGraphic()).setFitWidth(20); // set the width to 20 pixels
        ((ImageView) search.getGraphic()).setFitHeight(20); // set the height to 20 pixels
        
        Button exit = new Button("Exit", new ImageView(new File("images/exit.png").toURI().toString()));
        ((ImageView) exit.getGraphic()).setFitWidth(20); // set the width to 20 pixels
        ((ImageView) exit.getGraphic()).setFitHeight(20); // set the height to 20 pixels
    
        
        addNew.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
        edit.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
        save.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
        delete.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
        search.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));
        exit.setFont(Font.font("Tahoma", FontWeight.BOLD, 10));

        addNew.setPrefWidth(100);
        edit.setPrefWidth(100);
        save.setPrefWidth(100);
        delete.setPrefWidth(100);
        search.setPrefWidth(100);
        exit.setPrefWidth(100);

        grid.add(addNew, 5, 5, 1, 1);
        grid.add(edit, 6, 5, 1, 1);
        grid.add(save, 7, 5, 1, 1);
        grid.add(delete, 5, 6, 1, 1);
        grid.add(search, 6, 6, 1, 1);
        grid.add(exit, 7, 6, 1, 1);

        songNames.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                displaySongDetails();
            }
        });

        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                deleteSong();
            }
        });
        addNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addSong();
            }
        });
        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                editSong();
            }
        });
        exit.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // save the current songList into the file
                songList.writeToFile("data.dat");
            }
        });
        search.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                searchSong();
            }
        });
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void displaySongList(boolean initial) {
        if (initial) {
            for (int i = 0; i < songList.size(); i++) {
                songs.add(songList.get(i).getSongTitle());
            }
            songNames.setItems(songs);
            songNames.setPrefWidth(400);
            songNames.setPrefHeight(130);
            grid.add(songNames, 0, 4, 5, 3);
        } else {
            String selectedGenre = genreList.getSelectionModel().getSelectedItem().toString();
            SongList songsByGenre = songList.findSongsByGenre(selectedGenre);
            songs.clear();
            for (int i = 0; i < songsByGenre.size(); i++) {
                songs.add(songsByGenre.get(i).getSongTitle());
            }
        }
        songNames.getSelectionModel().select(0);
        displaySongDetails();
    }

    public void displaySongDetails() {
        // display the details of the current song
        String selectedSong = songNames.getSelectionModel().getSelectedItem();
        SongList songsByTitle = songList.findSongsByTitle(selectedSong);
        if (songsByTitle.size() > 0) {
            Song song = songsByTitle.get(0);
            songName.setText(song.getSongTitle());
            artistName.setText(song.getSongArtist());
            albumName.setText(song.getSongAlbum());
            String[] dateComponents = song.getSongReleaseDate().toString().split(" ");
            String dateYear = dateComponents[dateComponents.length - 1];
            releaseDate.setText(dateYear);
            genreName.setText(song.getSongGenre());
            writers.setText(song.getSongWriters());
            producers.setText(song.getSongProducers());
            awards.setText(song.getSongAwards());
            songLength.setText(song.getSongLength());
        }
    }

    public void displayGenres() {
        ArrayList<String> genres = new ArrayList<>();
        for (int i = 0; i < songList.size(); i++) {
            if (!genres.contains(songList.get(i).getSongGenre())) {
                genres.add(songList.get(i).getSongGenre());
            }
        }
        // Create a combo box
        Label genreLabel = new Label("Genre");
        genreList = new ComboBox(FXCollections.observableArrayList(genres));
        genreList.setPrefWidth(320);
        grid.add(genreLabel, 0, 2, 1, 1);
        grid.add(genreList, 1, 2, 4, 1);

        genreList.setOnAction((e) -> {
            displaySongList(false);
        });
    }

    public void addSong() {
        String name = songName.getText();
        String artist = artistName.getText();
        String album = albumName.getText();
        String date = releaseDate.getText();
        String genre = genreName.getText();
        String length = songLength.getText();
        String writer = writers.getText();
        String producer = producers.getText();
        String award = awards.getText();

        try {
            Song newSong = new Song();
            newSong.setSongAlbum(album);
            newSong.setSongTitle(name);
            newSong.setSongArtist(artist);
            String[] dateComponents = date.split(" ");
            String dateYear = dateComponents[dateComponents.length - 1];
            newSong.setSongReleaseDate(new SimpleDateFormat("yyyy").parse(dateYear));
            newSong.setSongGenre(genre);
            newSong.setSongLength(length);
            newSong.setSongWriters(writer);
            newSong.setSongProducers(producer);
            newSong.setSongAwards(award);
            // check if a song already exists with exact info
            SongList songsTitle = songList.findSongsByTitle(name);
            boolean doesExist = false;
            for (int i = 0; i < songsTitle.size(); i++) {
                if (songsTitle.get(i).getSongArtist().equals(artist) &&
                        songsTitle.get(i).getSongAlbum().equals(album)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error adding new song");
                    alert.setContentText("The specified song already exist in the database!");
                    doesExist = true;
                    alert.showAndWait();
                }
            }
            if (!doesExist) {
                songList.addSong(newSong);
                songs.add(name);
                displayGenres();
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void editSong() {
        String name = songName.getText();
        String artist = artistName.getText();
        String album = albumName.getText();
        String date = releaseDate.getText();
        String genre = genreName.getText();
        String length = songLength.getText();
        String writer = writers.getText();
        String producer = producers.getText();
        String award = awards.getText();
        String selectedSongName = songNames.getSelectionModel().getSelectedItem();
        Song selectedSong = songList.findSongsByTitle(selectedSongName).get(0);

        try {
            Song newSong = new Song();
            newSong.setSongAlbum(album);
            newSong.setSongTitle(name);
            newSong.setSongArtist(artist);
            String[] dateComponents = date.split(" ");
            String dateYear = dateComponents[dateComponents.length - 1];
            newSong.setSongReleaseDate(new SimpleDateFormat("yyyy").parse(dateYear));
            newSong.setSongGenre(genre);
            newSong.setSongLength(length);
            newSong.setSongWriters(writer);
            newSong.setSongProducers(producer);
            newSong.setSongAwards(award);


            songList.addSong(newSong);
            songList.deleteSong(selectedSong);
            songs.add(name);
            songs.remove(selectedSongName);

            displayGenres();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteSong() {
        // show confirmation for delete event
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Delete");
        alert.setHeaderText("This operation will delete the entry from the database.");
        alert.setContentText("Are you sure you want to do this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            String name = songName.getText();

            // now get the song object with this info,
            // from the songList
            SongList songByTitle = songList.findSongsByTitle(name);
            if (songByTitle.size() > 0) {
                Song song = songByTitle.get(0);
                // delete this song from the list
                songList.deleteSong(song);
                // remove song from observable array
                songs.remove(name);
                // select the first element in list view
                songNames.getSelectionModel().select(0);
                // set all the fields to empty
                songName.setText("");
                artistName.setText("");
                albumName.setText("");
                releaseDate.setText("");
                genreName.setText("");
                writers.setText("");
                producers.setText("");
                awards.setText("");
            }
        }
    }

    public void searchSong() {
        GridPane searchGrid = new GridPane();
        searchGrid.setAlignment(Pos.CENTER);
        searchGrid.setHgap(10);
        searchGrid.setVgap(10);
        searchGrid.setPadding(new Insets(25, 25, 25, 25));
        searchGrid.setPadding(new Insets(25, 25, 25, 25));

        Stage stage = new Stage();
        stage.setTitle("Search Songs");
        Scene scene = new Scene(searchGrid, 300, 300);
        stage.setScene(scene);
        StackPane titlePane = new StackPane();
        Text sceneTitle = new Text("Search Songs");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        sceneTitle.setTextAlignment(TextAlignment.CENTER);
        titlePane.getChildren().add(sceneTitle);
        StackPane.setAlignment(sceneTitle, Pos.CENTER);
        searchGrid.add(titlePane, 0, 0, 3, 1);

        Label searchByLabel = new Label("Search By: ");
        searchByLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        searchGrid.add(searchByLabel, 0, 1, 1, 1);

        // add radio button for search categories
        ToggleGroup group = new ToggleGroup();
        RadioButton rbName = new RadioButton("Name");
        rbName.setToggleGroup(group);
        rbName.setSelected(true);
        RadioButton rbGenre = new RadioButton("Genre");
        rbGenre.setToggleGroup(group);
        RadioButton rbArtist = new RadioButton("Artist");
        rbArtist.setToggleGroup(group);
        searchGrid.add(rbName, 0, 2, 1, 1);
        searchGrid.add(rbGenre, 1, 2, 1, 1);
        searchGrid.add(rbArtist, 2, 2, 1, 1);

        TextField searchValue = new TextField();
        searchGrid.add(searchValue, 0, 3, 2, 1);
        Button searchButton = new Button("Search", new ImageView(new File("images/search.png").toURI().toString()));
        ((ImageView) searchButton.getGraphic()).setFitWidth(20); // set the width to 20 pixels
        ((ImageView) searchButton.getGraphic()).setFitHeight(20); // set the height to 20 pixels
        searchGrid.add(searchButton, 2, 3, 1, 1);
        ListView<String> searchResults = new ListView<>();
        searchGrid.add(searchResults, 0, 4, 3, 1);
        Label searchStatus = new Label("");
        // error statuses will be displayed here
        searchGrid.add(searchStatus, 0, 5, 3, 1);
        stage.show();

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // reset the search results
                if (searchValue.getText().isBlank()) {
                    searchStatus.setText("Please enter a search value!");
                } else {
                    SongList songResults = new SongList();
                    RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
                    String searchByAttribute = selectedRadioButton.getText();
                    ObservableList<String> searchSongs =FXCollections.observableArrayList();
                    if (searchByAttribute.equals("Name")) {
                        songResults = songList.findSongsByTitle(searchValue.getText());
                    } else if (searchByAttribute.equals("Genre")) {
                        songResults = songList.findSongsByGenre(searchValue.getText());
                    } else if (searchByAttribute.equals("Artist")) {
                        songResults = songList.findSongsByArtist(searchValue.getText());
                    }
                    if (songResults.size() == 0) {
                        // no results
                        searchStatus.setText("No results round!");
                    } else {
                        searchStatus.setText(String.format("Found %d results.", songResults.size()));
                    }
                    for (int i = 0; i < songResults.size(); i++) {
                        searchSongs.add(songResults.get(i).getSongTitle());
                    }
                    searchResults.setItems(searchSongs);
                }
            }
        });
    }
}