package com.studentnavigator;

import java.io.IOException;

// Controls the main menu and user navigation
// Extends UserInput to access shared input methods.
public class Welcome extends UserInput {

    // Displays the main menu and processes user selections.
    public void displayMenu() throws IOException {

        while (true) {
            IO.println("Welcome to the Student Resource Navigator");
            IO.println("""
                            .--.                   .---.
                        .---|__|           .-.     |~~~|
                    .--|===|--|_          |_|     |~~~|--.
                    |  |===|  |'\\     .---!~|  .--|   |--|
                    |%%|   |  |.'\\    |===| |--|%%|   |  |
                    |%%|   |  |\\.'\\   |   | |__|  |   |  |
                    |  |   |  | \\  \\  |===| |==|  |   |  |
                    |  |   |__|  \\.'\\ |   |_|__|  |~~~|__|
                    |  |===|--|   \\.'\\|===|~|--|%%|~~~|--|
                    ^--^---'--^    `-'`---^-^--^--^---'--'
                    """);

            // Main menu options
            IO.println("1 - View all Resources");
            IO.println("2 - Filter by Category");
            IO.println("3 - Filter by Building");
            IO.println("4 - Filter by Name");
            IO.println("0 - Exit");

            int choice = getInt(); // Read user selection

            switch (choice) {
                case 1 -> Filters.viewAllResources();
                case 2 -> Filters.filterByCategory();
                case 3 -> Filters.filterByBuilding();
                case 4 -> Filters.filterByName();
                case 0 -> {
                    IO.println("Goodbye!");
                    return;
                }
                default -> IO.println("Invalid selection.");
            }

            IO.println("\nPress Enter to return to the menu...");
            getString(); 
        }
    }
}
