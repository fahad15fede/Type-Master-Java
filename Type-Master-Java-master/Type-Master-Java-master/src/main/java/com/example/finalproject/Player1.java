package com.example.finalproject;

public class Player1 {
    public double accuracy = 0;
    public static int errorCount = 0;
    public static int characterCount = 0;
    public double wpm=0;

    Player1(){

    }




    public void setAccuracy() {
        this.accuracy = (((double) (Player1.characterCount - Player1.errorCount) / Player1.characterCount)*100);
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setWpm(){
        this.wpm=((double) (Player1.characterCount)/(5.0*Details.timetaken1));
    }

    public double getWpm() {
        return this.wpm;
    }




}
