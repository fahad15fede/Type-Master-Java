package com.example.finalproject;

public class Details {
    public static int userChoice;



    public static double timetaken1 = 0;
    public static double timetaken2 = 0;
    public static double timetaken3 = 0;



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
        }
    }



    public void setTimetaken1(double timetaken1) {
        this.timetaken1 = timetaken1/60;
    }
    public void setTimetaken2(double timetaken2) {
        this.timetaken2 = timetaken2/60;
    }
    public void setTimetaken3(double timetaken3) {
        this.timetaken3 = timetaken3/60;
    }


    public void setCharacterCount(){
        if (userChoice == 1)
            Player1.characterCount += user_input.length();

        if (userChoice == 2){

            if (MainController.i < 7)
                Player1.characterCount += user_input.length();

            if (MainController.i > 6 && MainController.i < 14)
                Player2.characterCount += user_input.length();
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