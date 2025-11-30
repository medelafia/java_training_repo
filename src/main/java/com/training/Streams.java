package com.training;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Streams {
    public static void main(String[] args) throws InterruptedException {
        Supplier<IntStream> intStream = () -> IntStream.of(1, 2, 3, 4, 5);


        intStream.get().filter(i -> i % 2 == 0).forEach(System.out::println);
        System.out.println(intStream.get().average().getAsDouble());
        System.out.println(intStream.get().max().getAsInt());
        System.out.println(intStream.get().min().getAsInt());


    }
}
