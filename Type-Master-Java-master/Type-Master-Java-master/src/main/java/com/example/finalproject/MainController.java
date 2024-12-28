package com.example.finalproject;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Arrays;


public class MainController {

    WordGenerator wordGenerator = new WordGenerator();
    private int secondsLeft = 90;
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
    @FXML
    private Button playerTurn;

    public static int i = 0;


    @FXML
    public void initialize() {
        playerTurn.setVisible(false);
        turn.setText("Player1");
        givenSentence.setText(wordGenerator.levels3[0]);
        totalChar.setText(Integer.toString(Player1.characterCount));
        totalErrors.setText(Integer.toString(Player1.errorCount));
        result.setVisible(false);
        userInput.textProperty().addListener((observable, oldValue, newValue) -> {
            // Check if the new value starts with a space
            if (newValue.startsWith(" ")) {
                // Remove the leading space
                userInput.setText(newValue.trim());
            }
        });
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


    public Details details;

    @FXML
    void changeLevel(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            onNext(new ActionEvent());
        }

    }




    @FXML
    void onNext(ActionEvent event) {

        if(!userInput.getText().isEmpty() && userInput.getText().length() <= givenSentence.getText().length()) {

            if (Details.userChoice == 1) {
                if (i < 7 ) {
                    String user_type = userInput.getText();




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

                        if (i == 6) {

                            givenSentence.setText(wordGenerator.levels3[i]);
                            stopTimer();
                            double time = Double.valueOf(timer.getText());
                            details.setTimetaken1(90 - time);
                            btn.setVisible(false);
                            result.setVisible(true);

                            userInput.setEditable(false);

                        } else {
                            givenSentence.setText(wordGenerator.levels3[i + 1]);
                        }

                        userInput.setText("");
                        i += 1;

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
                        double time = Double.valueOf(timer.getText());
                        details.setTimetaken2(90 - time);

                    } else {
                        givenSentence.setText(wordGenerator.levels3[i + 1]);
                    }

                    if (i == 6) {
                        double time = Double.valueOf(timer.getText());
                        details.setTimetaken1(90 - time);
                        stopTimer();
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
                            double time = Double.valueOf(timer.getText());
                            details.setTimetaken3(90 - time);

                        } else {
                            givenSentence.setText(wordGenerator.levels3[i + 1]);
                        }
                        if (i == 6) {
                            double time = Double.valueOf(timer.getText());
                            details.setTimetaken1(90 - time);
                            stopTimer();
                        }

                        if (i == 13) {
                            stopTimer();
                            double time = Double.valueOf(timer.getText());
                            details.setTimetaken2(90 - time);
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
        else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Alert Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Enter Your Words Accurately. The length of Sentence is out of bound :(");
            alert.showAndWait();
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
            }
            else if (secondsLeft == 0) {
                userInput.setEditable(false);

                timer.setText(String.valueOf(0));
                btn.setVisible(false);
                details.setTimetaken1(90);
                details.setTimetaken2(90);
                details.setTimetaken3(90);
                if(Details.userChoice == 1 && i <= 6) result.setVisible(true);
                if(Details.userChoice == 2 && i < 7) playerTurn.setVisible(true);
                if(Details.userChoice == 2 && i > 6) result.setVisible(true);
                if(Details.userChoice == 3 && i < 7) playerTurn.setVisible(true);
                if(Details.userChoice == 3 && i > 6 && i < 14) playerTurn.setVisible(true);
                if(Details.userChoice == 3 && i > 13) result.setVisible(true);
            }
        }
    @FXML
    void changePlayerTurn(ActionEvent event) {
        if(secondsLeft == 0) {


            if(Details.userChoice == 2  && i < 7) {
                playerTurn.setVisible(false);
                i = 7;
                userInput.setText("");
                givenSentence.setText(wordGenerator.levels3[i]);
                turn.setText("Player 2");
                totalChar.setText(Integer.toString(Player2.characterCount));
                totalErrors.setText(Integer.toString(Player2.errorCount));
                userInput.setEditable(true);
                btn.setVisible(true);
                secondsLeft = 90;
            }

            if(Details.userChoice == 3  && i < 7) {
                playerTurn.setVisible(false);
                i = 7;
                userInput.setText("");
                givenSentence.setText(wordGenerator.levels3[i]);
                turn.setText("Player 2");
                totalChar.setText(Integer.toString(Player2.characterCount));
                totalErrors.setText(Integer.toString(Player2.errorCount));
                userInput.setEditable(true);
                btn.setVisible(true);
                secondsLeft = 90;
            }

            if(Details.userChoice == 3  && i > 7 && i < 14) {
                playerTurn.setVisible(false);
                i = 14;
                userInput.setText("");
                givenSentence.setText(wordGenerator.levels3[i]);
                turn.setText("Player 3");
                totalChar.setText(Integer.toString(Player3.characterCount));
                totalErrors.setText(Integer.toString(Player3.errorCount));
                userInput.setEditable(true);
                btn.setVisible(true);
                secondsLeft = 90;
            }

        }

    }
        private void stopTimer () {
            if (timeline != null) {
                timeline.stop();
                timerRunning = false;
                secondsLeft = 90;
            }
        }

}