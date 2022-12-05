package com.example.adventofcode._2022.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.adventofcode._2022.CodeSnippetManager;


public class AdventOfCode_2022_04 {
    
    CodeSnippetManager codeSnippetManager = new CodeSnippetManager();
    
    public void runScenario(){
        List<String[]> testList = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day4/TestInstructions.txt");
        interpretInstructions(testList);
    
        System.out.println("---");
        
        List<String[]> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day4/Instructions.txt");
        interpretInstructions(list);
    }
    
    private List<String[]> retrieveInstructions(String fileName) {
        List<String[]> newList = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println(data);
                newList.add(String.valueOf(data).split(","));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return newList;
    }
    
    
    private int interpretInstructions(List<String[]> instructionList) {
        int overlapping = 0;
        for (String[] elfSections :instructionList) {
//            System.out.print(elfSections[0] + " " + elfSections[1] + " ");
            String[] section1 = elfSections[0].split("-");
            String[] section2 = elfSections[1].split("-");
            
            String listOne = "";
            String listTwo = "";
            int start = Integer.valueOf(section1[0]);
            int end = Integer.valueOf(section1[1]);
    
            List<String> arrayListOne = new ArrayList<>();
            
            for (int i = start; i <= end; i++) {
                listOne +=  "," + i+ ",";
                arrayListOne.add(String.valueOf(i));
            }
            List<String> arrayListTwo = new ArrayList<>();
            int start2 = Integer.valueOf(section2[0]);
            int end2 = Integer.valueOf(section2[1]);
            for (int i = start2; i <= end2; i++) {
                listTwo +=  "," + i + ",";
                arrayListTwo.add(String.valueOf(i));
            }
    
            if(codeSnippetManager.isContained(arrayListOne, arrayListTwo)) {
                overlapping+=1;
            }
            
    
//            System.out.println();
//            if(listOne.contains(listTwo)) {
//                overlapping+=1;
//                System.out.print("YES--");
//            } else if (listTwo.contains(listOne)) {
//                overlapping+=1;
//                System.out.print("YES--");
//            } else {
//                System.out.print("NO --");
//            }
//            System.out.print(listOne + "  " + listTwo);
        }
        System.out.println();
        System.out.println(overlapping);
        return overlapping;
    }
    
    
    
}
