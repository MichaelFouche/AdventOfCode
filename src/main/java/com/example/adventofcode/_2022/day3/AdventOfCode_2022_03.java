package com.example.adventofcode._2022.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AdventOfCode_2022_03 {
    
    public void runScenario(){
        List<String> testList = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day3/TestInstructions.txt");
        interpretInstructions(testList);
    
        System.out.println("---");
        
        List<String> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day3/Instructions.txt");
        interpretInstructions(list);
    }
    
    private List<String> retrieveInstructions(String fileName) {
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
    
    
    private int interpretInstructions(List<String> instructionList) {
        int total = 0;
        for (int i = 0; i < instructionList.size(); i+=3) {
            String letter = getCommonLetter(instructionList.get(i), instructionList.get(i+1), instructionList.get(i+2));
            int amount = getValue(letter.charAt(0));
            total += Integer.valueOf(amount);
        }
        System.out.println(total);
        return 0;
    }
    
    private String getCommonLetter(String list1, String list2, String list3) {
        String[] firstList = list1.split("");
        for (String item: firstList) {
            if(list2.contains(item)){
                for (String itemSecondCheck: firstList) {
                    if(list3.contains(itemSecondCheck)){
                        return item;
                    }
                }
            }
        }
        return "";
    }
    
    private int getValue(char letter) {
        switch (letter){
            case 'a': return 1;
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
