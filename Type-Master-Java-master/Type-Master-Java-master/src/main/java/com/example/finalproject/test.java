package com.example.finalproject;

public class test {
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog";

        // Split the predefined text into words and store them in an array
        String[] textArray = text.split(" ");

        for (int i = 0; i < textArray.length; i++) {
            System.out.println(textArray[i] + " ");

        }


    }


}
