package com.example.adventofcode._2021.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AdventOfCode_2021_03 {
    
    public void runScenario(){
        List<String[]> testList = retrieveInstructions("src/main/java/com/example/adventofcode/_2021/day3/TestInstructions.txt");
        interpretInstructions(testList);
    
        List<String[]> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2021/day3/Instructions.txt");
        interpretInstructions(list);
    }
    
    private List<String[]> retrieveInstructions(String fileName) {
        List<String[]> newList = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                newList.add(String.valueOf(data).split(""));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return newList;
    }
    
    
    private int interpretInstructions(List<String[]> instructionList) {
        String gammaRate = "";
        String epsilonRate = "";
    
        for (int i = 0; i < instructionList.get(0).length; i++) {
            //Iterate over the columns
            int zeroCount = 0;
            int oneCount = 0;
            for (int j = 0; j < instructionList.size(); j++) {
                //Iterate down the rows
                if(instructionList.get(j)[i].equals("0")) {
                    zeroCount +=1;
                } else {
                    oneCount +=1;
                }
            }
            if(zeroCount>oneCount) {
                gammaRate += "0";
                epsilonRate += "1";
            } else {
                gammaRate += "1";
                epsilonRate += "0";
            }
        }
    
        System.out.println("Gamma rate " + gammaRate + ": " + Integer.parseInt(gammaRate,2));
        System.out.println("Epsilon rate " + epsilonRate + ": " + Integer.parseInt(epsilonRate,2));
        System.out.println("Power " + Integer.parseInt(gammaRate,2) * Integer.parseInt(epsilonRate,2));
    
        return 0;
    }
    
}
