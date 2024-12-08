package com.example.finalproject;

public class Timer {
    public Timer(){
        new Thread(() -> {
            int secondsLeft = 60;
            while (secondsLeft > 0) {
                System.out.println("Time left: " + secondsLeft + " seconds");
                secondsLeft--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Timer interrupted");
//                    return;
                }
            }
            System.out.println("Time's up!");
        }).start();
    }
}
