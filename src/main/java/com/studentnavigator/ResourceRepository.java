package com.studentnavigator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ResourceRepository{
    //fields
    private static final String FILE_PATH = "resourcelist.json";
    private static final ObjectMapper resourceMapper = new ObjectMapper(); //ObjectMapper - translates JSON files into Java Objects
    private static List<Resource> fullList;

    //creates an ArrayList for full list of resources
    private static List<Resource> createArrayList() throws IOException{
        if(fullList == null) {
            Resource[] resourceArray = resourceMapper.readValue(new File(FILE_PATH), Resource[].class);
            fullList = new ArrayList<>(Arrays.asList(resourceArray));
        }
        
        return fullList;        
    }

    //getter
    public static List<Resource> getAllResources() throws IOException{
        return createArrayList();
    }
}

