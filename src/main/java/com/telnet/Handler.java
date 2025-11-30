package com.telnet;

import java.io.*;
import java.net.Socket;
import java.util.stream.Collectors;

public class Handler implements Runnable {
    private Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        System.out.println("starting thread now " + Thread.currentThread().getName());
        try {
            DataInputStream inputStream = new DataInputStream( this.socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(this.socket.getOutputStream());
            String line = "" ;
            while(!(line = inputStream.readUTF()).equals("exit")) {
                Process process = Runtime.getRuntime().exec(line);
                try(BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    outputStream.writeUTF(reader.lines().collect(Collectors.joining("\n")));
                }catch (Exception e) {
                    outputStream.writeUTF(e.getMessage());
                }
            }


            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
