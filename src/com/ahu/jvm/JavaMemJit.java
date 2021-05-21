package com.ahu.jvm;

public class JavaMemJit {

    int a = 0, b = 0;

    public void method1() {
        int r2 = a;
        b = 1;
        System.out.println(r2);
    }

    public void method2() {
        int r1 = b;
        a = 2;
        System.out.println(r1);

    }

    public static void main(String[] args) {
        new JavaMemJit().method1();
        new JavaMemJit().method2();
    }

}
