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
    @FXML
            private Button restart;

    Player1 p1 = new Player1();
    Player2 p2 = new Player2();

    @FXML
    public void initialize() {
        showDetails();


    }

    public void showDetails() {
        p1.setAccuracy();
        p2.setAccuracy();
        p1.setWpm();
        p2.setWpm();

        if(p1.getAccuracy() > p2.getAccuracy()) {
            p1Acc.setText(String.format("%.2f",p1.getAccuracy()));
            p2Acc.setText(String.format("%.2f",p2.getAccuracy()));
            p1Wpm.setText(Double.toString(Math.floor(p1.getWpm())));
            p2Wpm.setText(Double.toString(Math.floor(p2.getWpm())));
            player1.setText("Player 1");
            player2.setText("Player 2");
        }


        if(p1.getAccuracy() < p2.getAccuracy()) {
            p1Acc.setText(String.format("%.2f",p2.getAccuracy()));
            p2Acc.setText(String.format("%.2f",p1.getAccuracy()));
            p1Wpm.setText(Double.toString(Math.floor(p2.getWpm())));
            p2Wpm.setText(Double.toString(Math.floor(p1.getWpm())));
            player2.setText("Player 1");
            player1.setText("Player 2");
        }

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
