package edu.ucalgary.oop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;

public class PopulateGenderOptions {
    public static ArrayList<String> generateGenderOptions(String fileName){
        fileName = "edu/ucalgary/oop/" + fileName; 
        ArrayList<String> genderOptions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                line = line.replaceAll("\\s", "");
                line = line.replaceAll("gender", "");
                genderOptions.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return genderOptions;
    }  
}
