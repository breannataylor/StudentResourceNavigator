/*
 * This file is part of StudentResourceNavigator.
 *
 * StudentResourceNavigator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * StudentResourceNavigator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with StudentResourceNavigator. If not, see <https://www.gnu.org/licenses/>.
 */
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
