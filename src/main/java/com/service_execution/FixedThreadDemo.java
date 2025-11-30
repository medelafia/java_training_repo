package com.service_execution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FixedThreadDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i = 0 ; i < 10 ; i++){
            executorService.execute(new Task(i)) ;
        }

        ScheduledExecutorService executorService2 = Executors.newSingleThreadScheduledExecutor();
        executorService2.scheduleAtFixedRate(new TaskSchedule() , 1000, 2000 , TimeUnit.MILLISECONDS) ;



        executorService.shutdown();
    }


}
class TaskSchedule implements Runnable {
    @Override
    public void run() {
        System.out.println("Task Schedule run");
    }
}
class Work implements Runnable {
    private int taskId ;
    public Work(int taskId) {
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
