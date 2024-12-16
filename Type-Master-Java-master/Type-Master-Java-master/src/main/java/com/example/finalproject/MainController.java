package com.example.finalproject;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Arrays;


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
    private Label turn;


    @FXML
    private Button result;


    public static int i = 0;

    @FXML
    public void initialize() {
        turn.setText("Player1");
        givenSentence.setText(wordGenerator.levels3[0]);
        totalChar.setText(Integer.toString(Details.characterCount1));
        totalErrors.setText(Integer.toString(Details.errorCountp1));
        result.setVisible(false);
        userInput.textProperty().addListener((observable, oldValue, newValue) -> {
            // Check if the new value starts with a space
            if (newValue.startsWith(" ")) {
                // Remove the leading space
                userInput.setText(newValue.trim());
            }
        });
//        String user_type = userInput.getText();
    }



    @FXML
    void showResult(ActionEvent event) throws IOException {
        if(Details.userChoice == 1) {
            Parent root = FXMLLoader.load(getClass().getResource("solo-stats.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (Details.userChoice == 2) {
            new Player1().setAccuracy();
            new Player2().setAccuracy();
            details.setWpm();
//            showResult();
            Parent root = FXMLLoader.load(getClass().getResource("two-player-stats.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

        if(Details.userChoice == 3) {
            Parent root = FXMLLoader.load(getClass().getResource("leaderBoard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

//    String[] inputArr = new String[99999];

    public Details details;

    @FXML
    void onNext(ActionEvent event) {



        if(!userInput.getText().isEmpty() && userInput.getText().length() <= givenSentence.getText().length()) {

            if (Details.userChoice == 1) {
                if (i < 7 ) {
                    String user_type = userInput.getText();


                    if (userInput.getText().length() > givenSentence.getText().length()) {
                        turn.setText(String.valueOf(givenSentence.getText().length()));
                        userInput.setText("");
                        user_type = userInput.getText();

                    } else {

                        userInput.textProperty().addListener((observable, oldValue, newValue) -> {
                            // Check if the new value starts with a space
                            if (newValue.startsWith(" ")) {
                                // Remove the leading space
                                userInput.setText(newValue.trim());
                            }
                        });

                        details = new Details(wordGenerator.levels3[i], user_type);
                        totalChar.setText(Integer.toString(Player1.characterCount));
                        totalErrors.setText(Integer.toString(Player1.errorCount));
//                details.setWpm(user_type);
                        if (i == 6) {
                            givenSentence.setText(wordGenerator.levels3[i]);
                            stopTimer();
                            double time = Double.valueOf(timer.getText());
                            details.setTimetaken1(120 - time);
                            btn.setVisible(false);
                            result.setVisible(true);
//                    result.setText(String.valueOf(details.getTimetaken1()));
                            userInput.setEditable(false);
                            details.setAccuracy();

                        } else {
                            givenSentence.setText(wordGenerator.levels3[i + 1]);
                        }

                        userInput.setText("");
                        i += 1;


                    }

                }

            }


            if (Details.userChoice == 2) {
                if (i < 14) {

                    String user_type = userInput.getText();
                    details = new Details(wordGenerator.levels3[i], user_type);
                    if (i == 13) {
                        givenSentence.setText(wordGenerator.levels3[i]);
                        btn.setVisible(false);
                        result.setVisible(true);
                        stopTimer();
                        userInput.setEditable(false);
                        details.setAccuracy();
                        double time = Double.valueOf(timer.getText());
                        details.setTimetaken2(120 - time);

                    } else {
                        givenSentence.setText(wordGenerator.levels3[i + 1]);
                    }

                    if (i == 6) {
                        double time = Double.valueOf(timer.getText());
                        details.setTimetaken1(120 - time);
                        stopTimer();
                        details.setAccuracy();
                    }

                    if (i < 7) {
                        turn.setText("Player 1");
                        totalChar.setText(Integer.toString(Player1.characterCount));
                        totalErrors.setText(Integer.toString(Player1.errorCount));
                    }

                    if (i >= 6 && i < 14) {
                        double time = Double.valueOf(timer.getText());
                        turn.setText("Player 2");
                        totalChar.setText(Integer.toString(Player2.characterCount));
                        totalErrors.setText(Integer.toString(Player2.errorCount));
                    }

                    userInput.setText("");
                    i++;
                }
            }



                if (Details.userChoice == 3) {
                    if (i < 21) {

                        String user_type = userInput.getText();
                        details = new Details(wordGenerator.levels3[i], user_type);
                        if (i == 20) {
                            givenSentence.setText(wordGenerator.levels3[i]);
                            btn.setVisible(false);
                            result.setVisible(true);
                            stopTimer();
                            userInput.setEditable(false);
                            details.setAccuracy();
                            double time = Double.valueOf(timer.getText());
                            details.setTimetaken3(120 - time);

                        } else {
                            givenSentence.setText(wordGenerator.levels3[i + 1]);
                        }
                        if (i == 6) {
                            double time = Double.valueOf(timer.getText());
                            details.setTimetaken1(120 - time);
                            stopTimer();
                            details.setAccuracy();
                        }

                        if (i == 13) {
                            stopTimer();
                            details.setAccuracy();
                            double time = Double.valueOf(timer.getText());
                            details.setTimetaken2(120 - time);
                        }

                        if (i < 7) {

                            turn.setText("Player 1");
                            totalChar.setText(Integer.toString(Player1.characterCount));
                            totalErrors.setText(Integer.toString(Player1.errorCount));
                        }
                        if (i >= 6 && i < 14) {

                            turn.setText("Player 2");
                            totalChar.setText(Integer.toString(Player2.characterCount));
                            totalErrors.setText(Integer.toString(Player2.errorCount));
                        }
                        if (i >= 13 && i < 21) {

                            turn.setText("Player 3");
                            totalChar.setText(Integer.toString(Player3.characterCount));
                            totalErrors.setText(Integer.toString(Player3.errorCount));
                        }
                        userInput.setText("");
                        i += 1;
                    }
                }

        }

    }

        @FXML
        void keyTyped (KeyEvent event){
            if (!timerRunning) {
                startTimer();
            }
        }

        Timeline timeline;

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
        private void stopTimer () {
            if (timeline != null) {
                timeline.stop();
                timerRunning = false;
                secondsLeft = 120;
            }
        }
}