package com.example.finalproject;

public class Details {
    static int userChoice;
    private double Accuracy;
    private double wordCount=0;
    private double wpm;
    public static double errorCountp1 = 0;
    public static double errorCountp2 = 0;
    public static double errorCountp3 = 0;
    public static double characterCount1 = 0;
    public static double characterCount2 = 0;
    public static double characterCount3 = 0;

    private long timetaken;

    public String user_input;
    public String currentSentence;

    WordGenerator givenSentence = new WordGenerator();

    Details(){

    }
    Details(String currentSentence , String user_type ){

        this.user_input= user_type;
        this.currentSentence = currentSentence;

        setCharacterCount();
        setErrorCount();
    }

    public void setAccuracy() {
        if(userChoice == 1) Accuracy = (((characterCount1-errorCountp1)/characterCount1)*100);
        if(userChoice == 2) Accuracy = (((characterCount2-errorCountp2)/characterCount2)*100);
        if(userChoice == 3) Accuracy = (((characterCount3-errorCountp3)/characterCount3)*100);
    }


    public double getErrorCount() {
        if(userChoice == 1) return errorCountp1;
        if(userChoice == 2) return errorCountp2;
        if(userChoice == 3) return errorCountp3;
        return 0;
    }
    public void setErrorCount(){
            for (int i = 0; i < user_input.length(); i++) {

                if (user_input.charAt(i) != currentSentence.charAt(i)) {
                    if (userChoice == 1) errorCountp1++;
                    if (userChoice == 2) {
                        if(MainController.i < 7){
                            errorCountp1++;
                        }
                        if(MainController.i>7){
                            errorCountp2++;
                        }
                    }

                    if (userChoice == 3) {

                        if (MainController.i < 8) {
                            errorCountp1++;
                        }
                        if (MainController.i > 8 && MainController.i < 15) {
                            errorCountp2++;
                        }
                        if (MainController.i > 15 && MainController.i < 21) {
                            errorCountp3++;
                        }
                    }
                }
//

            }
    }
    public double getAccuracy(){
        return this.Accuracy;
    }
    public void setWpm(String user_input) {
        wordCount = 0;

        if (!user_input.trim().isEmpty()) {
            wordCount = 1;
            for (int i = 0; i < user_input.length(); i++) {
                if (user_input.charAt(i) == ' ' && user_input.charAt(i - 1) != ' ') {
                    wordCount++;
                }
            }
            wpm=wordCount;
        }
    }

    public double getWpm() {
        return wpm;
    }

    public double getCharacterCount(){
       if (userChoice == 1) return characterCount1;
       if (userChoice == 2) return characterCount2;
       if (userChoice == 3) return characterCount3;
       return 0;
    }
    public void setCharacterCount(){
        if (userChoice == 1) characterCount1 += user_input.length();
        if (userChoice == 2) characterCount2 += user_input.length();
        if (userChoice == 3) characterCount3 += user_input.length();
    }

    public void playerSelection(int choice) {
        userChoice = choice;
    }

    public int getUserChoice() {
        return userChoice;
    }

}