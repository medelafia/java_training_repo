package com.problem1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>( List.of(
                new Task(1 , PRIORITY.MEDIUM ) ,
                new Task(2  , PRIORITY.LOW) ,
                new Task(3 , PRIORITY.HIGH ) ,
                new Task( 4 , PRIORITY.HIGH ) ,
                new Task(5 , PRIORITY.MEDIUM ) ,
                new Task(6 , PRIORITY.LOW)
        )) ;

        List<Employee> employees = List.of(
                new Employee(1 , "mohamed" , false) ,
                new Employee(2 , "amin" , false )
        ) ;


        TaskScheduler taskScheduler = new TaskScheduler(employees, tasks);

        taskScheduler.process();
    }
}
