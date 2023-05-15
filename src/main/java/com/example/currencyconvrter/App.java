package com.example.currencyconvrter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        Loading our FXML
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
//        Adding that FXML to SCENE
        Scene scene = new Scene(fxmlLoader.load());
//        Setting the title of application
        stage.setTitle("Currency Convertor");
//        adding scene to stage
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}