package com.example.adventofcode._2021.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class AdventOfCode_2021_02 {
    
    public void runScenario(){
        List<String> testList = retrieveInstructions("src/main/java/com/example/adventofcode/_2021/day2/day2TestInstructions.txt");
        interpretInstructions(testList);
        interpretAimInstructions(testList);
    
        List<String> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2021/day2/day2Instructions.txt");
        interpretInstructions(list);
        interpretAimInstructions(list);
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
        int horizontalPosition = 0;
        int verticalPosition = 0;
    
        for (String instructionLine: instructionList) {
            String[] instructions =  instructionLine.split(" ");
            switch (instructions[0]){
                case "forward": horizontalPosition += Integer.valueOf(instructions[1]);break;
                case "down": verticalPosition += Integer.valueOf(instructions[1]);break;
                case "up": verticalPosition -= Integer.valueOf(instructions[1]);break;
            }
        }
        System.out.println(horizontalPosition + "+" + verticalPosition + " = " + horizontalPosition * verticalPosition);
        return horizontalPosition * verticalPosition;
    }
    
    private int interpretAimInstructions(List<String> instructionList) {
        int horizontalPosition = 0;
        int verticalPosition = 0;
        int aim = 0;
        
        for (String instructionLine: instructionList) {
            String[] instructions =  instructionLine.split(" ");
            switch (instructions[0]){
                case "forward":
                    horizontalPosition += Integer.valueOf(instructions[1]);
                    verticalPosition += aim*Integer.valueOf(instructions[1]);
                    break;
                case "down":
                    aim += Integer.valueOf(instructions[1]);
                    break;
                case "up":
                    aim -= Integer.valueOf(instructions[1]);
                    break;
            }
        }
        System.out.println(horizontalPosition + "+" + verticalPosition + " = " + horizontalPosition * verticalPosition);
        return horizontalPosition * verticalPosition;
    }
    
    
}
