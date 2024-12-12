package com.example.finalproject;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.io.IOException;


public class MainController {

    WordGenerator wordGenerator = new WordGenerator();
    private int secondsLeft = 60;
    private boolean timerRunning = false;
    @FXML
    private Button btn;

    @FXML
    private Label totalErrors;

    @FXML
    private Label totalChar;

    @FXML
    private Label givenSentence;

    @FXML
    private Label timer;

    @FXML
    private TextField userInput;

    @FXML
    private Label turn;


       public static int i = 0 ;
    @FXML
    public void initialize() {
        turn.setText("Player1");
        givenSentence.setText(" " + wordGenerator.levels3[0]);
        totalChar.setText(Integer.toString(Player1.characterCount));
        totalErrors.setText(Integer.toString(Player1.errorCount));
    }


        public Details details;
    @FXML
    void onNext(ActionEvent event)  {


        if(Details.userChoice == 1) {
            if (i < 7) {
                String user_type = userInput.getText();
                details = new Details( wordGenerator.levels3[i] ,user_type );
                totalChar.setText(Integer.toString(Player1.characterCount));
                totalErrors.setText(Integer.toString(Player1.errorCount));
                if( i == 6 ){
                    givenSentence.setText(" " + wordGenerator.levels3[i]);
                    btn.setVisible(false);
                }else{
                    givenSentence.setText(" " + wordGenerator.levels3[i+1]);

                }

                userInput.setText("");
                i += 1;
            }
        }

        if(Details.userChoice == 2) {
            if (i < 14) {

                String user_type = userInput.getText();
                details = new Details( wordGenerator.levels3[i] ,user_type );
                if( i == 13 ){
                    givenSentence.setText(" " + wordGenerator.levels3[i]);
                    btn.setVisible(false);
                }else{
                    givenSentence.setText(" " + wordGenerator.levels3[i+1]);
                }
                if (i == 6) stopTimer();
                if(i < 7){
                    turn.setText("Player 1");
                    totalChar.setText(Integer.toString(Player1.characterCount));
                    totalErrors.setText(Integer.toString(Player1.errorCount));
                }

                if ( i >= 6 && i < 14){

                    turn.setText("Player 2");
                    totalChar.setText(Integer.toString(Player2.characterCount));
                    totalErrors.setText(Integer.toString(Player2.errorCount));
                }
                userInput.setText("");
                i+=1;
            }


        }
        if(Details.userChoice == 3) {
            if (i < 21) {

                String user_type = userInput.getText();
                details = new Details( wordGenerator.levels3[i] ,user_type );
                if( i == 20 ){
                    givenSentence.setText(" " + wordGenerator.levels3[i]);
                    btn.setVisible(false);
                }
                else {
                    givenSentence.setText(" " + wordGenerator.levels3[i + 1]);
                }
                if (i == 6) stopTimer();
                if (i == 13) stopTimer();
            if(i < 7){

                turn.setText("Player 1");
                totalChar.setText(Integer.toString(Player1.characterCount));
                totalErrors.setText(Integer.toString(Player1.errorCount));
            }
            if ( i >= 6 && i < 14){

                turn.setText("Player 2");
                totalChar.setText(Integer.toString(Player2.characterCount));
                totalErrors.setText(Integer.toString(Player2.errorCount));
            }
            if (i >= 13 && i < 21){

                turn.setText("Player 3");
                totalChar.setText(Integer.toString(Player3.characterCount));
                totalErrors.setText(Integer.toString(Player3.errorCount));
            }
            userInput.setText("");
            i += 1;
            }
        }
    }

    @FXML
    void keyTyped(KeyEvent event) {
        if (!timerRunning) {
            startTimer();
        }
//        if (Details.userChoice == 2){
//            if(i == 7){
//                startTimer();
//            }
//        }
    }

    private Timeline timeline;
    @FXML
    private void startTimer() {
        timerRunning = true;
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    try {
                        updateTimer();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateTimer() throws IOException {
        if (secondsLeft > 0) {
            timer.setText(String.valueOf(secondsLeft));
            secondsLeft--;
        } else if (secondsLeft == 0) {
            userInput.setEditable(false);
            timer.setText("0");
            btn.setVisible(false);
        }
    }
    private void stopTimer() {
        if (timeline != null) {
            timeline.stop();
            timerRunning = false;
            secondsLeft = 60;
        }
    }
}