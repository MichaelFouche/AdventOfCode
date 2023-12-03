package com.example.adventofcode.scribbles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class DelimitedList {
    
    String givenText = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
    
    public String solveDelimitedProblem(){
        return groupText(givenText);
    }
    
    private String groupText(String input) {
    
        String a  = "i";
        String text =  "listOfStrings";
        if(text.contains(a)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
        
        
        //Convert to array
        String[] stringListArray = input.split(",");
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(stringListArray));
        ArrayList<Integer> numberList = convertToIntegerList(stringList);
        
        //Sort the list
        Collections.sort(numberList);
    
        //Print the list
        for (Integer number:numberList) {
            System.out.print(number + " " );
        }
        
        //remove inner values
        System.out.println("");
        Integer previousValue = null;
        Integer currentValue = 0;
        Integer nextValue = 0;
        String previousAnswer = "";
        for (int i = 0; i < numberList.size(); i++) {
            Integer number = numberList.get(i);
            currentValue = number;
            nextValue = i+1 == numberList.size() ? null: numberList.get(i +1) ;
            String answer = (decideOutput(previousValue, currentValue, nextValue, previousAnswer));
            previousAnswer = answer;
            previousValue = currentValue;
    
            System.out.print(answer);
            
            
        }
        
        return null;
    }
    
    private String decideOutput(Integer previous, Integer current, Integer next, String previousAnswer) {
        String suffix = "";
        if(previousAnswer.contains("-")) {
            suffix = "";
        } else if (previousAnswer.contains(",")) {
            suffix = ",";
        } else if (previousAnswer.contains("")) {
            suffix = ",";
        }
        
        if(previous == null){
            return current + suffix;
        } else if (next == null) {
            return String.valueOf(current);
        } else if(previous+1 == current && current+1 == next){
            return "-";
        }
        return current + suffix;
    }
    
    //is part of pattern -> don't print
    //last value in list -> should print
    
    private ArrayList<Integer> convertToIntegerList(ArrayList<String> stringList) {
        ArrayList<Integer> numberList = new ArrayList<>();
        
        for (String number:stringList) {
            numberList.add(Integer.valueOf(number));
        }
        return numberList;
    }
    
    //Sort the list
    //remove inner values
    
}
