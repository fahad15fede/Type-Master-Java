package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SoloStatsController {

    Details details = new Details();

    @FXML
    private Label accuracy;

    @FXML
    private Label wpm;

    @FXML
    public void initialize() {
        wpm.setText(String.valueOf((int) details.getWpm()));
        accuracy.setText(String.valueOf(details.getAccuracy()) + " % ");
    }

}