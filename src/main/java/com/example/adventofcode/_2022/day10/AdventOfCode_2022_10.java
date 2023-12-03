package com.example.adventofcode._2022.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import com.example.adventofcode._2022.CodeSnippetManager;


public class AdventOfCode_2022_10 {
    
    CodeSnippetManager codeSnippetManager = new CodeSnippetManager();
    HashMap<String, Long> directoryList = new HashMap<>();
    
    Integer[][] tailList = new Integer[11][2];
    HashMap<Integer, HashSet<String>> uniqueTailPositions = new HashMap<>();
    
    int sum = 0;
    
    public void runScenario(){
        List<String[]> testList = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day10/TestInstructions.txt");//TestInstructions
        interpretInstructions(testList);
    }
    
    private List<String[]> retrieveInstructions(String fileName) {
        List<String[]> newList = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                newList.add(String.valueOf(data).split(" "));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return newList;
    }
    
    
    private int interpretInstructions(List<String[]> instructionList) {
        
        int iterator = 0;
        int total = 1;
        int x = 0;
        for(String[] instruction: instructionList) {
            if(!instruction[0].contains("noop")) {
                iterator = addIterator(iterator, x);
                iterator = addIterator(iterator, x);
                String direction = instruction[0];
                Integer amount = Integer.valueOf(instruction[1]);
                total += amount;
                x = total;
                System.out.println(iterator + ": NV:" +direction + "[" + amount + "]" +  "[" + total + "]");
            } else {
                x = total;
                System.out.println(iterator + "NOOP " + x);
                iterator = addIterator(iterator, x);
            }
//            iterator = addIterator(iterator, sum, x);
        }
        
        System.out.println();
        return 0;
    }
    
    private int addIterator(int iterator, int x) {
        iterator +=1;
        if(iterator == 20 || iterator == 60 || iterator == 100 || iterator == 140 || iterator == 180 || iterator == 220) {
        
            int strength = (x * iterator);
            sum += strength;
            System.out.println(iterator + "TOTAL [" + strength + "]" + sum);
        }
        return iterator;
    }
    
}
