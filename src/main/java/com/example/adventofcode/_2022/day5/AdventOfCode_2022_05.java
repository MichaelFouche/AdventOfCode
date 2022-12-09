package com.example.adventofcode._2022.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.example.adventofcode._2022.CodeSnippetManager;


public class AdventOfCode_2022_05 {
    
    CodeSnippetManager codeSnippetManager = new CodeSnippetManager();
    
    public void runScenario(){
        List<String[]> testList = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day5/TestInstructions.txt");
        List<String> testList2 = retrieveInstructionsWithoutSplit("src/main/java/com/example/adventofcode/_2022/day5/TestInstructions.txt");
//        interpretInstructions(testList, testList2);
    
        System.out.println("---");
        
        List<String[]> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day5/Instructions.txt");
        List<String> list2 = retrieveInstructionsWithoutSplit("src/main/java/com/example/adventofcode/_2022/day5/Instructions.txt");
        interpretInstructions(list, list2);
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
    
    private int interpretInstructions(List<String[]> instructionList, List<String> instructionList2) {
        int overlapping = 0;
    
        List<String> stack1 = new ArrayList<>();
        List<String> stack2 = new ArrayList<>();
        List<String> stack3 = new ArrayList<>();
        List<String> stack4 = new ArrayList<>();
        List<String> stack5 = new ArrayList<>();
        List<String> stack6 = new ArrayList<>();
        List<String> stack7 = new ArrayList<>();
        List<String> stack8 = new ArrayList<>();
        List<String> stack9 = new ArrayList<>();
    
        for (int i = 0; i < 8; i++) {
            
            String[] line = instructionList.get(i);
//            String line2 = line[i].split("")
            for (int j = 0; j < line.length; j++) {
                if(String.valueOf(line[j]).equals(" ")) {
                
                }
                else if(j==1){
                    stack1.add(String.valueOf(line[j]));
                }
                else if(j==5){
                    stack2.add(String.valueOf(line[j]));
                }
                else if(j==9){
                    stack3.add(String.valueOf(line[j]));
                }
                else if(j==13){
                    stack4.add(String.valueOf(line[j]));
                }else if(j==17){
                    stack5.add(String.valueOf(line[j]));
                }else if(j==21){
                    stack6.add(String.valueOf(line[j]));
                }else if(j==25){
                    stack7.add(String.valueOf(line[j]));
                }else if(j==29){
                    stack8.add(String.valueOf(line[j]));
                }else if(j==33){
                    stack9.add(String.valueOf(line[j]));
                }
                String column = line[j];
                System.out.print(" " + column);
            }
            System.out.println();
        }
        printStack(stack1);
        printStack(stack2);
        printStack(stack3);
    
        HashMap<Integer, List<String>> stackList = new HashMap<>();
        stackList.put(1, stack1);
        stackList.put(2, stack2);
        stackList.put(3, stack3);
        stackList.put(4, stack4);
        stackList.put(5, stack5);
        stackList.put(6, stack6);
        stackList.put(7, stack7);
        stackList.put(8, stack8);
        stackList.put(9, stack9);
    
    
        for (int i = 10; i < instructionList2.size(); i++) {
            String line = instructionList2.get(i);
            int board = 5;
            int boardFrom = line.indexOf("from")+5;
            int boardTo = line.indexOf("to")+3;
    
            System.out.println();
            System.out.print(instructionList2.get(i) + ":  ");
            
            int boardToMove = Integer.valueOf(instructionList2.get(i).substring(board,line.indexOf("from")-1));
            int boardMoveFrom = Integer.valueOf(instructionList2.get(i).substring(boardFrom,line.indexOf("to")-1));
            int boardMoveTo = Integer.valueOf(instructionList2.get(i).substring(boardTo));
    
            System.out.print(boardToMove + " ");
            System.out.print(boardMoveFrom  + " ");
            System.out.print(boardMoveTo  + " ");
    
            List<String> movingFromStack = stackList.get(boardMoveFrom);
            List<String> movingToStack = stackList.get(boardMoveTo);
            printAllStack(stackList);
            List<String> itemsWeAreGoingToMove = new ArrayList<>();
            for (int j = 0; j < boardToMove; j++) {
                itemsWeAreGoingToMove.add(0,movingFromStack.get(j));
            }
            for (int j = 0; j < itemsWeAreGoingToMove.size(); j++) {
                movingToStack.add(0,itemsWeAreGoingToMove.get(j));
            }
            int startingSize = movingFromStack.size();
            for (int j = 0; j < boardToMove; j++) {
                movingFromStack.remove((0));
            }
//            printStack(movingFromStack);
//            printStack(movingToStack);
    
            stackList.replace(boardMoveFrom, movingFromStack);
            stackList.replace(boardMoveTo, movingToStack);
            
        }
    
        System.out.println("----");
        printAllStack(stackList);
        System.out.println();
        System.out.println("Answer "+getAnswer(stackList));
        return overlapping;
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
