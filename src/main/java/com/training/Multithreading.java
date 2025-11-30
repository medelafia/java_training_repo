package com.training;

public class Multithreading {
    private static int counter = 0;
    private static synchronized void incrementCounter() {
        counter++;
    }
    public static void main(String[] args) {
        Thread one = new Thread(() -> {
            for(int i = 0 ; i < 100000 ; i++ ) {
                incrementCounter();
            }
        }) ;
        Thread two = new Thread(() -> {
            for(int i = 0 ; i < 100000 ; i++ ) {
                incrementCounter();
            }
        }) ;
        one.start();
        two.start();

        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("done , counter value = " + counter);
    }
}
