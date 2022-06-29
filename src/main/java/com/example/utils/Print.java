package com.example.utils;


import static com.example.utils.Color.BLUE;
import static com.example.utils.Color.RESET;

public class Print {
    public static void print(Object obj) {
        print(BLUE, obj);
    }

    public static void print(String color, Object obj) {
        System.out.print(color + obj + RESET);
    }

    public static void println(Object obj) {
        println(BLUE, obj);
    }

    public static void println(String color, Object obj) {
        System.out.println(color + obj + RESET);
    }
}
