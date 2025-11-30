package com.training;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTraining {

    public static void displayCDS(List<CD> cds )  {
        for(int i = 0; i < cds.size(); ++i) {
            CD cd = cds.get(i);
            String cdToString = String.format("%-10s%-16s%-4d%-5s%-5s",
                    cd.artist(), cd.title(), cd.noOfTracks(),
                    cd.year(), cd.genre());
            System.out.printf("cd%d: %s%n", i, cdToString);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        // working with streams
        List<CD> cdList = CD.cdList;
        System.out.println(" Artist Title No. Year Genre");
        displayCDS(cdList);
        // working with filter method in stream
        cdList = cdList
                .stream()
                .filter(CD::isPop)
                .toList();
        displayCDS(cdList);
        // working with empty streams
        Stream<CD> cdStream = Stream.empty() ;
        System.out.println("the number of cds : " + cdStream.count());
        // working with cds stream
        Stream<CD> cdStream2 = Stream.of(CD.cd0 , CD.cd1 , CD.cd2 , CD.cd3 , CD.cd4) ;
        //System.out.println("the number of cds : " + cdStream2.count());

        cdStream2.filter(CD::isPop)
                .forEach(cd -> System.out.println(cd.title()) );

        //  working with array and streams
        Stream<CD> cdStream3 = Arrays.stream(CD.cdArray) ;
        System.out.println("CD ARRAY to stream :");
        cdStream3.forEach( cd -> System.out.println( cd.title()) );
        // working with intStream and DoubleStream
        IntStream intStream = IntStream.of(1 , 2003 , 198);
        System.out.println("int stream :");
        intStream
                .filter( i -> i % 2 == 0 )
                .forEach( i -> System.out.println(i) );
        DoubleStream doubleStream = DoubleStream.of(1 , 2003D , 198);
        System.out.println("double stream :");
        doubleStream
                .forEach( i -> System.out.println(i) );

        // working with generate method
        IntSupplier intSupplier = () -> (int) (90.0 * Math.random()) + 1;
        IntStream intStream2 = IntStream.generate(intSupplier);
        System.out.println("generate int stream :");
        intStream2
                .limit(10)
                .forEach( i -> System.out.println(i) );
        // working with iterate
        IntUnaryOperator intUnaryOperator = i -> i*2 ;
        IntStream intStream1 = IntStream.iterate( 1 , intUnaryOperator ) ;
        System.out.println("iterate :");
        intStream1
                .limit(10)
                .forEach( i -> System.out.println(i) );

        // concatenate streams
        Set<String> set1 = Set.of("word1" , "word2") ;
        Set<String> set2 = Set.of("word3" , "word4") ;
        System.out.println("concatenated stream :");
        Stream<String> concatenatedSteam = Stream.concat(set1.stream() , set2.stream() ) ;
        concatenatedSteam.forEach( i -> System.out.println(i) );

        // buffer reader

        try(FileReader fileReader = new FileReader("data.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Stream<String> stream = bufferedReader.lines();
            System.out.println("BUFFERED STREAM :");
            stream.forEach( i -> System.out.println(i) );
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Files factory lines method
        Path path = Paths.get("data.txt");
        try(Stream<String> stream = Files.lines(path)) {
            System.out.println("Files line method factory :");
            stream.forEachOrdered( i -> System.out.println(i));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // take while and drop while
        Stream<String> stringStream = Stream.of("word5" , "word" , "word3") ;
        System.out.println("take while :");
        stringStream
                .takeWhile(s -> s.length() >= 5 )
                .forEach( i -> System.out.println(i) );


        Stream<String> stringStream1 = Stream.of("word" , "dbud", "word" , "word3") ;
        System.out.println("drop while :");
        stringStream1
                .dropWhile(s -> s.length() >= 5)
                .distinct()
                .forEach( i -> System.out.println(i) );

        Stream.of(1, 3, 5, 7, 8, 9, 11)
                .takeWhile(n -> n % 2 != 0)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
        Stream.of(1, 3, 5, 7, 8, 9, 11)
                .dropWhile(n -> n % 2 != 0)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();

        double[][] arr = {{ 1, 29 } , {179 , 19}} ;

        Arrays.stream(arr)
                .flatMapToDouble(row -> Arrays.stream(row))
                .forEach( i -> System.out.print(i + " "));



        // sorted
        Stream<CD> stream = CD.cdList.stream();

        stream.sorted((c1 , c2) -> c1.title().compareToIgnoreCase(c2.title()))
                .forEach( cd -> System.out.println(cd.title()) );
    }
}