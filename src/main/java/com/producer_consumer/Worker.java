package com.producer_consumer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Worker {
    private int sequence = 0 ;
    private final static Object LOCK = new Object();
    private final Queue<Integer> numbers = new LinkedList<>();
    private int maxSequence ;
    private int minSequence ;

    public Worker(int minSequence, int maxSequence) {
        this.maxSequence = maxSequence;
        this.minSequence = minSequence;
    }

    public void provide() throws InterruptedException {
        synchronized (LOCK) {
            while(true){
                if(numbers.size() >= maxSequence) {
                    System.out.println("the list is full , please wait for consumers");
                    LOCK.wait();
                }else{
                    System.out.println("adding element to the list " + sequence);
                    numbers.add(sequence++);
                    LOCK.notify();
                }
            }
        }
    }

    public void consume() throws InterruptedException {
        synchronized (LOCK) {
            while(true) {
                if(numbers.size() <= minSequence) {
                    System.out.println("the list is empty , please wait for providers");
                    LOCK.wait();
                }else {
                    System.out.println("removing element from the list" + numbers.poll());
                    LOCK.notify();
                }
            }
        }
    }

}
