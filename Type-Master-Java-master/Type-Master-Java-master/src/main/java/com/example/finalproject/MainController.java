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
    private int secondsLeft = 120;
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
    private Label wordCount;


    @FXML
    public void initialize() {
        givenSentence.setText(" " + wordGenerator.levels1[0]);
        totalChar.setText(Double.toString(Details.characterCount1));
        totalErrors.setText(Double.toString(Details.errorCountp1));
    }


       public static int i = 1 ;
        public Details details;
    @FXML
    void onNext(ActionEvent event)  {
//         int k = new Details().getUserChoice();


        if(Details.userChoice == 1) {
            wordCount.setText("Player1");
            totalChar.setText(Double.toString(Details.characterCount1));
            totalErrors.setText(Double.toString(Details.errorCountp1));
            if (i < 7) {
                String user_type = userInput.getText();
                details = new Details( wordGenerator.levels1[i - 1] ,user_type );
                totalChar.setText(Double.toString(Details.characterCount1));
                totalErrors.setText(Double.toString(Details.errorCountp1));
                givenSentence.setText(" " + wordGenerator.levels1[i]);

                userInput.setText("");
                i += 1;
            }
        }

        if(Details.userChoice == 2) {
            if (i < 14) {
                if(i <= 7){
                    wordCount.setText("Player1");
                    totalChar.setText(Double.toString(Details.characterCount1));
                    totalErrors.setText(Double.toString(Details.errorCountp1));
                }
                if ( i > 7 && i <= 14){
                    wordCount.setText("Player2");

                    totalChar.setText(Double.toString(Details.characterCount2));
                    totalErrors.setText(Double.toString(Details.errorCountp2));
                }

                String user_type = userInput.getText();
                details = new Details( wordGenerator.levels2[i - 1] ,user_type );
                givenSentence.setText(" " + wordGenerator.levels2[i]);

                userInput.setText("");
                i += 1;
            }


        }
        if(Details.userChoice == 3) {
            if(i <= 7){

                totalChar.setText(Double.toString(Details.characterCount1));
                totalErrors.setText(Double.toString(Details.errorCountp1));
            }
            if ( i > 7 && i <= 14){
                totalChar.setText(Double.toString(Details.characterCount2));
                totalErrors.setText(Double.toString(Details.errorCountp2));
            }
            if (i > 14 && i <= 21){
                totalChar.setText(Double.toString(Details.characterCount3));
                totalErrors.setText(Double.toString(Details.errorCountp3));
            }
            if (i < 21) {
                String user_type = userInput.getText();
                details = new Details( wordGenerator.levels3[i - 1] ,user_type );
                totalChar.setText(Double.toString(Details.characterCount3));
                totalErrors.setText(Double.toString(Details.errorCountp3));
                givenSentence.setText(" " + wordGenerator.levels3[i]);

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
    }

    @FXML
    private void startTimer() {
        timerRunning = true;
        Timeline timeline = new Timeline(
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

}