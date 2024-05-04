package com.udemy.java.calculator;

public class TestMain {

    public static void main(String[] args) {

        /*
         * 2nd assignment
         * // MathOperation add = (i1, i2) -> i1 + i2;
         * MathOperation add = Integer::sum;
         * MathOperation substract = (i1, i2) -> i1 - i2;
         * MathOperation multiply = (i1, i2) -> i1 * i2;
         * MathOperation divide = (i1, i2) -> i1 / i2;
         * 
         * int onScreenNumber = 0;
         * 
         * onScreenNumber = calculate(5, add, 2);
         * onScreenNumber = calculate(onScreenNumber, substract, 3);
         * onScreenNumber = calculate(onScreenNumber, multiply, 7);
         * onScreenNumber = calculate(onScreenNumber, add, 2);
         * onScreenNumber = calculate(onScreenNumber, divide, 3);
         * 
         * 
         * System.out.println("result:: " + onScreenNumber);
         */

        String exp = "9 * 9 - 1 * 7 / 8 + 30 ^ 2 % 3";

        Calculator.addOperation("^", (a, b) -> (int) Math.pow(a, b));
        Calculator.addOperation("%", (a, b) -> a % b);

        System.out.println(
                Calculator.calculate(exp)
        );
    }

    /*
     * 1st assignment
     * private static int calculate(MathOperation mathOperation){
     * int a = 100;
     * int b = 5;
     * return mathOperation.operate(a, b);
     * }
     */

}
