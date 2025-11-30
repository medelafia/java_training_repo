package com.training;

class Exam {
    public String toString() {
        return "MyExamCloud Practice Exam";
    }
}
public class MyExamCloud {
    public static void main(String[] args) {
        Object exam = new Exam();

        switch(exam) {
            case null -> System.out.println("null");
            case String s -> System.out.println("String");
            case Exam e -> System.out.println(e.toString());
            case int[] ia -> System.out.println("int[]");
            default -> System.out.println("something else");
        }
    }
}