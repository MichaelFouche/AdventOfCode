package com.example.adventofcode._2022.day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import com.example.adventofcode._2022.CodeSnippetManager;


public class AdventOfCode_2022_09 {
    
    CodeSnippetManager codeSnippetManager = new CodeSnippetManager();
    HashMap<String, Long> directoryList = new HashMap<>();
    
    Integer[][] tailList = new Integer[11][2];
    HashMap<Integer, HashSet<String>> uniqueTailPositions = new HashMap<>();
    
    public void runScenario(){
        List<String[]> testList = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day9/Instructions.txt");//Instructions
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
        for (int i = 0; i < 11; i++) {
            tailList[i][0] = 100;
            tailList[i][1] = 100;
            HashSet<String> list = new HashSet<>();
            list.add("100,100");
            uniqueTailPositions.put(i, list);
        }
        for(String[] instruction: instructionList) {
            String direction = instruction[0];
            Integer moves = Integer.valueOf(instruction[1]);
            doMoves(direction, moves);
        }
        
        List<String> filteredPositions = new ArrayList<>();
        for (String position:uniqueTailPositions.get(8)) {
            if(!filteredPositions.contains(position)) {
                filteredPositions.add(position);
            }
        }
        System.out.println("Answer: " + filteredPositions.size());
        System.out.println();
        return 0;
    }
    
    public void doMoves(String direction, int moves){
        for (int i = 0; i < moves; i++) {
            for (int j = 0; j < 10; j++) {
                HashSet<String> uniquePositions = new HashSet<>();
                int x = tailList[j][0];
                int y = tailList[j][1];
                int tailX = tailList[j+1][0];
                int tailY = tailList[j+1][1];
                
                //MOVE HEAD
                if(j==0) {
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
                }
                //MOVE TAIL
                
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
        
                //one is 2 out and one is one out
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
                tailList[j][0] = x;
                tailList[j][1] = y;
                tailList[j+1][0] = tailX;
                tailList[j+1][1] = tailY;
                HashSet<String> tempList = uniqueTailPositions.get(j);
                if(tempList == null){
                    uniqueTailPositions.put(j, uniquePositions);
                }else {
                    tempList.addAll(uniquePositions);
                    uniqueTailPositions.put(j, tempList);
                }
            }
        }
    }
    
}
