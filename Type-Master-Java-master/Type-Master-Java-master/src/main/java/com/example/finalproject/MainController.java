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


    @FXML
    public void initialize() {
        turn.setText("Player1");
        givenSentence.setText(" " + wordGenerator.levels1[0]);
        totalChar.setText(Integer.toString(Details.characterCount1));
        totalErrors.setText(Integer.toString(Details.errorCountp1));
    }


       public static int i = 0 ;
        public Details details;
    @FXML
    void onNext(ActionEvent event)  {
//         int k = new Details().getUserChoice();


        if(Details.userChoice == 1) {

            totalChar.setText(Integer.toString(Details.characterCount1));
            totalErrors.setText(Integer.toString(Details.errorCountp1));
            if (i < 7) {
                String user_type = userInput.getText();
                details = new Details( wordGenerator.levels1[i] ,user_type );
                totalChar.setText(Integer.toString(Details.characterCount1));
                totalErrors.setText(Integer.toString(Details.errorCountp1));
                if( i == 6 ){
                    givenSentence.setText(" " + wordGenerator.levels1[i]);
                    btn.setVisible(false);
                }else{
                    givenSentence.setText(" " + wordGenerator.levels1[i+1]);

                }

                userInput.setText("");
                i += 1;
            }
        }

        if(Details.userChoice == 2) {
            if (i < 14) {

                String user_type = userInput.getText();
                details = new Details( wordGenerator.levels2[i] ,user_type );
                if( i == 13 ){
                    givenSentence.setText(" " + wordGenerator.levels2[i]);
                    btn.setVisible(false);
                }else{
                    givenSentence.setText(" " + wordGenerator.levels2[i+1]);
                }
                if (i == 6) stopTimer();
                if(i < 7){
                    turn.setText("Player 1");
                    totalChar.setText(Integer.toString(Details.characterCount1));
                    totalErrors.setText(Integer.toString(Details.errorCountp1));
                }

                if ( i >= 6 && i < 14){

                    turn.setText("Player 2");
                    totalChar.setText(Integer.toString(Details.characterCount2));
                    totalErrors.setText(Integer.toString(Details.errorCountp2));
                }
                userInput.setText("");
                i+=1;
            }


        }
        if(Details.userChoice == 3) {
            if (i < 21) {

                String user_type = userInput.getText();
                details = new Details( wordGenerator.levels3[i] ,user_type );
                totalChar.setText(Integer.toString(Details.characterCount3));
                totalErrors.setText(Integer.toString(Details.errorCountp3));

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
                totalChar.setText(Integer.toString(Details.characterCount1));
                totalErrors.setText(Integer.toString(Details.errorCountp1));
            }
            if ( i >= 6 && i < 14){

                turn.setText("Player 2");
                totalChar.setText(Integer.toString(Details.characterCount2));
                totalErrors.setText(Integer.toString(Details.errorCountp2));
            }
            if (i >= 13 && i < 21){

                turn.setText("Player 3");
                totalChar.setText(Integer.toString(Details.characterCount3));
                totalErrors.setText(Integer.toString(Details.errorCountp3));
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