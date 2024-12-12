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
            accuracyp1 = (((double) (Player1.characterCount - Player1.errorCount) / Player1.characterCount)*100);

        if(userChoice == 2){
            accuracyp1 = (((double) (Player1.characterCount - Player1.errorCount) / Player1.characterCount)*100);
            accuracyp2 = (((double) (Player2.characterCount - Player2.errorCount) / Player2.characterCount)*100);
        }

        if(userChoice == 3){
            accuracyp1 = (((double) (Player1.characterCount - Player1.errorCount) / Player1.characterCount)*100);
            accuracyp2 = (((double) (Player2.characterCount - Player2.errorCount) / Player2.characterCount)*100);
            accuracyp3 = (((double) (Player3.characterCount - Player3.errorCount) / Player3.characterCount)*100);
        }

    }


    public double getErrorCount() {
        if(userChoice == 1) return Player1.errorCount;
        if(userChoice == 2) return Player2.errorCount;
        if(userChoice == 3) return Player3.errorCount;
        return 0;
    }
    public void setErrorCount(){
            for (int i = 0; i < user_input.length(); i++) {

                if (user_input.charAt(i) != currentSentence.charAt(i)) {
                    if (userChoice == 1)
                        Player1.errorCount++;
                    if (userChoice == 2) {
                        if(MainController.i < 7){
                            Player1.errorCount++;
                        }
                        if(MainController.i>=7){
                            Player2.errorCount++;
                        }
                    }

                    if (userChoice == 3) {

                        if (MainController.i < 7) {
                            Player1.errorCount++;
                        }
                        if (MainController.i > 6 && MainController.i < 14) {
                            Player2.errorCount++;
                        }
                        if (MainController.i > 13 && MainController.i < 21) {
                            Player3.errorCount++;
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
        Player1.wordCount = 0;
        Player2.wordCount = 0;
        Player3.wordCount = 0;

        if (!user_input.trim().isEmpty()) {
            Player1.wordCount = 1;
            Player2.wordCount = 1;
            Player3.wordCount = 1;

            for (int i = 0; i < user_input.length(); i++) {
                if (user_input.charAt(i) == ' ' && user_input.charAt(i - 1) != ' ') {
                    if (userChoice == 1) Player1.wordCount++;
                    if (userChoice == 2){
                        if (MainController.i<7)
                            Player1.wordCount++;
                        if (MainController.i>6 && MainController.i<14)
                            Player2.wordCount++;
                    }
                    if (userChoice == 3){
                        if (MainController.i<7)
                            Player1.wordCount++;
                        if (MainController.i>6 && MainController.i<14)
                            Player2.wordCount++;
                        if (MainController.i>13 && MainController.i<21)
                            Player3.wordCount++;
                    }

                }
            }

        }
    }

    public double getWpm() {
        if (userChoice == 1)
         return Player1.wordCount/3;
        if (userChoice == 2)
            return Player2.wordCount/3;
        if (userChoice == 3)
            return Player3.wordCount/3;
        else return 0;
    }

    public double getCharacterCount(){
       if (userChoice == 1) return Player1.characterCount;
       if (userChoice == 2) return Player2.characterCount;
       if (userChoice == 3) return Player3.characterCount;
       return 0;
    }
    public void setCharacterCount(){
        if (userChoice == 1)
            Player1.characterCount += user_input.length();

        if (userChoice == 2){

                if (MainController.i < 7)
                    Player1.characterCount += user_input.length();

                else Player2.characterCount += user_input.length();
        }

        if (userChoice == 3) {

                if (MainController.i < 7)
                    Player1.characterCount += user_input.length();

                if (MainController.i > 6 && MainController.i < 14)
                    Player2.characterCount += user_input.length();

                if (MainController.i > 13 && MainController.i < 21)
                    Player3.characterCount += user_input.length();

        }
    }

    public void playerSelection(int choice) {
        userChoice = choice;
    }

    public int getUserChoice() {
        return userChoice;
    }

}