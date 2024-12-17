package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SoloStatsController {

    @FXML
    private Label accuracy;

    @FXML
    private Label wpm;

    Player1 player1 = new Player1();

    @FXML
    public void initialize() {
        wpm.setText(String.format("%.2f", player1.getWpm()));
        accuracy.setText(String.format("%.2f", player1.getAccuracy()));
    }

}