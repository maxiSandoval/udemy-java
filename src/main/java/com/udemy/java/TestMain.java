package com.udemy.java;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.java.calculator.MathOperation;
import com.udemy.java.lambda.StringOperations;

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

        // stream vs loop 
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        // loop
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0 ) {
                System.out.println(Math.pow(list.get(i), 2));
            }
        }

        // stream pipeline
        // it have intermediate operations and terminal operations
        // for the stream to work, ther must be a terminal operation at the end
        list.stream()
                .skip(1) // skip N received data in order of receipt
                .peek(i ->  System.out.println("filter-received :: " + i)) // to debug
                .filter(i -> i % 2 == 0) // Used for filtering data, must be true to pass 
                .limit(3) // limit the data
                .sorted() // // sort the stream, the sorted data depends on other operations
                .peek(i ->   System.out.println("map-received :: " + i)) // to debug
                .map(i -> i * i ) //  Used to transform data using Functions
                .forEach(i -> System.out.println(i)); // terminal operation

    }
}
