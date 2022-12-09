package com.example.adventofcode._2022.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import com.example.adventofcode._2022.CodeSnippetManager;


public class AdventOfCode_2022_07 {
    
    CodeSnippetManager codeSnippetManager = new CodeSnippetManager();
    HashMap<String, Long> directoryList = new HashMap<>();
    
    public void runScenario(){
        List<String[]> testList = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day7/TestInstructions.txt");
//        List<String> testList2 = retrieveInstructionsWithoutSplit("src/main/java/com/example/adventofcode/_2022/day7/TestInstructions.txt");
//        interpretInstructions(testList);
    
        System.out.println("---");
        
//        List<String[]> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day7/Instructions.txt");
//        List<String[]> list = retrieveInstructions("src/main/java/com/example/adventofcode/_2022/day7/Instructions.txt");
//        System.out.println(interpretInstructions(list));
    }
    
    private List<String[]> retrieveInstructions(String fileName) {
        List<String[]> newList = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println(data);
                newList.add(String.valueOf(data).split(""));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return newList;
    }
    
    private List<String> retrieveInstructionsWithoutSplit(String fileName) {
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
    
    //$ cd /
    //$ ls
    //dir a
    //14848514 b.txt
    //8504156 c.dat
    //dir d
    //$ cd a
    //$ ls
    //dir e
    //29116 f
    //2557 g
    //62596 h.lst
    //$ cd e
    //$ ls
    //584 i
    //$ cd ..
    //$ cd ..
    //$ cd d
    //$ ls
    //4060174 j
    //8033020 d.log
    //5626152 d.ext
    //7214296 k
    
    public class Directory {
        List<Directory> folders = new ArrayList<>();
        List<String> files = new ArrayList<>();
        Directory parent = null;
        String name = "";
        Long size = 0l;
        String path = "";
        
        public Directory(String name) {
            this.name = name;
            
        }
        public void addFile(String file) {
            files.add(file);
            size += Long.valueOf(file.split(" ")[0]);
//            if(parent!= null) {
//                parent.increaseSize(size);
//            }
        }
    
        public void addFolder(Directory folder) {
            folders.add(folder);
        }
        
        public List<Directory> getDirectories() {
            return  folders;
        }
    
        public List<String> getFiles() {
            return files;
        }
    
        public void setParent(Directory parent) {
            this.parent = parent;
        }
        
        public void setPath(){
            if(parent!= null && !parent.equals("") ) {
                this.path = parent.path + "." + name;
            }else {
                this.path = name;
            }
        }
    
        public Directory getParent() {
            return this.parent;
        }
        
        public Directory getDirectory(String name) {
            for (Directory folder:folders) {
                if(folder.name.equals(name)){
                    return folder;
                }
            }
            return null;
        }
        
        public void increaseSize(long size){
            this.size += size;
//            if(this.parent!= null) {
//                this.parent.increaseSize(size);
//            }
            
        }
    }
    
    private int interpretInstructions(List<String> instructionList) {
        
        Directory directory = new Directory("/");
        Directory activeDirectory = null;
        for (String line: instructionList) {
//            System.out.println("-->"+line);
            if(line.equals("$ cd /") ) {
                activeDirectory = directory;
            } else if(line.equals("$ ls")) {
                //will list contents now
            } else if(line.charAt(0) == '$') {
                if(line.contains("cd ..")) {
                    activeDirectory = activeDirectory.getParent();
                } else if(line.contains("$ cd")) {
                    Directory parent = activeDirectory;
                    activeDirectory = activeDirectory.getDirectory(line.substring(5));
                    activeDirectory.setParent(parent);
                    activeDirectory.setPath();
                }
            } else {
                if(line.contains("dir ")) {
                    activeDirectory.addFolder(new Directory(line.substring(4)));
                } else {
                    activeDirectory.addFile(line);
                }
            }
        }
    
        List<String> allParents = new ArrayList<>();
        allParents.add("TOP");
        calculateDirectoryContent(directory, allParents);
        
        long sum = 0l;
        List<Long> totalSizeList = new ArrayList<>();
        directoryList.remove("TOP");
        for(Long directoryItem : directoryList.values()) {
            System.out.print(directoryItem.longValue());
            if(directoryItem.longValue()>8381165){
                System.out.print("  -> ADDING: " + directoryItem.longValue());
                sum += directoryItem.longValue();
                totalSizeList.add(directoryItem.longValue());
            }
            System.out.println();
        }
        System.out.println("ANSWER: " + sum);
        totalSizeList.sort(Collections.reverseOrder());
        System.out.println(totalSizeList);
        
        int overlapping = 0;
        return overlapping;
    }
    
    private long calculateDirectoryContent(Directory currentDirectory, List<String> parents) {
//        HashMap<String, Long> stackList = new HashMap<>();
//        stackList.put(directory.name, directory.size);
        for (Directory childDirectory :currentDirectory.getDirectories()) {
            List<String> allParents = new ArrayList<>();
            allParents.addAll(parents);
            allParents.add(currentDirectory.path);
            calculateDirectoryContent(childDirectory, allParents);
        }
        System.out.println("Path: " + currentDirectory.path + ". Size " + currentDirectory.size + ". Parent " + parents);
    
        for (String parent : parents) {
            Long parentTotal = directoryList.get(parent);
            if(parentTotal!= null) {
                directoryList.replace(parent, parentTotal + currentDirectory.size);
            } else {
                directoryList.put(parent, currentDirectory.size);
            }
        }
        
        Long currentDirectoryTotal = directoryList.get(currentDirectory.path);
        if(currentDirectoryTotal!= null) {
            directoryList.replace(currentDirectory.path, currentDirectory.size+ currentDirectoryTotal);
        } else {
            directoryList.put(currentDirectory.path, currentDirectory.size);
        }
        
        return currentDirectory.size;
    }
    
    private boolean isUniqueList (List<String> characterList){
        for (int i = 0; i < characterList.size(); i++) {
            
            for (int j = 0; j < characterList.size(); j++) {
                if(i!=j) {
                    if(characterList.get(i).equals(characterList.get(j))) {
                        return false;
                    }
                }
            }
        }
       
        return true;
//        System.out.println(character1 + character2 + character3 + character4);
//        if(character1.equals(character2) || character1.equals(character3)|| character1.equals(character4)){
////            System.out.println("1");
//            return false;
//        }
//        else if(character2.equals(character1) || character2.equals(character3)|| character2.equals(character4)){
//            System.out.println("2");
//            return false;
//        }
//        else if(character3.equals(character1) || character3.equals(character2)|| character3.equals(character4)){
//            System.out.println("3");
//            return false;
//        }
//        else if(character4.equals(character1) || character4.equals(character2)|| character4.equals(character3)){
//            System.out.println("4");
//            return false;
//        }
//        return true;
    }
    private void printStack(List<String> stack) {
        System.out.println();
        for (String item:stack) {
            System.out.print(item + "");
        }
        
    }
    private String getFirstStack(List<String> stack) {
        System.out.println();
        for (String item:stack) {
            return item;
        }
        return "";
    }
    private void printAllStack(HashMap<Integer, List<String>> stackList) {
        printStack(stackList.get(1));
        printStack(stackList.get(2));
        printStack(stackList.get(3));
        printStack(stackList.get(4));
        printStack(stackList.get(5));
        printStack(stackList.get(6));
        printStack(stackList.get(7));
        printStack(stackList.get(8));
        printStack(stackList.get(9));
        
    }
    private String getAnswer(HashMap<Integer, List<String>> stackList) {
        return getFirstStack(stackList.get(1)) + getFirstStack(stackList.get(2)) + getFirstStack(stackList.get(3))+ getFirstStack(stackList.get(4)) + getFirstStack(stackList.get(5)) +getFirstStack(stackList.get(6)) + getFirstStack(stackList.get(7)) + getFirstStack(stackList.get(8)) + getFirstStack(stackList.get(9));

        
    }
    
}
