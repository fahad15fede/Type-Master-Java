package com.example.finalproject;

public class Details {
    private double Accuracy;
    private double wpm;
    public static double errorCount;
    private static double characterCount;
    private long timetaken;

    String user_input;

    WordGenerator givenSentence = new WordGenerator();

    Details(){

    }
    Details(String user_type){
        this.user_input= user_type;
    }

    public void setAccuracy() {

        Accuracy = (((getCharacterCount()-getErrorCount())/getCharacterCount())*100);
    }

    public double getErrorCount() {
        return errorCount;
    }
    public void setErrorCount(){
        for (int i = 0; i < user_input.length(); i++) {

            if (user_input.charAt(i) != givenSentence.level1_stage1().charAt(i)){
                errorCount ++;
            }
//            if (user_input.charAt(i) != givenSentence.level1_stage2().charAt(i)){
//                errorCount ++;
//            }if (user_input.charAt(i) != givenSentence.level2_stage1().charAt(i)){
//                errorCount ++;
//            }if (user_input.charAt(i) != givenSentence.level2_stage2().charAt(i)){
//                errorCount ++;
//            }if (user_input.charAt(i) != givenSentence.level3_stage1().charAt(i)){
//                errorCount ++;
//            }if (user_input.charAt(i) != givenSentence.level3_stage2().charAt(i)){
//                errorCount ++;
//            }if (user_input.charAt(i) != givenSentence.level4_stage1().charAt(i)){
//                errorCount ++;
//            }

        }
    }
    public double getAccuracy(){
        return this.Accuracy;
    }
    public double getWpm(){
        return user_input.length()/user_input.length();
    }
    public double getCharacterCount(){
        return characterCount;
    }
    public void setCharacterCount(){
        characterCount+=user_input.length();
    }
}