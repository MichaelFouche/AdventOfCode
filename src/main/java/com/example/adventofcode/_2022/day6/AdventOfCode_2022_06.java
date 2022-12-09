package com.example.adventofcode._2022.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.example.adventofcode._2022.CodeSnippetManager;


public class AdventOfCode_2022_06 {
    
    CodeSnippetManager codeSnippetManager = new CodeSnippetManager();
    
    public void runScenario(){
//        List<String[]> testList = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day6/TestInstructions.txt");
        List<String[]> testList2 = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day6/TestInstructions.txt");
        System.out.println(interpretInstructions(testList2));
    
        System.out.println("---");
        
//        List<String[]> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day5/Instructions.txt");
//        List<String[]> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day6/Instructions.txt");
//        System.out.println(interpretInstructions(list));
    }
    
    private List<String[]> retrieveInstructions(String fileName) {
        List<String[]> newList = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println(data);
                newList.add(String.valueOf(data).split(""));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return newList;
    }
    
    private List<String> retrieveInstructionsWithoutSplit(String fileName) {
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
    
    private int interpretInstructions(List<String[]> instructionList) {
        int overlapping = 0;
//        List<String> characterList = new ArrayList<>();
        
//        String character1 = "";
//        String character2 = "";
//        String character3 = "";
//        String character4 = "";
        String[] characters = instructionList.get(0);
        System.out.println("There is amount of characters:" + characters.length);
        for (int i = 14; i < characters.length; i++) {
            List<String> characterList = new ArrayList<>();
            for (int j = 14; j >0; j--) {
                System.out.print(characters[i-j]);
                characterList.add(characters[i-j]);
            }
            System.out.println();
//            character1 = characters[i-3];
//            character2 = characters[i-2];
//            character3 = characters[i-1];
//            character4 = characters[i];
            
            if(isUniqueList(characterList)) {
                System.out.println("The answer is:" + i);
                return i;
            }
            
        }
        return overlapping;
    }
    
    private boolean isUniqueList (List<String> characterList){
        for (int i = 0; i < characterList.size(); i++) {
            
            for (int j = 0; j < characterList.size(); j++) {
                if(i!=j) {
                    if(characterList.get(i).equals(characterList.get(j))) {
                        return false;
                    }
                }
            }
        }
       
        return true;
//        System.out.println(character1 + character2 + character3 + character4);
//        if(character1.equals(character2) || character1.equals(character3)|| character1.equals(character4)){
////            System.out.println("1");
//            return false;
//        }
//        else if(character2.equals(character1) || character2.equals(character3)|| character2.equals(character4)){
//            System.out.println("2");
//            return false;
//        }
//        else if(character3.equals(character1) || character3.equals(character2)|| character3.equals(character4)){
//            System.out.println("3");
//            return false;
//        }
//        else if(character4.equals(character1) || character4.equals(character2)|| character4.equals(character3)){
//            System.out.println("4");
//            return false;
//        }
//        return true;
    }
    
    private void printStack(List<String> stack) {
        System.out.println();
        for (String item:stack) {
            System.out.print(item + "");
        }
        
    }
    
    private String getFirstStack(List<String> stack) {
        System.out.println();
        for (String item:stack) {
            return item;
        }
        return "";
    }
    private void printAllStack(HashMap<Integer, List<String>> stackList) {
        printStack(stackList.get(1));
        printStack(stackList.get(2));
        printStack(stackList.get(3));
        printStack(stackList.get(4));
        printStack(stackList.get(5));
        printStack(stackList.get(6));
        printStack(stackList.get(7));
        printStack(stackList.get(8));
        printStack(stackList.get(9));
        
    }
    
    private String getAnswer(HashMap<Integer, List<String>> stackList) {
        return getFirstStack(stackList.get(1)) + getFirstStack(stackList.get(2)) + getFirstStack(stackList.get(3))+ getFirstStack(stackList.get(4)) + getFirstStack(stackList.get(5)) +getFirstStack(stackList.get(6)) + getFirstStack(stackList.get(7)) + getFirstStack(stackList.get(8)) + getFirstStack(stackList.get(9));

        
    }
    
}
