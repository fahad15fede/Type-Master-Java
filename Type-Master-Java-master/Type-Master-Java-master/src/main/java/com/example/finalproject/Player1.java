package com.example.finalproject;

public class Player1 {
    public static double wordCount = 0;
    public double accuracy = 0;
    public static int errorCount = 0;
    public static int characterCount = 0;

    Player1(){

    }

    Player1(int wordCount , int errorCount , int characterCount){
        this.wordCount = wordCount;
        this.errorCount = errorCount;
        this.characterCount = characterCount;
    }

    public void setAccuracy() {
        this.accuracy = (((double) (Player1.characterCount - Player1.errorCount) / Player1.characterCount)*100);
    }

    public double getAccuracy() {
        return accuracy;
    }

    public double getWpm() {
        return Details.wpmP1;
    }




}
