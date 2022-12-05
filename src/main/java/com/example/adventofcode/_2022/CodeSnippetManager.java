package com.example.adventofcode._2022;

import java.util.List;


public class CodeSnippetManager {
    
    public boolean isContained(List<String> arrayListOne , List<String> arrayListTwo) {
        for (String item:arrayListOne) {
            if(arrayListTwo.contains(item)){
                return true;
            }
        }
        for (String item:arrayListTwo) {
            if(arrayListOne.contains(item)){
                return true;
            }
        }
        return false;
    }
    
    public String getCommonLetter(String list1, String list2, String list3) {
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
    
}
