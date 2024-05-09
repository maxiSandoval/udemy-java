package com.udemy.java.assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FirstNameAssignment {

    public static void main(String[] args) throws IOException {

        // Path txt file
        Path path = Paths
                .get("C:\\Source\\udemy-java\\src\\main\\java\\com\\udemy\\java\\resources\\data\\first-names.txt");

        List<String> firstNames = Files.readAllLines(path);

        // print the count of names which start with B
        long countNamesB = firstNames.stream()
                .filter(s -> s.startsWith("B"))
                .count();

        System.out.println("Count Names starting with 'B': " + countNamesB);

        // create a list of names which start with C and contains 's' in it
        List<String> newNames = firstNames.stream()
                .filter(s -> s.startsWith("C"))
                .filter(s -> s.toLowerCase().contains("s"))
                .collect(Collectors.toList());

        System.out.println("Number of names starting with 'C' and contains an 's': " + newNames.size());

        // print the total number of chars for all the names starting with M
        int sum = firstNames.stream()
                .filter(s -> s.startsWith("M"))
                .map(String::trim) // good practice for strings
                .map(String::length) // obtain length of string
                .mapToInt(i -> i) // convert to integer object
                .sum(); // sum all the chars

        // .forEach(s -> System.out.println(s + " : total number of chars : " +
        // s.length()));
        System.out.println("Total sum of chars: " + sum);

        // Jo-ann => jo Ann
        // find the names containing - in it and replace it with a space; collect them
        // into a list

        List<String> names = firstNames.stream()
                .filter(s -> s.contains("-"))
                .map(s -> s.replaceAll("-", " "))
                .collect(Collectors.toList());

        System.out.println("Formating names: " + names);

        // find the name which has more number of chars

        String longer = firstNames.stream()
                    .max(Comparator.comparing(s -> s.length()))
                    .get();

        System.out.println("Total sum of chars: " + longer);
    }
}
