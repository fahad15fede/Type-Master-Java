package com.example.finalproject;

public class Player2 {
    public static double wordCount = 0;
    public double accuracy = 0;
    public static int errorCount = 0;
    public static int characterCount = 0;


    Player2() {
    }

//    Player2(int wordCount, int errorCount, int characterCount) {
//        this.wordCount = wordCount;
//        this.errorCount = errorCount;
//        this.characterCount = characterCount;
//    }

    public void setAccuracy() {
        this.accuracy = (((double) (Player2.characterCount - Player2.errorCount) / Player2.characterCount) * 100);
    }

    public double getAccuracy() {
        return accuracy;
    }


    public double getWpm() {
//        return (Player2.characterCount) / (5.0 * details.getTimetaken1());
        return Details.wpmP2;
    }





}
