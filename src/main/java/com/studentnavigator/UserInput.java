package com.studentnavigator;
import java.util.Scanner;

public abstract class UserInput {
    // Shared Scanner for the entire program
    protected static final Scanner sc = new Scanner(System.in);

    
    protected static int getInt() {
        while (!sc.hasNextInt()) {
            IO.println("Please enter a valid number.");
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine(); // Clear leftover newline
        return value;
    }

    protected static String getString() {
        return sc.nextLine().trim();
    }
}
