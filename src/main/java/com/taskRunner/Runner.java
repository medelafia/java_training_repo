package com.taskRunner;

import java.io.IOException;
import java.net.Socket;

public class Runner implements Runnable {
    private Socket socket;

    public Runner(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Task started");
        System.out.println("Task ended");
        try {
            this.socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
