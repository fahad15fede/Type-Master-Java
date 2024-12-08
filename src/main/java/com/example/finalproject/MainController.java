package com.example.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    WordGenerator wordGenerator = new WordGenerator();
    @FXML
    private Label givenSentence;

    @FXML
    private Label userInp;

    @FXML
    public void initialize() {
        givenSentence.setText(wordGenerator.level1_stage1());
    }
    void done() {
        Details details = new Details(userInp.getText());
        userInp.setText(" ");

    }

}