package com.myproject.trackit.controller;

public class Test {

    public static void main(String[] args) {

        String value = method1(1);

        int addedValues = add(1, 2);

        System.out.println(value);

    }

    public static String method1(int number) {
        return method2(number);
    }

    public static String method2(int abc) {
        return Integer.toString(abc) + "_vijitha";
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
