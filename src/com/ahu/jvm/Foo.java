package com.ahu.jvm;


public class Foo {
    public static void main(String[] args) {
        byte flag = 2;
        if (flag != 0) {
            System.out.println("Hello, Java!");
        }
        if (flag == 1) {
            System.out.println("Hello, JVM!");
        }
    }
}
