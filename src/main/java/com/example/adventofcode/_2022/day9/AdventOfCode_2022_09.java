package com.example.adventofcode._2022.day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.example.adventofcode._2022.CodeSnippetManager;


public class AdventOfCode_2022_09 {
    
    CodeSnippetManager codeSnippetManager = new CodeSnippetManager();
    HashMap<String, Long> directoryList = new HashMap<>();
    
    int x = 0;
    int y = 0;
    int tailX = 0;
    int tailY = 0;
    
    public void runScenario(){
        List<String[]> testList = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day9/Instructions.txt");
//        List<String> testList2 = retrieveInstructionsWithoutSplit("src/main/java/com/example/adventofcode/_2022/day9/TestInstructions.txt");
        interpretInstructions(testList);
    
        System.out.println("---");
        
//        List<String[]> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day9/Instructions.txt");
//        List<String[]> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day9/Instructions.txt");
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
                newList.add(String.valueOf(data).split(" "));
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
        List<String> listPositions = new ArrayList<>();
        List<String> filteredPositions = new ArrayList<>();
        String[][] grid = new String[100][100];
        x = 100;
        y = 100;
        tailX = 100;
        tailY = 100;
        listPositions.add(tailX + "," +tailY);
        for(String[] instruction: instructionList) {
            String direction = instruction[0];
            Integer moves = Integer.valueOf(instruction[1]);
            listPositions.addAll(doMoves(grid, direction, moves));
        }
        for (String position:listPositions) {
            if(!filteredPositions.contains(position)) {
                filteredPositions.add(position);
            }
            
        }
        System.out.println("Answer" + filteredPositions.size());
        
        return 0;
    }
    
    public List<String> doMoves(String[][] grid, String direction, int moves){
        List<String> uniquePositions = new ArrayList<>();
        for (int i = 0; i < moves; i++) {
            //move head
            switch (direction){
                case "R":
                    x+=1;
                    break;
                case "L":
                    x-=1;
                    break;
                case "U":
                    y-=1;
                    break;
                case "D":
                    y+=1;
                    break;
            }
            //if more than one away then go to previous position
            
            //2 left
            //2 right
            //2 up
            //2 down
            //2 left + 2up
            
            //2 right
            if(x == tailX+2 && y == tailY) {
                tailX +=1;
                uniquePositions.add(tailX + "," +tailY);
            }//2 left
            else if (x == tailX-2 && y == tailY){
                tailX -=1;
                uniquePositions.add(tailX + "," +tailY);
            }//2 down
            else if(y == tailY+2 && x == tailX) {
                tailY +=1;
                uniquePositions.add(tailX + "," +tailY);
            } //2 up
            else if (y == tailY-2 && x == tailX){
                tailY -=1;
                uniquePositions.add(tailX + "," +tailY);
            }
            
            //diagonal
            else if(x == tailX+2 && y == tailY-2) {
                tailX +=1;
                tailY -=1;
                uniquePositions.add(tailX + "," +tailY);
            } else if (x == tailX-2 && y == tailY-2){
                tailX -=1;
                tailY -=1;
                uniquePositions.add(tailX + "," +tailY);
            } else if(x == tailX+2 && y == tailY+2) {
                tailX +=1;
                tailY +=1;
                uniquePositions.add(tailX + "," +tailY);
            } else if (x == tailX-2 && y == tailY+2){
                tailX -=1;
                tailY +=1;
                uniquePositions.add(tailX + "," +tailY);
            }

            else if(x == tailX+2 && y == tailY+1) {
                tailX +=1;
                tailY +=1;
                uniquePositions.add(tailX + "," +tailY);
            }else if(x == tailX+1 && y == tailY+2) {
                tailY +=1;
                tailX +=1;
                uniquePositions.add(tailX + "," +tailY);
            }else if(x == tailX-1 && y == tailY+2) {
                tailY +=1;
                tailX -=1;
                uniquePositions.add(tailX + "," +tailY);
            }else if(x == tailX-2 && y == tailY+1) {
                tailX -=1;
                tailY +=1;
                uniquePositions.add(tailX + "," +tailY);
            }else if(x == tailX-2 && y == tailY-1) {
                tailX -=1;
                tailY -=1;
                uniquePositions.add(tailX + "," +tailY);
            }else if(x == tailX-1 && y == tailY-2) {
                tailY -=1;
                tailX -=1;
                uniquePositions.add(tailX + "," +tailY);
            }else if(x == tailX+1 && y == tailY-2) {
                tailY -=1;
                tailX +=1;
                uniquePositions.add(tailX + "," +tailY);
            }else if(x == tailX+2 && y == tailY-1) {
                tailX +=1;
                tailY -=1;
                uniquePositions.add(tailX + "," +tailY);
            }
            
            
        }
        for (String positions: uniquePositions) {
            System.out.println(positions);
        }
        return uniquePositions;
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
