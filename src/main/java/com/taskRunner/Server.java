package com.taskRunner;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8080)) {
            /*while(true) {
                Thread thread = new Thread(new Task(serverSocket.accept())) ;
                executor.execute(thread);
            }*/
        }catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
