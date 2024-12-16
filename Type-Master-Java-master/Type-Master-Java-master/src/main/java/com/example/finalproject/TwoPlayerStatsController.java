package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TwoPlayerStatsController {

    Details details = new Details();

    @FXML
    private Label p1Acc;

    @FXML
    private Label p1Wpm;

    @FXML
    private Label p2Acc;

    @FXML
    private Label p2Wpm;

    @FXML
    private Label player1;

    @FXML
    private Label player2;

    Player1 p1 = new Player1();
    Player2 p2 = new Player2();

    @FXML
    public void initialize() {
//        p1Wpm.setText(String.valueOf(p2.getAccuracy()));
//        p1Wpm.setText(String.valueOf(p2.getWpm1()));
        showDetails();


    }

    public void showDetails() {
        p1.setAccuracy();
        p2.setAccuracy();

        if(p1.getAccuracy() > p2.getAccuracy()) {
            p1Acc.setText(String.format("%.2f",p1.getAccuracy()));
            p2Acc.setText(String.format("%.2f",p2.getAccuracy()));
            p1Wpm.setText(String.format("%.2f",p1.getWpm()));
            p2Wpm.setText(String.format("%.2f",p2.getWpm()));
            player1.setText("Player 1");
            player2.setText("Player 2");
        }


        if(p1.getAccuracy() < p2.getAccuracy()) {
            p1Acc.setText(String.format("%.2f",p2.getAccuracy()));
            p2Acc.setText(String.format("%.2f",p1.getAccuracy()));
            p1Wpm.setText(String.format("%.2f",p2.getWpm()));
            p2Wpm.setText(String.format("%.2f",p1.getWpm()));
            player2.setText("Player 1");
            player1.setText("Player 2");
        }

    }

}
