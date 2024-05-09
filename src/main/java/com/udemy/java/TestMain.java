package com.udemy.java;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.collect.Comparators;
import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.java.calculator.MathOperation;
import com.udemy.java.compare.Student;
import com.udemy.java.lambda.StringOperations;
import com.udemy.java.util.LinkUtil;

public class TestMain {

    private static final List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        // to quickly test

        // StringOperations op1 = (s) -> s.ToUpperCase;
        // StringOperations op1 = String::toUpperCase;

        // StringOperations op1 = (s, s2) -> s1.concat(s2);
        // StringOperations op1 = String::concat;

        // StringOperations op1 = (s) -> list.add(s);
        // StringOpe rations op1 = list::add;

        // MathOperation add = (i1, i2) -> i1 + i2;

        // Supplier<Double> random = Math::random;
        // System.out.println(random.get());

        /*
         * Consumer
         * list.add("maxi");
         * list.add("javi");
         * 
         * Consumer<String> dbConsumer = (s) -> {
         * System.out.println("I am writing into DB :: " + s);
         * };
         * 
         * Consumer<String> loggingConsumer = (s) -> {
         * System.out.println("I am writing into log file :: " + s);
         * };
         * 
         * Consumer<String> dbLogConsumer = dbConsumer.andThen(loggingConsumer);
         */

        /*
         * Predicate<Integer> isGT2 = (n) -> n > 2;
         * Predicate<Integer> isLT10 = (n) -> n < 10;
         * 
         * // System.out.println(isLT10.test(55));
         * System.out.println(isGT2.and(isLT10).test(3));
         * System.out.println(isGT2.negate().test(3));
         */
        /*
         * Function<String, Integer> strLen = String::length;
         * Function<Integer, Integer> plus2 = (i) -> i + 2;
         * Function<Integer, Integer> square = (i) -> i * i;
         * 
         * System.out.println(
         * // strLen.andThen(square).apply("Helloo how are you doing")
         * plus2.compose(square).apply(8)
         * 
         * // andThen a.andThen(b) => a -> b
         * // compose a.compose(b) => b -> a
         * );
         */

        /*
         * // Runnable
         * 
         * Runnable run = () -> {
         * Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
         * System.out.println("Hello");
         * };
         * 
         * new Thread(run).start();
         */
        /*
         * // Callable
         * 
         * Supplier<Double> random1 = Math::random;
         * Callable<Double> random2 = Math::random;
         * 
         * System.out.println(random1.get());
         * System.out.println(random2.call());
         */
        /*
         * // stream vs loop
         * List<Integer> list = new ArrayList<>();
         * list.add(1);
         * list.add(2);
         * list.add(3);
         * list.add(4);
         * list.add(5);
         * list.add(6);
         * list.add(7);
         * list.add(8);
         * list.add(9);
         * 
         * // loop
         * for (int i = 0; i < list.size(); i++) {
         * if (list.get(i) % 2 == 0 ) {
         * System.out.println(Math.pow(list.get(i), 2));
         * }
         * }
         * 
         * // stream pipeline
         * // it have intermediate operations and terminal operations
         * // for the stream to work, ther must be a terminal operation at the end
         * list.stream()
         * .skip(1) // skip N received data in order of receipt
         * .peek(i -> System.out.println("filter-received :: " + i)) // to debug
         * .filter(i -> i % 2 == 0) // Used for filtering data, must be true to pass
         * .limit(3) // limit the data
         * .sorted() // // sort the stream, the sorted data depends on other operations
         * .peek(i -> System.out.println("map-received :: " + i)) // to debug
         * .map(i -> i * i ) // Used to transform data using Functions
         * .forEach(i -> System.out.println(i)); // terminal operation
         */

