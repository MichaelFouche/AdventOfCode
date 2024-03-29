package com.example.adventofcode._2023.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AdventOfCode_2023_01 {
    
    public void runScenario(){
        List<String> testList = retrieveInstructions("src/main/java/com/example/adventofcode/_2023/day1/TestInstructions.txt");
//        interpretInstructions(testList);
    
        System.out.println("---2023---");
        
        List<String> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2023/day1/Instructions.txt");
        interpretInstructions(list);
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

    //loop through each position

    //replace the number at that position
    public String getCleanedLine(String instruction) {
        String cleanedLine ="";
        String[] value = instruction.split("");
        for (int i = 0; i < value.length; i++) {

            //if from that position we have the number
            //one
            int endLength = i+"one".length();
            if(! (endLength >value.length)) {
                String number = instruction.substring(i,endLength);
                if(number.equals("one")) {
                    instruction = instruction.substring(0,i) +1+ instruction.substring(i +1, value.length);
                    break;
                }
            }
            endLength = i+"two".length();
            if(! (endLength >value.length)) {
                String number = instruction.substring(i,endLength);
                if(number.equals("two")) {
                    instruction = instruction.substring(0,i) +2+ instruction.substring(i +1, value.length);
                    break;
                }
            }
            endLength = i+"three".length();
            if(! (endLength >value.length)) {
                String number = instruction.substring(i,endLength);
                if(number.equals("three")) {
                    instruction = instruction.substring(0,i) +3+ instruction.substring(i +1, value.length);
                    break;
                }
            }

            endLength = i+"four".length();
            if(! (endLength >value.length)) {
                String number = instruction.substring(i,endLength);
                if(number.equals("four")) {
                    instruction = instruction.substring(0,i) +4+ instruction.substring(i +1, value.length);
                    break;
                }
            }
            endLength = i+"five".length();
            if(! (endLength >value.length)) {
                String number = instruction.substring(i,endLength);
                if(number.equals("five")) {
                    instruction = instruction.substring(0,i) +5+ instruction.substring(i +1, value.length);
                    break;
                }
            }

            endLength = i+"six".length();
            if(! (endLength >value.length)) {
                String number = instruction.substring(i,endLength);
                if(number.equals("six")) {
                    instruction = instruction.substring(0,i) +6+ instruction.substring(i +1, value.length);
                    break;
                }
            }

            endLength = i+"seven".length();
            if(! (endLength >value.length)) {
                String number = instruction.substring(i,endLength);
                if(number.equals("seven")) {
                    instruction = instruction.substring(0,i) +7+ instruction.substring(i +1, value.length);
                    break;
                }
            }

            endLength = i+"eight".length();
            if(! (endLength >value.length)) {
                String number = instruction.substring(i,endLength);
                if(number.equals("eight")) {
                    instruction = instruction.substring(0,i) +8+ instruction.substring(i +1, value.length);
                    break;
                }
            }

            endLength = i+"nine".length();
            if(! (endLength >value.length)) {
                String number = instruction.substring(i,endLength);
                if(number.equals("nine")) {
                    instruction = instruction.substring(0,i) +9+ instruction.substring(i +1, value.length);
                    break;
                }
            }


        }
        return instruction;
    }

    
    
    private int interpretInstructions(List<String> instructionList) {
        int count = 0;
        int row = 0;

        for (String instruction: instructionList) {
            System.out.println("UNCLEANED LINE: " + instruction);
            while(containsNumber(instruction)) {
                instruction = getCleanedLine(instruction);
            }
            System.out.print("CLEANED LINE " +instruction);
            //if contains more numbers then run again




            List<String> innerList = new ArrayList<>();
            String[] value = instruction.split("");
            System.out.print (" Extracted [");
            for (int i = 0; i < value.length; i++) {
                int number = getValue(instruction.charAt(i));
                if(number==0) {
                    System.out.print(instruction.charAt(i));
                    innerList.add(String.valueOf(instruction.charAt(i)));
                }
            }
            System.out.print("] -> NUMBERS " + (innerList.get(0)) + innerList.get(innerList.size()-1));
            count = count + Integer.valueOf(innerList.get(0) + "" + innerList.get(innerList.size()-1));
            System.out.println(" row " + row + " -> COUNT = " +count);
            row = row +1;
//            System.out.println();
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
    
}
