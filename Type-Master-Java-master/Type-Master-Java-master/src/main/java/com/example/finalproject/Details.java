package com.example.finalproject;

public class Details {
    static int userChoice;
    private double accuracyp1;
    private double accuracyp2;
    private double accuracyp3;
    static private double wordCountp1 = 0;
    static private double wordCountp2 = 0;
    static private double wordCountp3 = 0;

    public static int errorCountp1 = 0;
    public static int errorCountp2 = 0;
    public static int errorCountp3 = 0;
    public static int characterCount1 = 0;
    public static int characterCount2 = 0;
    public static int characterCount3 = 0;

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
        if(userChoice == 1)
            accuracyp1 = (((double) (characterCount1 - errorCountp1) /characterCount1)*100);

        if(userChoice == 2){
            accuracyp1 = (((double) (characterCount1 - errorCountp1) /characterCount1)*100);
            accuracyp2 = (((double) (characterCount2 - errorCountp2) / characterCount2)*100);
        }

        if(userChoice == 3){
            accuracyp1 = (((double) (characterCount1 - errorCountp1) / characterCount1)*100);
            accuracyp2 = (((double) (characterCount2 - errorCountp2) / characterCount2)*100);
            accuracyp3 = (((double) (characterCount3 - errorCountp3) / characterCount3)*100);
        }

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
                    if (userChoice == 1)
                        errorCountp1++;
                    if (userChoice == 2) {
                        if(MainController.i < 7){
                            errorCountp1++;
                        }
                        if(MainController.i>=7){
                            errorCountp2++;
                        }
                    }

                    if (userChoice == 3) {

                        if (MainController.i < 7) {
                            errorCountp1++;
                        }
                        if (MainController.i > 6 && MainController.i < 14) {
                            errorCountp2++;
                        }
                        if (MainController.i > 13 && MainController.i < 21) {
                            errorCountp3++;
                        }
                    }
                }
//

            }
    }
        public double getAccuracy(){
            if(userChoice == 1) return accuracyp1;
            if(userChoice == 2) return accuracyp2;
            if(userChoice == 3) return accuracyp3;

            else return 0;
        }
    public void setWpm(String user_input) {
        wordCountp1 = 0;
        wordCountp2 = 0;
        wordCountp3 = 0;

        if (!user_input.trim().isEmpty()) {
            wordCountp1 = 1;
            wordCountp2 = 1;
            wordCountp3 = 1;

            for (int i = 0; i < user_input.length(); i++) {
                if (user_input.charAt(i) == ' ' && user_input.charAt(i - 1) != ' ') {
                    if (userChoice == 1) wordCountp1++;
                    if (userChoice == 2){
                        if (MainController.i<7)
                            wordCountp1++;
                        if (MainController.i>6 && MainController.i<14)
                            wordCountp2++;
                    }
                    if (userChoice == 3){
                        if (MainController.i<7)
                            wordCountp1++;
                        if (MainController.i>6 && MainController.i<14)
                            wordCountp2++;
                        if (MainController.i>13 && MainController.i<21)
                            wordCountp2++;
                    }

                }
            }

        }
    }

    public double getWpm() {
        if (userChoice == 1)
         return wordCountp1/3;
        if (userChoice == 2)
            return wordCountp2/3;
        if (userChoice == 3)
            return wordCountp3/3;
        else return 0;
    }

    public double getCharacterCount(){
       if (userChoice == 1) return characterCount1;
       if (userChoice == 2) return characterCount2;
       if (userChoice == 3) return characterCount3;
       return 0;
    }
    public void setCharacterCount(){
        if (userChoice == 1)
            characterCount1 += user_input.length();

        if (userChoice == 2){

                if (MainController.i < 7)
                    characterCount1 += user_input.length();

                else characterCount2 += user_input.length();
            }

        if (userChoice == 3) {

                if (MainController.i < 7)
                    characterCount1 += user_input.length();

                if (MainController.i > 6 && MainController.i < 14)
                    characterCount2 += user_input.length();

                if (MainController.i > 13 && MainController.i < 21)
                    characterCount3 += user_input.length();

        }
    }

    public void playerSelection(int choice) {
        userChoice = choice;
    }

    public int getUserChoice() {
        return userChoice;
    }

}