package com.studentnavigator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Filters extends UserInput {

    //view all resources
    public static void viewAllResources() throws IOException{
        List<Resource> fullList = ResourceRepository.getAllResources();
        
        for (Resource r : fullList) {
            IO.println(r.toString() + "\n\n");
        }
    }
    //search by category
    public static List<Resource> filterByCategory() throws IOException {
        //list of categories in JSON
        List<String> categories = List.of(
                "Food",
                "Housing",
                "Disability Services",
                "Well‑Being",
                "Childcare",
                "Technology",
                "Security",
                "Academic Support",
                "Financial Assistance",
                "Student Life"
        );

        int num = 1;
        IO.println("Select a category:");
        for (String s : categories) {
            IO.println(num + " - " + s);
            num++;
        }

        int choice = Integer.parseInt(getString());
        if (choice < 1 || choice > categories.size()) {
            IO.println("Invalid choice.");
            return new ArrayList<>();
        }
        //retrieves index of category in array
        String categoryInput = categories.get(choice - 1);

        List<Resource> fullList = ResourceRepository.getAllResources();
        List<Resource> results = new ArrayList<>();

        for (Resource r : fullList) {
            //creates list of categories
            List<String> resourceCategories = r.getCategory();

            if (resourceCategories != null) {
                //loop through categories, if chosen category is there, add to results
                for (String c : resourceCategories) {
                    if (c.equalsIgnoreCase(categoryInput)) {
                        IO.println(r);
                        results.add(r);
                        break; // stop checking this resource once matched
                    }
                }
            }
        }

        if (results.isEmpty()) {
            IO.println("No resources found for category: " + categoryInput);
        }

        postFilterMenu(results);
        return results;
    }

    //filter by building
    public static List<Resource> filterByBuilding() throws IOException {
        IO.println("Enter a building number:");

        int building = getInt(); 

        List<Resource> fullList = ResourceRepository.getAllResources();
        List<Resource> results = new ArrayList<>();

        for (Resource r : fullList) {
            if (r.getBuilding() == building) {
                IO.println(r);
                results.add(r);
            }
        }

        if (results.isEmpty()) {
            IO.println("No resources found in building: " + building);
        }

        postFilterMenu(results);

        return results;
    }

   public static List<Resource> filterByName() throws IOException {
        IO.println("Enter the name of the resource:");
        String name = getString().toLowerCase();

        List<Resource> fullList = ResourceRepository.getAllResources();
        List<Resource> results = new ArrayList<>();

        for (Resource r : fullList) {
            if (r.getName().toLowerCase().contains(name)) {
                IO.println(r);
                results.add(r);
            }
        }

        if (results.isEmpty()) {
            IO.println("No resources found with name containing: " + name);
        }

        postFilterMenu(results);
        return results;
    }
    
    public static void postFilterMenu(List<Resource> results){
        boolean running = true;
        int choice; 
        //menu loop
        while (running) {
            //switch choices
            IO.println("\nWhat would you like to do?");
            IO.println("1 - Add resources to my list");
            IO.println("2 - Remove a resource from my list");
            IO.println("3 - View my resource list");
            IO.println("4 - Save list to a text file");
            IO.println("0 - Return to the main menu\n");

            IO.print("Enter choice: ");  
            choice = getInt();   

            switch (choice) {
                case 1 -> {
                    //add resource
                    IO.println("Enter the name of the resource to add:");
                    String name = getString().toLowerCase();
                    Resource r = null;
                    for (Resource studentRes : results) {

                        if (studentRes.getName().toLowerCase().contains(name)) {
                            r = studentRes;
                            break;
                        }
                    }

                    if (r != null) {
                        StudentList.addResource(r);
                    } else {
                        IO.println("That resource was not in the filtered results.");
                    }
                }

                case 2 -> {
                    //remove resource from list
                    IO.println("Enter the name of the resource to remove:");
                    String name = getString();

                    // Call your new boolean method
                    boolean removed = StudentList.removeResource(name);

                    if (!removed) {
                        IO.println("No resource found with that name.");
                    }

                }

                case 3 -> {
                    //view student list
                    StudentList.viewStudentList();
                }

                case 4 -> {
                    //save list
                    try {
                        StudentList.saveStudentList();
                        // if caught, saves the details about the error 
                        // (i.e. stack trace, cause of error)
                        // and saves it to variable e
                    } catch (IOException e) {  
                        IO.println("Error saving file: " + e.getMessage()); //prints message to terminal and the error details
                    }
                    break;
                }

                case 0 -> running = false;

                default -> IO.println("Invalid choice.");

            }
        }
    }
}

