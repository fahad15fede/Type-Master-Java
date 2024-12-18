package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class SoloStatsController {

    @FXML
    private Label accuracy;

    @FXML
    private Label wpm;
    @FXML
            private Button restart;

    Player1 player1 = new Player1();

    @FXML
    public void initialize() {
        wpm.setText(String.format("%.2f", player1.getWpm()));
        accuracy.setText(String.format("%.2f", player1.getAccuracy()));
    }
    @FXML
    void restart(ActionEvent event) throws IOException {
        MainController.i=0;
        Details.timetaken1=0;
        Details.timetaken2=0;
        Details.timetaken3=0;
        Player1.errorCount = 0;
        Player1.characterCount = 0;
        Player2.errorCount = 0;
        Player2.characterCount = 0;
        Player3.errorCount = 0;
        Player3.characterCount = 0;
        Parent root  = FXMLLoader.load(getClass().getResource("modes.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

