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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentList{
    //create file to save student list to
    private static final List<Resource> studentResources = new ArrayList<>();
   
    //add Resource
    public static void addResource(Resource r) {
        studentResources.add(r);
        IO.println("Resource added to your list: " + r.getName());
    }

    //remove resources
    public static boolean removeResource(String name) {
        //Iterator iterates over a collection of objects
        Iterator<Resource> iterator = studentResources.iterator();

        //while loop iterates through resources in list until user choice is found and removed
        while (iterator.hasNext()) {
            Resource r1 = iterator.next();

            if (r1.getName().toLowerCase().contains(name.toLowerCase())) {
                iterator.remove();
                IO.println("Removed: " + r1.getName());
                return true;
            }
        }

        return false;
    }

    public static void viewStudentList(){
        if (studentResources.isEmpty()) {
            IO.println("Your student list is empty.");
            return;
        }

        IO.println("\n\n=== Your Saved Resources ===");
        for (Resource r : studentResources) {
            IO.println(r);
        }
    }

    public static void saveStudentList() throws IOException{
        //null check
        if (studentResources.isEmpty()) {
            IO.println("Your student list is empty.");
            return;
        }
        //checks if there is a home folder
        String home = System.getProperty("user.home");
        File dir = new File(home + "/Documents");

        if (!dir.exists()) { //if there isn't a documents folder, make one
            dir.mkdirs();
        }

        File SAVED_FILE = new File(dir, "MySavedResources.txt");
        //create new file if not already made
        if (SAVED_FILE.createNewFile()) {
                System.out.println("File created in 'Documents' folder: " + SAVED_FILE.getName());
            } else {
                System.out.println("Editing current resource file.");
            }

        //try with resources - automatically closes resource after try block completes
        try ( 
                FileWriter writer = new FileWriter(SAVED_FILE)) {
            for (Resource r : studentResources) {
                writer.write(r.toString());
                writer.write("\n\n"); // spacing between entries
            }
        }
            IO.println("Student list saved to " + SAVED_FILE);

        }
    }
    