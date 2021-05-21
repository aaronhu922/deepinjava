package com.ahu.jvm;

import java.lang.reflect.Method;

public class ReflectTest {
    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("com.ahu.jvm.ReflectTest");
        Method method = klass.getMethod("target", int.class);
        method.invoke(null, 0);
        for (int i = 0; i < 20; i++) {
            method.invoke(null, i);
        }
    }
}
