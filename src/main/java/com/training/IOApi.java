package com.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOApi {
    public  boolean equals(Object o) {
        String name = "mohamed" ;

        return (o instanceof  Object ) && ((String)o).equalsIgnoreCase(name);
    }
    public static void main(String[] args) {
        try(var br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Please enter a file name: ");
            var s = br.readLine();
            System.out.println("file name: " + s);
        }catch (IOException io ) {
            io.printStackTrace();
        }


        IOApi api = new IOApi();
        System.out.println(api.equals("mohmed"));
    }
}
