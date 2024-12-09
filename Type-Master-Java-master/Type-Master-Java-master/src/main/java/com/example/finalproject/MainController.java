package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class MainController {

    WordGenerator wordGenerator = new WordGenerator();
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
        givenSentence.setText(" " + wordGenerator.levels[0]);
        totalChar.setText(Double.toString(Details.characterCount));
        totalErrors.setText(Double.toString(Details.errorCount));
    }


        int i = 1 ;
    Details details;
    @FXML
    void onNext(ActionEvent event) {
        String user_type = userInput.getText();
        details = new Details( wordGenerator.levels[i - 1] ,user_type );
        totalChar.setText(Double.toString(Details.characterCount));
        totalErrors.setText(Double.toString(Details.errorCount));
        details.setWpm();
        wordCount.setText(Double.toString(details.getWpm()));

        if(i < 7) {
            givenSentence.setText(" " + wordGenerator.levels[i]);

            userInput.setText("");
            i += 1 ;
        }


    }
    @FXML
    void forAccuracy(ActionEvent event)  {




    }

}