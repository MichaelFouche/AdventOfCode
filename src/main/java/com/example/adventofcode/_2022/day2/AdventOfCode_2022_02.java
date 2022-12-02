package com.example.adventofcode._2022.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AdventOfCode_2022_02 {
    
    public void runScenario(){
        List<String[]> testList = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day2/TestInstructions.txt");
        interpretInstructions(testList);
    
        System.out.println("---");
        
        List<String[]> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day2/Instructions.txt");
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
        int total = 0;
        for (String[] instruction: instructionList) {
            int result = 0;
            switch (instruction[0]){
                case "A": result = game("ROCK", instruction[1]);break;
                case "B": result = game("PAPER", instruction[1]);break;
                case "C": result = game("SCISSORS", instruction[1]) ;break;
            }
            total += result;
        }
        System.out.println(total);
        return 0;
    }
    
    private int game(String a, String b) {
        /**
         * POINTS:      0 if you lost, 3 if the round was a draw, and 6 if you won).
         * PLUS:        1 for Rock, 2 for Paper, and 3 for Scissors
         *
         * RULES:       Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock.
         *
         * KEY:         A for Rock,B for Paper,C for Scissors.
         * Challenge A: X for Rock, Y for Paper, and Z for Scissors.
         * Challenge B:
         *              X means you need to lose,
         *              Y means you need to end the round in a draw,
         *              Z means you need to win.
         */
        
        int win = 6;
        int draw = 3;
        int lose = 0;
        
        int rock = 1;
        int paper = 2;
        int scissors = 3;
        
        if(a.equals("ROCK") && b.equals("Z")) {
            return win + paper;
        }
        if(a.equals("PAPER") && b.equals("Z")) {
            return win + scissors;
        }
        if(a.equals("SCISSORS") && b.equals("Z")) {
            return win + rock;
        }
    
        if(a.equals("ROCK") &&  b.equals("Y")) {
            return draw + rock;
        }
        if(a.equals("PAPER") && b.equals("Y")) {
            return draw + paper;
        }
        if(a.equals("SCISSORS") && b.equals("Y")) {
            return draw + scissors;
        }
    
        if(a.equals("ROCK") &&  b.equals("X")) {
            return lose + scissors;
        }
        if(a.equals("PAPER") && b.equals("X")) {
            return lose + rock;
        }
        if(a.equals("SCISSORS") && b.equals("X")) {
            return lose + paper;
        }
        return 0;
    }
    
}
