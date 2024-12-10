package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ModeController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void onePlayer(ActionEvent event) throws IOException {
        Parent root  = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        new Details().playerSelection(1);
    }

    @FXML
    void threePlayers(ActionEvent event) throws IOException {
        Parent root  = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        new Details().playerSelection(3);
    }

    @FXML
    void twoPlayers(ActionEvent event) throws IOException {
        Parent root  = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        new Details().playerSelection(2);
    }
}