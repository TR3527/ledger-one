package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String nameInput = read.nextLine();


        read.close();
    }
}
