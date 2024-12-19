package com.example.finalproject;

public class Player3 {
    public double accuracy = 0;
    public double wpm=0;
    public static int errorCount = 0;
    public static int characterCount = 0;

    Player3(){
    }

    public void setAccuracy() {
        this.accuracy = (((double) (Player3.characterCount - Player3.errorCount) / Player3.characterCount)*100);
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setWpm() {
        wpm=((double)(Player3.characterCount)/(5.0*Details.timetaken3));
    }

    public double getWpm() {
        return this.wpm;
    }

}
