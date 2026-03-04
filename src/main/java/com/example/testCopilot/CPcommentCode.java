package com.example.testCopilot;

public class CPcommentCode {

    // add two numbers and return the result
    public int add(int a, int b) {
        return a + b;
        }

    // calculator functions that takes two numbers and an operator and returns the result as string
    public String calculator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return String.valueOf(add(a, b));
            case "-":
                return String.valueOf(a - b);
            case "*":
                return String.valueOf(a * b);
            case "/":
                if (b == 0) {
                    return "Cannot divide by zero";
                }
                return String.valueOf(a / b);
            default:
                return "Invalid operator";
        }
    }

}
