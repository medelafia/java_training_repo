package com.service_execution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        for(int i = 0 ; i < 10 ; i++){
            executorService.execute(new Task(i)) ;
        }
    }


}
class Task implements Runnable {
    private int taskId ;
    public Task(int taskId) {
        this.taskId = taskId;
    }

    public void run() {
        System.out.println("task "+taskId + " is running by the thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
