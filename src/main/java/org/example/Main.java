package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        showMenu();
    }

    private static void showMenu() {
        System.out.println("""
                1. login
                2. register
                """);
    }


}
