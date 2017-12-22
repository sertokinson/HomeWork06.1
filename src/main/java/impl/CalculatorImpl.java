package impl;

import api.Calculator;

@Cash(typeCash = TypeCash.FILE)
public class CalculatorImpl implements Calculator {
    public Integer calc(Integer a, Operation operation, Integer b) {
        switch (operation){
            case ADDITION:
               return a+b;
            case MULTIPLE:
                return a*b;
            case DIVISION:
                return a/b;
            case SUBTRACTION:
                return a-b;
        }
        return null;
    }

    public Double calc(Double a, Operation operation, Double b) {
        switch (operation){
            case ADDITION:
                return a+b;
            case MULTIPLE:
                return a*b;
            case DIVISION:
                return a/b;
            case SUBTRACTION:
                return a-b;
        }
        return null;
    }

    public Double calc(Integer a, Operation operation, Double b) {
        switch (operation){
            case ADDITION:
                return a+b;
            case MULTIPLE:
                return a*b;
            case DIVISION:
                return a/b;
            case SUBTRACTION:
                return a-b;
        }
        return null;
    }

    public Double calc(Double a, Operation operation, Integer b) {
        switch (operation){
            case ADDITION:
                return a+b;
            case MULTIPLE:
                return a*b;
            case DIVISION:
                return a/b;
            case SUBTRACTION:
                return a-b;
        }
        return null;
    }
}
