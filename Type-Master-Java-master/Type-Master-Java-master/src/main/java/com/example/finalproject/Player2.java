package com.example.finalproject;

public class Player2 {
    public double wpm=0;
    public double accuracy = 0;
    public static int errorCount = 0;
    public static int characterCount = 0;


    Player2() {
     }



    public void setAccuracy() {
        this.accuracy = (((double) (Player2.characterCount - Player2.errorCount) / Player2.characterCount) * 100);
    }

    public double getAccuracy() {
        return accuracy;
    }


    public double getWpm() {
        return this.wpm;
    }

    public void setWpm() {
        wpm=((double)(Player2.characterCount)/(5.0*Details.timetaken2));
    }
}
