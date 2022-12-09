package com.example.adventofcode._2022.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.example.adventofcode._2022.CodeSnippetManager;


public class AdventOfCode_2022_08 {
    
    CodeSnippetManager codeSnippetManager = new CodeSnippetManager();
    HashMap<String, Long> directoryList = new HashMap<>();
    
    public void runScenario(){
        List<String[]> testList = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day8/Instructions.txt");
//        List<String> testList2 = retrieveInstructionsWithoutSplit("src/main/java/com/example/adventofcode/_2022/day8/TestInstructions.txt");
        interpretInstructions(testList);
    
        System.out.println("---");
        
//        List<String[]> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day8/Instructions.txt");
//        List<String[]> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day8/Instructions.txt");
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
        int sizeX = instructionList.size();
        int sizeY = instructionList.get(0).length;
        int maxScenicScore = 0;
        int amountVisible = 0;
        System.out.println("SizeX " + sizeX + ". Size Y " + sizeY);
        Integer[][] grid = new Integer[sizeX][sizeY];
    
        for (int i = 0; i < instructionList.size(); i++) {
            String[] line = instructionList.get(i);
            System.out.println();
            for (int j = 0; j < sizeX; j++) {
                grid[i][j] = Integer.valueOf(instructionList.get(i)[j]);
                System.out.print(grid[i][j]);
            }
        }
        System.out.println();
        for (int i = 1; i < sizeX-1; i++) {
            for (int j = 1; j < sizeY-1; j++) {
                int beautyLeft = 0;
                int beautyRight = 0;
                int beautyUp = 0;
                int beautyDown = 0;
                boolean visible = false;
                //look left
//                System.out.print("Look left ");
                for (int k = 1; k < j+1; k++) {
                    //run from 1 up to current position
                    if(grid[i][j-k] < grid[i][j]) {
//                        System.out.print(grid[i][j-k] + "<" + grid[i][j]+ " " );
                        beautyLeft+=1;
                        visible = true;
                    }else{
//                        System.out.print(" break ");
                        visible = false;
                        beautyLeft+=1;
                        break;
                    }
                }
                System.out.println();
                //look right
//                if(!visible) {
//                    System.out.print("Look right ");
                    for (int k = 1; k < sizeX-j ; k++) {
                        if(grid[i][j+k] < grid[i][j]) {
//                            System.out.print(grid[i][j+k] + "<" + grid[i][j]+ " " );
                            beautyRight+=1;
                            visible = true;
                        }else{
//                            System.out.print(" break ");
                            visible = false;
                            beautyRight+=1;
                            break;
                        }
                    }
//                }
                
                //look up
//                if(!visible) {
//                    for (int k = i; k >0 ; k--) {
//                        if(grid[i-k][j] < grid[i][j]) {
//                            visible = true;
//                            beautyUp+=1;
//                        }else{
//                            visible = false;
//                            break;
//                        }
//                    }
//                System.out.print("Look up ");
                for (int k = 1; k < i+1; k++) {
                    //run from 1 up to current position
                    if(grid[i-k][j] < grid[i][j]) {
//                                                System.out.print(grid[i-k][j] + "<" + grid[i][j]+ " " );
                        beautyUp+=1;
                        visible = true;
                    }else{
//                                                System.out.print(" break ");
                        visible = false;
                        beautyUp+=1;
                        break;
                    }
                }
//                }
                
                
                //look down
//                if(!visible) {
//                    if(!visible) {
//                        for (int k = 1; k < sizeX-i ; k++) {
//                            if(grid[i+k][j] < grid[i][j]) {
//                                beautyDown+=1;
//                                visible = true;
//                            }else{
//                                visible = false;
//                                break;
//                            }
//                        }
                for (int k = 1; k < sizeX-i ; k++) {
                    if(grid[i+k][j] < grid[i][j]) {
//                        System.out.print(grid[i][j+k] + "<" + grid[i][j]+ " " );
                        beautyDown+=1;
                        visible = true;
                    }else{
//                        System.out.print(" break ");
                        visible = false;
                        beautyDown+=1;
                        break;
                    }
                }
//                    }
//                }
                if(visible) {
                    amountVisible +=1;
                }
                int thisScenicScore = beautyLeft * beautyRight * beautyDown * beautyUp;
                if(thisScenicScore>maxScenicScore){
                    maxScenicScore = thisScenicScore;
                }
                System.out.println(grid[i][j] + " " +  " L" + beautyLeft + " R" +beautyRight +" U" + beautyUp +" D" + beautyDown);
//                System.out.println(grid[i][j] + "Is visible:" + visible + ". Amount visible: " + amountVisible + " L" + beautyLeft + " R" +beautyRight +" U" + beautyUp +" D" + beautyDown);
                
                
            }
        }
        amountVisible += sizeY -1;
        amountVisible += sizeY -1;
        amountVisible += sizeX -1;
        amountVisible += sizeX -1;
    
        System.out.println("Answer " +maxScenicScore);
        int overlapping = 0;
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
