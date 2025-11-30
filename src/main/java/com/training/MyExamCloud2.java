package com.training;




interface MyInterface{}
sealed class MyClass permits MyExamCloud2 {

}
public final class MyExamCloud2 extends MyClass {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();


    }
}
