package com.mbtec.staffnoc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NocStaffApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NocStaffApp.class.getResource("nocstaff.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("STAFFNOC!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}