package com.example.finalproject;

public class Details {
    public static int userChoice;
    private static double accuracyp1;
    private static double accuracyp2;
    private static double accuracyp3;
    static public double wordCountp1 = 0;
    static public double wordCountp2 = 0;
    static public double wordCountp3 = 0;

    public static int errorCountp1 = 0;
    public static int errorCountp2 = 0;
    public static int errorCountp3 = 0;
    public static int characterCount1 = 0;
    public static int characterCount2 = 0;
    public static int characterCount3 = 0;

    public static double timetaken1 = 0;
    public static double timetaken2 = 0;
    public static double timetaken3 = 0;

    String test = "Hellloo";

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
            accuracyp1 = (((double) (characterCount1 - errorCountp1) / characterCount1 *100));

        if(userChoice == 2){
            accuracyp1 = (((double) (characterCount1 - errorCountp1) / characterCount1 *100));
            accuracyp2 = (((double) (characterCount2 - errorCountp2) / characterCount2 *100));
        }

        if(userChoice == 3){
            accuracyp1 = (((double) (characterCount1 - errorCountp1) / characterCount1 *100));
            accuracyp2 = (((double) (characterCount2 - errorCountp2) / characterCount2 *100));
            accuracyp3 = (((double) (characterCount3 - errorCountp3) / characterCount3*100));
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
                            errorCountp2++;
                        }
                        if(MainController.i>=7){
                            errorCountp2++;
                        }
                    }

                    if (userChoice == 3) {

                        if (MainController.i < 7) {
                            errorCountp3++;
                        }
                        if (MainController.i > 6 && MainController.i < 14) {
                            errorCountp3++;
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





//    public void setWpm(String user_input) {
//        wordCountp1 = 0;
//        wordCountp2 = 0;
//        wordCountp3 = 0;
//
//        if (!user_input.trim().isEmpty()) {
//
//
//            for (int i = 0; i < user_input.length(); i++) {
//                if (user_input.charAt(i) == ' ' && user_input.charAt(i - 1) != ' ') {
//                    if (userChoice == 1) wordCountp1++;
//                    if (userChoice == 2){
//                        if (MainController.i<7)
//                            wordCountp2++;
//                        if (MainController.i>6 && MainController.i<14)
//                            wordCountp2++;
//                    }
//                    if (userChoice == 3){
//                        if (MainController.i<7)
//                            wordCountp1++;
//                        if (MainController.i>6 && MainController.i<14)
//                            wordCountp2++;
//                        if (MainController.i>13 && MainController.i<21)
//                            wordCountp3++;
//                    }
//
//                }
//            }
//
//        }
//    }

//    public double getWpm(int choice) {
//        if (choice == 1)
//         return wordCountp1/3;
//        if (choice == 2)
//            return wordCountp2/3;
//        if (choice == 3)
//            return wordCountp3/3;
//        else return 0;
//    }


    public void setTimetaken1(double timetaken1) {
        this.timetaken1 = timetaken1/60;
    }
    public void setTimetaken2(double timetaken2) {
        this.timetaken2 = timetaken2/60;
    }
    public void setTimetaken3(double timetaken3) {
        this.timetaken3 = timetaken3/60;
    }

//    public double getTimetaken1() {
//        return timetaken1;
//    }
//    public double getTimetaken2() {
//        return timetaken2;
//    }
//    public double getTimetaken3() {
//        return timetaken3;
//}


    public double getWpm() {
        if (userChoice == 1)
            return characterCount1/(5.0 * timetaken1);
        if (userChoice == 2)
            return (characterCount1)/(5.0 * timetaken2);
        if (userChoice == 3)
            return (characterCount1)/(5.0 * timetaken3);
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
                    characterCount2 += user_input.length();

                else characterCount2 += user_input.length();
        }

        if (userChoice == 3) {

                if (MainController.i < 7)
                    characterCount3 += user_input.length();

                if (MainController.i > 6 && MainController.i < 14)
                    characterCount3 += user_input.length();

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