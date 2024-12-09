package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.Scanner;

public class MainController {

    WordGenerator wordGenerator = new WordGenerator();
    @FXML
    private Label accuracyPercent;

    @FXML
    private Label charCount;

    @FXML
    private TextFlow givenSentence;

    @FXML
    private Label timer;

    @FXML
    private TextField userInput;

    @FXML
    private Label wordCount;

    Text levels = new Text(wordGenerator.levels[0]);
    @FXML
    public void initialize() {
        givenSentence.getChildren().add(levels);

    }


        int i = 1 ;
    @FXML
    void onNext(ActionEvent event) {
        String getter = userInput.getText();
        Details details = new Details(getter);

        if(i < 7) {
            Text levels = new Text(wordGenerator.levels[i]);
            givenSentence.getChildren().add(levels);
            userInput.setText(" ");
            i += 1 ;
        }


    }

}