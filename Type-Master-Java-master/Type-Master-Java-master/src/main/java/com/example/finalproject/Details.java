package com.example.finalproject;

public class Details {
    private double Accuracy;
    private double wpm=7;
    public static double errorCount = 0;
    public static double characterCount = 0;
    private long timetaken;

    public String user_input;
    public String currentSentence;

    WordGenerator givenSentence = new WordGenerator();

    Details(){

    }
    Details(String currentSentence , String user_type ){

        this.user_input= user_type;
        this.currentSentence = currentSentence;
        characterCount += user_type.length();
        setErrorCount();
    }

    public void setAccuracy() {

        Accuracy = (((characterCount-errorCount)/characterCount)*100);
    }


    public double getErrorCount() {
        return errorCount;
    }
    public void setErrorCount(){
        for (int i = 0; i < user_input.length(); i++) {

            if (user_input.charAt(i) != currentSentence.charAt(i)){
                errorCount ++;
            }
//

        }
    }
    public double getAccuracy(){
        return this.Accuracy;
    }
    public void setWpm(){

        for (int i = 0; i < user_input.length(); i++) {
            if (user_input.charAt(i)==' ')
            {
                wpm++;
            }

        }


    }

    public double getWpm() {
        return wpm;
    }

    public double getCharacterCount(){
        return characterCount;
    }
    public void setCharacterCount(){
        characterCount+=user_input.length();
    }
}