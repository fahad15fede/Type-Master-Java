package com.example.finalproject;

import java.util.Scanner;

public class Mode {
    Scanner scan = new Scanner(System.in);
    int choice = 1;
    public Mode () {
        System.out.println("Enter Number Of Players. ");
        choice = scan.nextInt();
        new Mode(choice);
    }
    public Mode (int i ){
        if (choice == 1){
            WordGenerator player1 = new WordGenerator();
        }

        if (choice == 2){
            WordGenerator player1 = new WordGenerator();
            WordGenerator player2 = new WordGenerator();

        }
        if (choice == 3){
            WordGenerator player1 = new WordGenerator();
            WordGenerator player2 = new WordGenerator();
            WordGenerator player3 = new WordGenerator();

        }else {
            WordGenerator player1 = new WordGenerator();
        }

    }
}
