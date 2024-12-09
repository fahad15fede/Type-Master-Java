package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Scanner;

public class MainController {


    WordGenerator wordGenerator = new WordGenerator();
    @FXML
    private Label givenSentence;
    @FXML
    private Label accuracy;

    @FXML
    private TextField userInput;

    @FXML
    public void initialize() {
        givenSentence.setText(wordGenerator.levels[0]);
    }

    @FXML
        int i = 1 ;
    public void next(ActionEvent event) {
        String getter = userInput.getText();
        Details details = new Details(getter);

        if(i < 7) {
            givenSentence.setText(wordGenerator.levels[i]);
            userInput.setText(" ");
            i += 1 ;
        }


    }

}