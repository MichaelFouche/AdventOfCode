package com.example.adventofcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.adventofcode._2021.day1.AdventOfCode_2021_01;
import com.example.adventofcode._2021.day2.AdventOfCode_2021_02;
import com.example.adventofcode._2021.day3.AdventOfCode_2021_03;


@SpringBootApplication
public class AdventofcodeApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AdventofcodeApplication.class, args);
        
        AdventOfCode_2021_01 day1 = new AdventOfCode_2021_01();
//        System.out.println(day1.countIncreases());
    
        AdventOfCode_2021_02 day2 = new AdventOfCode_2021_02();
//        day2.runScenario();
        
        AdventOfCode_2021_03 day3 = new AdventOfCode_2021_03();
        day3.runScenario();
        
    }
    
}
