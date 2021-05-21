package com.ahu.concurrent;

public class StaticHandlerSingleton {
    private static class StaticHandler{
        private static StaticHandlerSingleton instance = new StaticHandlerSingleton();
    }

    public static StaticHandlerSingleton getInstance(){
        return StaticHandler.instance;
    }
}
