package com.telnet;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost" , 23)) {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
            String line = "" ;
            System.out.print("shell >>");
            while(!(line = scanner.nextLine()).equals("exit")) {
                if (!line.isEmpty()) {
                    out.writeUTF(line);
                    String response = in.readUTF();
                    System.out.println(response);
                }
                System.out.print("shell >>");
            }
            out.close();
            in.close();
        }catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
