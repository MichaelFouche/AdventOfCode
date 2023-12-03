package com.example.adventofcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.adventofcode._2021.day1.AdventOfCode_2021_01;
import com.example.adventofcode._2021.day2.AdventOfCode_2021_02;
import com.example.adventofcode._2021.day3.AdventOfCode_2021_03;
import com.example.adventofcode._2022.day1.AdventOfCode_2022_01;
import com.example.adventofcode._2022.day10.AdventOfCode_2022_10;
import com.example.adventofcode._2022.day2.AdventOfCode_2022_02;
import com.example.adventofcode._2022.day3.AdventOfCode_2022_03;
import com.example.adventofcode._2022.day4.AdventOfCode_2022_04;
import com.example.adventofcode._2022.day5.AdventOfCode_2022_05;
import com.example.adventofcode._2022.day6.AdventOfCode_2022_06;
import com.example.adventofcode._2022.day8.AdventOfCode_2022_08;
import com.example.adventofcode._2022.day9.AdventOfCode_2022_09;
import com.example.adventofcode._2023.day1.AdventOfCode_2023_01;
import com.example.adventofcode._2023.day2.AdventOfCode_2023_02;
import com.example.adventofcode._2023.day3.AdventOfCode_2023_03;


@SpringBootApplication
public class AdventofcodeApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AdventofcodeApplication.class, args);
        
        AdventOfCode_2021_01 day1 = new AdventOfCode_2021_01();
//        System.out.println(day1.countIncreases());
    
        AdventOfCode_2021_02 day2 = new AdventOfCode_2021_02();
//        day2.runScenario();
        
        AdventOfCode_2021_03 day3 = new AdventOfCode_2021_03();
//        day3.runScenario();
    
        AdventOfCode_2022_01 day1_2022 = new AdventOfCode_2022_01();
//        day1_2022.runScenario();
        
        AdventOfCode_2022_02 day2_2022 = new AdventOfCode_2022_02();
//        day2_2022.runScenario();
        
        AdventOfCode_2022_03 day3_2022 = new AdventOfCode_2022_03();
//        day3_2022.runScenario();
        
        AdventOfCode_2022_04 day4_2022 = new AdventOfCode_2022_04();
//        day4_2022.runScenario();
        
        AdventOfCode_2022_05 day5_2022 = new AdventOfCode_2022_05();
//        day5_2022.runScenario();
    
        AdventOfCode_2022_06 day6_2022 = new AdventOfCode_2022_06();
//        day6_2022.runScenario();
    
//        day7_2022.runScenario();
    
        AdventOfCode_2022_08 day8_2022 = new AdventOfCode_2022_08();
//        day8_2022.runScenario();
    
    
        AdventOfCode_2022_09 day9_2022 = new AdventOfCode_2022_09();
//        day9_2022.runScenario();
    
        AdventOfCode_2022_10 day10_2022 = new AdventOfCode_2022_10();
//        day10_2022.runScenario();

        AdventOfCode_2023_01 day01_2023 = new AdventOfCode_2023_01();
//        day01_2023.runScenario();

        AdventOfCode_2023_02 day02_2023 = new AdventOfCode_2023_02();
//        day02_2023.runScenario();

        AdventOfCode_2023_03 day03_2023 = new AdventOfCode_2023_03();
        day03_2023.runScenario();
    
//        DelimitedList delimitedList = new DelimitedList();
//        delimitedList.solveDelimitedProblem();
    
    }
    
}
