package impl;

import api.Calculator;

public class CalculatorImpl implements Calculator {

    public void calc(Integer a, Operation operation, Integer b) {
        switch (operation){
            case Addition:
                System.out.println(a+b);
                break;
            case Multiple:
                System.out.println(a*b);
                break;
            case Division:
                System.out.println(a/b);
                break;
            case Subtraction:
                System.out.println(a-b);
        }
    }

    public void calc(Double a, Operation operation, Double b) {
        switch (operation){
            case Addition:
                System.out.println(a+b);
                break;
            case Multiple:
                System.out.println(a*b);
                break;
            case Division:
                System.out.println(a/b);
                break;
            case Subtraction:
                System.out.println(a-b);
        }

    }

    public void calc(Integer a, Operation operation, Double b) {
        switch (operation){
            case Addition:
                System.out.println(a+b);
                break;
            case Multiple:
                System.out.println(a*b);
                break;
            case Division:
                System.out.println(a/b);
                break;
            case Subtraction:
                System.out.println(a-b);
        }
    }

    public void calc(Double a, Operation operation, Integer b) {
        switch (operation){
            case Addition:
                System.out.println(a+b);
                break;
            case Multiple:
                System.out.println(a*b);
                break;
            case Division:
                System.out.println(a/b);
                break;
            case Subtraction:
                System.out.println(a-b);
        }
    }
}
