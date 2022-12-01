package com.example.adventofcode._2022.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class AdventOfCode_2022_01 {
    
    public void runScenario(){
        List<String> testList = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day1/TestInstructions.txt");
        interpretInstructions(testList);
    
        System.out.println("---");
        
        List<String> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day1/Instructions.txt");
        interpretInstructions(list);
    }
    
    private List<String> retrieveInstructions(String fileName) {
        List<String> newList = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
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
        int largestCalorieCount = 0;
        int currentElfTotalCalories = 0;
        List<Integer> newList = new ArrayList<>();
        
        for (String instruction: instructionList) {
            if (instruction.equals("")) {
                if(currentElfTotalCalories > largestCalorieCount) {
                    largestCalorieCount = currentElfTotalCalories;
//                    System.out.println(largestCalorieCount);
                }
                newList.add(currentElfTotalCalories);
                currentElfTotalCalories = 0;
            } else {
                currentElfTotalCalories += Integer.valueOf(instruction);
            }
        }
        Collections.sort(newList, Collections.reverseOrder());
        System.out.println("Largest " + newList.get(0));
        System.out.println("2nd Largest " + newList.get(1));
        System.out.println("3rd Largest " + newList.get(2));
    
        System.out.println("Sum of calories " + (newList.get(0) + newList.get(1) + newList.get(2)));
        return 0;
    }
    
}
