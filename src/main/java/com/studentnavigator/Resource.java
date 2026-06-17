package com.studentnavigator;

import java.util.List;

public class Resource {
    //fields
    private  String name; 
    private  int building;
    private  String room; 
    private  String phone;
    private  String hours;
    private  String email;
    private List<String> category;
    private  String description;

    //getters
    public String getName(){
        return name;
    }
    public int getBuilding(){
        return building;
    }
    public String getRoom(){
        return room;
    }
    public String getPhone(){
        return phone;
    }
    public String getHours(){
        return hours;
    }
    public List<String> getCategory(){
        return category;
    }
    public String getEmail(){
        return email;
    }
    public String getDescription(){
        return description;
    }

    //word wrap description
    public static String wrapText(String text, int width) {
        String result = "";
        String[] words = text.split(" ");
        String line = "";

        for (String word : words) {
            // If adding this word exceeds width, push the line to result
            if ((line + word).length() > width) {
                result += line + "\n";
                line = "";
            }
            line += word + " ";
        }

        // Add the last line
        if (!line.isEmpty()) {
            result += line + "\n";
        }

        return result;
    }
    //to String
    @Override
    public String toString() {
        String categoryString = String.join(", ", category);
        String wrappedDescription = wrapText(description, 60);

        String resourceString = """
            ===================================
            Resource: """ + name + "\n" +
                "Category: " + categoryString + "\n" +
                "Location: Building " + building + ", Room " + room + "\n" +
                "Hours:    " + hours + "\n" +
                "Contact:  (" + phone + " / " + email + ")\n" +
                "Details:  " + wrappedDescription + "\n" +
                "===================================";

        return resourceString;
    }
}