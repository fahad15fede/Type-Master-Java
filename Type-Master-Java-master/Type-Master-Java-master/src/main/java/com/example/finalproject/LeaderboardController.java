package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LeaderboardController {

    @FXML
    private Label p1Acc;

    @FXML
    private Label p1Wpm;

    @FXML
    private Label p2Acc;

    @FXML
    private Label p2Wpm;

    @FXML
    private Label p3Acc;

    @FXML
    private Label p3Wpm;

    @FXML
    private Label player1;

    @FXML
    private Label player2;

    @FXML
    private Label player3;

    Player1 p1 = new Player1();
    Player2 p2 = new Player2();
    Player3 p3 = new Player3();


    @FXML
    public void initialize() {
        showDetails();
    }

    public void showDetails() {
        p1.setAccuracy();
        p2.setAccuracy();
        p3.setAccuracy();

        if(p1.getAccuracy() > p2.getAccuracy() && p2.getAccuracy() > p3.getAccuracy()) {
            p1Acc.setText(String.format("%.2f",p1.getAccuracy()));
            p2Acc.setText(String.format("%.2f",p2.getAccuracy()));
            p3Acc.setText(String.format("%.2f", p3.getAccuracy()));
            p1Wpm.setText(String.format("%.2f",p1.getWpm()));
            p2Wpm.setText(String.format("%.2f",p2.getWpm()));
            p3Wpm.setText(String.format("%.2f",p3.getWpm()));
            player1.setText("Player 1");
            player2.setText("Player 2");
            player3.setText("Player 3");
        }

        if(p2.getAccuracy() > p1.getAccuracy() && p1.getAccuracy() > p3.getAccuracy()) {
            p1Acc.setText(String.format("%.2f",p2.getAccuracy()));
            p2Acc.setText(String.format("%.2f",p1.getAccuracy()));
            p3Acc.setText(String.format("%.2f",p3.getAccuracy()));
            p1Wpm.setText(String.format("%.2f",p2.getWpm()));
            p2Wpm.setText(String.format("%.2f",p1.getWpm()));
            p3Wpm.setText(String.format("%.2f",p3.getWpm()));
            player1.setText("Player 2");
            player2.setText("Player 1");
            player3.setText("Player 3");
        }

        if(p3.getAccuracy() > p2.getAccuracy() && p2.getAccuracy() > p1.getAccuracy()) {
            p1Acc.setText(String.format("%.2f",p3.getAccuracy()));
            p2Acc.setText(String.format("%.2f",p2.getAccuracy()));
            p3Acc.setText(String.format("%.2f",p1.getAccuracy()));
            p1Wpm.setText(String.format("%.2f",p3.getWpm()));
            p2Wpm.setText(String.format("%.2f",p2.getWpm()));
            p3Wpm.setText(String.format("%.2f",p1.getWpm()));
            player1.setText("Player 3");
            player2.setText("Player 2");
            player3.setText("Player 1");
        }
    }

}
