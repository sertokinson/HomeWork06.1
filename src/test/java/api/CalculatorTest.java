package api;

import impl.CalculatorImpl;
import impl.CashAnnotation;
import impl.Operation;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void calc() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Calculator calculator=context.getBean(Calculator.class);
        System.out.println( calculator.calc(1,Operation.ADDITION,2));
        calculator.calc(1,Operation.ADDITION,2);
        calculator.calc(1,Operation.ADDITION,2);
        calculator.calc(1,Operation.DIVISION,2);
        calculator.calc(3.0,Operation.DIVISION,2);
        calculator.calc(3.0,Operation.DIVISION,2);
    }


    }
