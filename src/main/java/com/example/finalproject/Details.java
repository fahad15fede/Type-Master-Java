package com.example.finalproject;

public class Details {
    private double Accuracy;
    private double wpm;
    private double errorCount;
    private double characterCount;
    private long timetaken;

    String user_input;

    WordGenerator givenSentence=new WordGenerator();

    Details(){

    }
    Details(String user_type){
        this.user_input= user_type;
    }

    public void setAccuracy() {

        Accuracy = (getErrorCount()/getCharacterCount())*100;
    }

    public double getErrorCount() {
        return errorCount;
    }
    public void setErrorCount(){
        for (int i = 0; i < user_input.length(); i++) {

            if (user_input.charAt(i) != givenSentence.)
        }
    }
    public double getAccuracy(){
        return this.Accuracy;
    }
    public double getWpm(){
        return user_type.length()/user_type.length();
    }
    public double getCharacterCount(){
        return this.characterCount;
    }
    public void setCharacterCount(){
        characterCount=user_input.length();
    }
}
