package com.producer_consumer;

public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker(0 , 10) ;
        Thread one = new Thread(()->{
            try {
                worker.provide();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread two = new Thread(()->{
            try {
                worker.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }) ;


        one.start();
        two.start();
    }
}
