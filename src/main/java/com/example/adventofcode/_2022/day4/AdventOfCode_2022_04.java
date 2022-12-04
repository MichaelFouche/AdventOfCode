package com.example.adventofcode._2022.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AdventOfCode_2022_04 {
    
    public void runScenario(){
        List<String> testList = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day4/TestInstructions.txt");
        interpretInstructions(testList);
    
        System.out.println("---");
        
        List<String> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day4/Instructions.txt");
        interpretInstructions(list);
    }
    
    private List<String> retrieveInstructions(String fileName) {
        List<String> newList = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println(data);
                newList.add(String.valueOf(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return newList;
    }
    
    
    private int interpretInstructions(List<String> instructionList) {
        int total = 0;
        System.out.println(total);
        return 0;
    }
    
    
}