        /*
         * // flatmap
         * 
         * List<Integer> a = new ArrayList<>();
         * a.add(1);
         * a.add(2);
         * a.add(3);
         * 
         * List<Integer> b = new ArrayList<>();
         * b.add(4);
         * b.add(5);
         * b.add(6);
         * 
         * List<Integer> c = new ArrayList<>();
         * c.add(7);
         * c.add(8);
         * c.add(9);
         * 
         * List<List<Integer>> list = new ArrayList<>();
         * list.add(a);
         * list.add(b);
         * list.add(c);
         * 
         * list.stream()
         * .flatMap(l -> l.stream()) // convert list of lists in a single list with all
         * values contained in it
         * .map(i -> i * i)
         * .forEach(System.out::println);
         */
        /*
         * List<String> l = new ArrayList<>();
         * l.add("apple");
         * l.add("ball");
         * l.add("cat");
         * l.add("dog");
         * 
         * System.out.println(
         * l.stream()
         * .filter(s -> s.length() > 3)
         * // .count() // count items of list
         * // .findFirst() // return Optional[] find first element
         * // .min(Comparator.reverseOrder()) // return first value from a specific
         * order
         * // .max(Comparator.reverseOrder()) // return last value from a specific order
         * // .get() // return value from optional
         * // .anyMatch(s -> s.contains("e")) // at least one match
         * .noneMatch(s -> s.contains("e")) // none match
         * );
         */

        /*
         * // how to return an optional
         * Optional<String> op = l.stream()
         * .filter(s -> s.length() > 3)
         * .findFirst();
         * 
         * if (op.isPresent()) {
         * System.out.println(op.get());
         * }
         */

        /*
         * // obtain response code using LinkUtil class
         * System.out.println(
         * LinkUtil.getResponseCode("https://www.google.com/fvdfg/dfg")
         * );
         */

        /*
         * // Collectors
         * List<String> list = new ArrayList<>();
         * list.add("apple");
         * list.add("apple");
         * list.add("airplane");
         * list.add("ball");
         * list.add("boy");
         * list.add("cat");
         * list.add("dog");
         * list.add("delta");
         * 
         * // toList
         * List<String> newList = list.stream()
         * .filter(s -> s.length() > 3)
         * .collect(Collectors.toList());
         * 
         * // toSet
         * Set<String> newSet = list.stream()
         * .filter(s -> s.length() > 3)
         * .collect(Collectors.toSet()); // doesn't allow duplicate values
         * // joining
         * String joinedString = list.stream()
         * .filter(s -> s.length() > 3)
         * .collect(Collectors.joining(";")); // concatenated words
         * 
         * // groupingBy
         * Map<Integer, List<String>> map = list.stream()
         * .collect(Collectors.groupingBy(s -> s.length()));
         * 
         * Map<Character, List<String>> mapChar = list.stream()
         * .collect(Collectors.groupingBy(s -> s.charAt(0)));
         * 
         * // System.out.println("Original :: " + list);
         * // System.out.println("New set :: " + newSet);
         * // System.out.println("New list :: " + newList);
         * // System.out.println("Joining words :: " + joinedString);
         * System.out.println("groupingBy :: " + map);
         * System.out.println("groupingBy :: " + mapChar);
         */

        /*
         * //****** usage example of optional with streams
         * List<Integer> listOfFive = List.of(1, 2, 3, 4, 5);
         * 
         * Optional<Integer> firstEven = listOfFive.stream()
         * .filter(i -> i % 2 == 0)
         * .findFirst();
         * 
         * 
         * Optional<Integer> anyEven = listOfFive.stream()
         * .filter(i -> i % 2 == 0)
         * .findAny();
         * 
         * // conventional approach
         * if (firstEven.isPresent()) {
         * System.out.println("first even: " + firstEven.get());
         * }
         * 
         * // approach with functional style
         * anyEven.ifPresent(n -> System.out.println("any even: " + n));
         */

        /*
         * // compare
         * Student a = new Student("Adam", 80, 150);
         * Student b = new Student("Bob", 96, 123);
         * Student c = new Student("Carl", 75, 135);
         * 
         * Optional<Student> op = Stream.of(a, b, c)
         * .min(Comparator.comparing(s -> s.getScore()));
         * 
         * System.out.println(op.get());
         */

         // sum using stream
         List<Integer> list = new ArrayList<>();
         Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);

       /*  // 1st aproach
        int sum = 0;

        for (int i : list) {
            sum = sum +i;
        } */

/*         // 2nd approach, stream. mapTo...
        // has 3 primitive types to use: int, long, double
        int sum = list.stream()
                        .mapToInt(a -> a)
                        .sum();

        System.out.println(sum); */

        // loop can be replace for IntStream
        // for
        for (int j = 0; j < 10; j++) {
            System.out.println("Hello : " + j);
        }

        // IntStream
        // IntStream.range(0, 10) // exclude 10
        IntStream.rangeClosed(1, 10) // include 10
                    .forEach(i -> System.out.println("Hello : " + i));



    }

}
