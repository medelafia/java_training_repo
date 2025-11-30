package com.telnet;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(23)) {
            while (true) {
                Thread thread = new Thread(new Handler(serverSocket.accept()));

                thread.start();
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
