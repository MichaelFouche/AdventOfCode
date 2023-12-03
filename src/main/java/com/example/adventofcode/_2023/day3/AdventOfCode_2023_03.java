package com.example.adventofcode._2023.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class AdventOfCode_2023_03 {
    
    public void runScenario(){
        List<String> testList = retrieveInstructions("src/main/java/com/example/adventofcode/_2023/day3/TestInstructions.txt");
//        interpretInstructions(testList);
    
        System.out.println("---2023 day 3---");
        
        List<String> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2023/day3/Instructions.txt");
        interpretInstructions(list);
        //528369
        //Part 2
        //84907342
        //84900879
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
        List<Integer> validNumbers = new ArrayList();
        Map<Integer, Integer> gearMultiplierCount = new HashMap<>();


        //BUILD MATRIX
        int rowLength = instructionList.size();
        int columnLength = instructionList.get(0).length();
        String[][] matrix = new String[rowLength][columnLength];
        for (int i = 0; i < rowLength; i++) {
            String instruction = instructionList.get(i);
            String[] columnLine = instruction.split("");
            for (int j = 0; j < columnLength; j++) {
                matrix[i][j] = columnLine[j];
            }
        }

        //PRINT MATRIX
        System.out.println("\nPRINTING MATRIX\n----");
        for (int i = 0; i < rowLength; i++) {
            System.out.println();
            for (int j = 0; j < columnLength; j++) {
                System.out.print(matrix[i][j]);
            }

        }



        //FIND ALL * and confirm if they have 2 numbers.
        //ADD numbers to whiteList
        //If number is in whiteList then use
        //NEED TO group numbers next to * as they need to add up together.


        int gearCount = 0;
        String[][] matrixWhiteList = new String[rowLength][columnLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if(matrix[i][j].equals("*") && countAdjacentNumber(matrix, i, j)==2 ){
                    try{matrixWhiteList[i-1][j-1] = String.valueOf(gearCount);}catch (Exception e) {}
                    try{matrixWhiteList[i][j-1] = String.valueOf(gearCount);}catch (Exception e) {}
                    try{matrixWhiteList[i+1][j-1] = String.valueOf(gearCount);}catch (Exception e) {}

                    try{matrixWhiteList[i-1][j] = String.valueOf(gearCount);}catch (Exception e) {}
                    try{matrixWhiteList[i][j] = String.valueOf(gearCount);}catch (Exception e) {}
                    try{matrixWhiteList[i+1][j] = String.valueOf(gearCount);}catch (Exception e) {}

                    try{matrixWhiteList[i-1][j+1] = String.valueOf(gearCount);}catch (Exception e) {}
                    try{matrixWhiteList[i][j+1] = String.valueOf(gearCount);}catch (Exception e) {}
                    try{matrixWhiteList[i+1][j+1] = String.valueOf(gearCount);}catch (Exception e) {}
                    gearCount = gearCount +1;
                }
            }

        }

        //PRINT WHITE MATRIX
        System.out.println("\nPRINTING WhiteList MATRIX");
        for (int i = 0; i < rowLength; i++) {
            System.out.println();
            for (int j = 0; j < columnLength; j++) {
                if(matrixWhiteList[i][j] != null) {
                    System.out.print(matrixWhiteList[i][j]);
                } else {
                    System.out.print(".");
                }
            }

        }

        System.out.println("\n\nGETTING NUMBERS\n----");
        //GET NUMBERS
        int rowPosition = 0;

        for (String instruction: instructionList) {
            instruction = instruction + ".";
            String[] line = instruction.split("");
            String numberBuilder = "";
            boolean previousWasNumber = false;
            boolean hadSymbolNextToNumber = false;
            boolean numberIsOnWhiteList = false;
            int columnPosition = 0;
            int gearNumber = 0;
            for (String linePosition : line) {
                if (containsNumericNumber(linePosition)) {
                    numberBuilder = numberBuilder + linePosition;
                    previousWasNumber = true;
                    if(checkIfHasSymbol(matrix, rowPosition, columnPosition)) {
                        hadSymbolNextToNumber = true;
                        if(matrixWhiteList[rowPosition][columnPosition]!= null) {
                            numberIsOnWhiteList = true;
                            gearNumber = Integer.valueOf(matrixWhiteList[rowPosition][columnPosition]);
                        }
                    }
//                    System.out.print("["+rowPosition +""+ columnPosition+ "]");
                } else if (previousWasNumber){
                    if(hadSymbolNextToNumber) {
                        //check number is on whiteList
                        if(numberIsOnWhiteList) {
                            validNumbers.add(Integer.valueOf(numberBuilder));
                            if(gearMultiplierCount.get(gearNumber) != null){
                                gearMultiplierCount.replace(gearNumber, gearMultiplierCount.get(gearNumber) * Integer.valueOf(numberBuilder));
                            } else {
                                gearMultiplierCount.put(gearNumber, Integer.valueOf(numberBuilder));
                            }
                        }
                    }
                    previousWasNumber = false;
                    hadSymbolNextToNumber = false;
                    numberIsOnWhiteList = false;
                    numberBuilder = "";

                }
                System.out.print(linePosition);
                columnPosition = columnPosition +1;

            }

            System.out.println();
            rowPosition = rowPosition +1;
        }
        System.out.println();

        //ALL THE NUMBERS
        int sum = 0;
        for (int number: validNumbers) {
            sum = sum + number;
            System.out.println(number);
        }


        System.out.println("\nSUM: " + sum);
//        Collections.sort(newList, Collections.reverseOrder());
        Integer newCount = 0;
        for (int gearSums:gearMultiplierCount.values()) {
            System.out.println("RATIOS: " + gearSums);
            newCount = newCount + gearSums;
        }
        System.out.println("GEAR COUNT " + newCount);

        return 0;
    }


    private int countAdjacentNumber(String[][] matrix, int rowPosition, int columnPosition) {
        int numbersAdjacent = 0;
        boolean hasSymbol = false;
        boolean hadNumberLeftTop = false;
        boolean hadNumberCenterTop = false;
        boolean hadNumberLeftBottom = false;
        boolean hadNumberCenterBottom = false;

        //TOP
        try {if (containsNumericNumber(matrix[rowPosition - 1][columnPosition - 1])) {numbersAdjacent = numbersAdjacent +1;hadNumberLeftTop = true;}} catch (Exception e) {}
        try {if (containsNumericNumber(matrix[rowPosition-1][columnPosition])) {
            if(!hadNumberLeftTop) {
                numbersAdjacent = numbersAdjacent +1;
            }
            hadNumberCenterTop = true;
        }} catch (Exception e) {}
        try {if (containsNumericNumber(matrix[rowPosition - 1][columnPosition + 1])) {
            if(!hadNumberCenterTop) {
                numbersAdjacent = numbersAdjacent +1;
            }
        }} catch (Exception e) {}

        //MIDDLE
        try {if (containsNumericNumber(matrix[rowPosition][columnPosition -1])) {numbersAdjacent = numbersAdjacent +1;}} catch (Exception e) {}
        try {if (containsNumericNumber(matrix[rowPosition][columnPosition +1])) {numbersAdjacent = numbersAdjacent +1;}} catch (Exception e) {}

        //BOTTOM
        try {if (containsNumericNumber(matrix[rowPosition + 1][columnPosition -1])) {numbersAdjacent = numbersAdjacent +1;hadNumberLeftBottom = true;}} catch (Exception e) {}
        try {if (containsNumericNumber(matrix[rowPosition +1 ][columnPosition])) {
            if(!hadNumberLeftBottom) {
                numbersAdjacent = numbersAdjacent +1;
            }
            hadNumberCenterBottom = true;
        }} catch (Exception e) {}
        try {if (containsNumericNumber(matrix[rowPosition + 1][columnPosition +1])) {
            if(!hadNumberCenterBottom) {
                numbersAdjacent = numbersAdjacent +1;
            }
        }} catch (Exception e) {}

        return numbersAdjacent;
    }

    private boolean checkIfHasNumber(String[][] matrix, int rowPosition, int columnPosition) {

        boolean hasSymbol = false;
        try {if (containsNumericNumber(matrix[rowPosition - 1][columnPosition - 1])) {return true;}} catch (Exception e) {}
        try {if (containsNumericNumber(matrix[rowPosition][columnPosition - 1])) {return true;}} catch (Exception e) {}
        try {if (containsNumericNumber(matrix[rowPosition + 1][columnPosition - 1])) {return true;}} catch (Exception e) {}

        try {if (containsNumericNumber(matrix[rowPosition - 1][columnPosition ])) {return true;}} catch (Exception e) {}
        try {if (containsNumericNumber(matrix[rowPosition ][columnPosition ])) {return true;}} catch (Exception e) {}
        try {if (containsNumericNumber(matrix[rowPosition + 1][columnPosition ])) {return true;}} catch (Exception e) {}

        try {if (containsNumericNumber(matrix[rowPosition - 1][columnPosition +1])) {return true;}} catch (Exception e) {}
        try {if (containsNumericNumber(matrix[rowPosition ][columnPosition +1])) {return true;}} catch (Exception e) {}
        try {if (containsNumericNumber(matrix[rowPosition + 1][columnPosition +1])) {return true;}} catch (Exception e) {}

        return hasSymbol;
    }

    private boolean checkIfHasSymbol(String[][] matrix, int rowPosition, int columnPosition) {

        boolean hasSymbol = false;
        try {if (containsSymbol(matrix[rowPosition - 1][columnPosition - 1])) {return true;}} catch (Exception e) {}
        try {if (containsSymbol(matrix[rowPosition][columnPosition - 1])) {return true;}} catch (Exception e) {}
        try {if (containsSymbol(matrix[rowPosition + 1][columnPosition - 1])) {return true;}} catch (Exception e) {}

        try {if (containsSymbol(matrix[rowPosition - 1][columnPosition ])) {return true;}} catch (Exception e) {}
        try {if (containsSymbol(matrix[rowPosition ][columnPosition ])) {return true;}} catch (Exception e) {}
        try {if (containsSymbol(matrix[rowPosition + 1][columnPosition ])) {return true;}} catch (Exception e) {}

        try {if (containsSymbol(matrix[rowPosition - 1][columnPosition +1])) {return true;}} catch (Exception e) {}
        try {if (containsSymbol(matrix[rowPosition ][columnPosition +1])) {return true;}} catch (Exception e) {}
        try {if (containsSymbol(matrix[rowPosition + 1][columnPosition +1])) {return true;}} catch (Exception e) {}

        return hasSymbol;
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

    private boolean containsSymbol(String line) {
        return (!line.contains(".") && !containsNumericNumber(line) );
    }

    private boolean containsNumericNumber(String line) {
        return (line.contains("1") || line.contains("2") || line.contains("3") || line.contains("4") || line.contains("5") || line.contains("6") || line.contains("7") || line.contains("8") || line.contains("9")|| line.contains("0") );
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
