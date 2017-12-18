package api;

import impl.CalculatorImpl;
import impl.Operation;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void calc() throws Exception {
        Calculator calculator = new CalculatorImpl();
        calculator.calc(3, Operation.Division, 2);
        calculator.calc(3.0,Operation.Division,2.0);
        calculator.calc(3.0,Operation.Division,2);
        calculator.calc(3,Operation.Division,2.0);
    }
    }
