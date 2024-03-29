package com.example.adventofcode._2023.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AdventOfCode_2023_02 {
    
    public void runScenario(){
        List<String> testList = retrieveInstructions("src/main/java/com/example/adventofcode/_2023/day2/TestInstructions.txt");
//        interpretInstructions(testList);
    
        System.out.println("---2023---");
        
        List<String> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2023/day2/Instructions.txt");
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
        int count = 0;
        int totalAnswer = 0;

//        Stream.of(instructionList).map(a -> a + "").collect(Collectors.toList());

        for (String instruction: instructionList) {

            String[] line = instruction.split(":");
            String[] gameNumberLine = line[0].split(" ");
            String gameNumber = gameNumberLine[1];
            String gameLine = line[1];
            String[] gameSets = gameLine.split(";");

            int blueLimit = 14;
            int redLimit = 12;
            int greenLimit = 13;


            System.out.println();
            System.out.println("GAME: "+ gameNumber + " " + gameLine);
            boolean gameIsPossible = true;
            int blueMax = 0;
            int redMax = 0;
            int greenMax = 0;
            for (String gameSetLine : gameSets) {
                int blueCount = 0;
                int redCount = 0;
                int greenCount = 0;




                // 3 blue, 4 red
                String[] gameValue = gameSetLine.split(",");
                for (String colours : gameValue) {
                    String[] colour = colours.split(" ");
                    String colourOfBlock = colour[2];
                    String amountOfBlocks = colour[1];
                    System.out.println("Amount:" +amountOfBlocks + ".Colour" + colourOfBlock);
                    if(colourOfBlock.equals("red")){
                        if(Integer.valueOf(amountOfBlocks) > redMax) {
                            redMax = Integer.valueOf(amountOfBlocks);
                        }
                    }
                    if(colourOfBlock.equals("blue")){
                        if(Integer.valueOf(amountOfBlocks) > blueMax) {
                            blueMax = Integer.valueOf(amountOfBlocks);
                        }
                    }
                    if(colourOfBlock.equals("green")){
                        if(Integer.valueOf(amountOfBlocks) > greenMax) {
                            greenMax = Integer.valueOf(amountOfBlocks);
                        }
                    }


                    if(colourOfBlock.equals("red") && Integer.valueOf(amountOfBlocks) > redLimit){
                        gameIsPossible = false;
                    }
                    if(colourOfBlock.equals("blue") && Integer.valueOf(amountOfBlocks) > blueLimit){
                        gameIsPossible = false;
                    }
                    if(colourOfBlock.equals("green") && Integer.valueOf(amountOfBlocks) > greenLimit){
                        gameIsPossible = false;
                    }

                }

            }
            if (gameIsPossible) {
                count = count + Integer.valueOf(gameNumber);
            }
            int powerOfCube = greenMax * blueMax * redMax;
            totalAnswer = totalAnswer + powerOfCube;
            System.out.println("Count" + count);
            System.out.println("Green: " + greenMax + " Blue: " + blueMax +  " Red: " + redMax + " Power: " + powerOfCube +" Final Answer: "+ totalAnswer );



        }
//        Collections.sort(newList, Collections.reverseOrder());

        return 0;
    }


    private List<String[]> retrieveSplitInstructions(String fileName) {
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

    private boolean containsNumber(String line) {
        return (line.contains("one") || line.contains("two") || line.contains("three") || line.contains("four") || line.contains("five") || line.contains("six") || line.contains("seven") || line.contains("eight") || line.contains("nine") );
    }

    private int replaceNumber(String scenario) {
        switch (scenario){
            case "one": return 1;
            case "two": return 2;
            case "three": return 3;
            case "four": return 4;
            case "five": return 5;
            case "six": return 6;
            case "seven": return 7;
            case "eight": return 8;
            case "nine": return 9;
        }
        return 99;
    }

    private int getValue(char letter) {
        switch (letter){
            case 'a': return 1;
            case '0': return 1;
            case 'b': return 2;
            case 'c': return 3;
            case 'd': return 4;
            case 'e': return 5;
            case 'f': return 6;
            case 'g': return 7;
            case 'h': return 8;
            case 'i': return 9;
            case 'j': return 10;
            case 'k': return 11;
            case 'l': return 12;
            case 'm': return 13;
            case 'n': return 14;
            case 'o': return 15;
            case 'p': return 16;
            case 'q': return 17;
            case 'r': return 18;
            case 's': return 19;
            case 't': return 20;
            case 'u': return 21;
            case 'v': return 22;
            case 'w': return 23;
            case 'x': return 24;
            case 'y': return 25;
            case 'z': return 26;
            case 'A': return 27;
            case 'B': return 28;
            case 'C': return 29;
            case 'D': return 30;
            case 'E': return 31;
            case 'F': return 32;
            case 'G': return 33;
            case 'H': return 34;
            case 'I': return 35;
            case 'J': return 36;
            case 'K': return 37;
            case 'L': return 38;
            case 'M': return 39;
            case 'N': return 40;
            case 'O': return 41;
            case 'P': return 42;
            case 'Q': return 43;
            case 'R': return 44;
            case 'S': return 45;
            case 'T': return 46;
            case 'U': return 47;
            case 'V': return 48;
            case 'W': return 49;
            case 'X': return 50;
            case 'Y': return 51;
            case 'Z': return 52;
        }
        return 0;
    }
    
}
