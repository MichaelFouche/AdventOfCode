package com.example.adventofcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AdventofcodeApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AdventofcodeApplication.class, args);
        
        AdventOfCode_2021_01 adventOfCode_2021_01 = new AdventOfCode_2021_01();
        System.out.println(adventOfCode_2021_01.countIncreases());
        System.out.println(adventOfCode_2021_01.countSumIncreases());
    }
    
}
