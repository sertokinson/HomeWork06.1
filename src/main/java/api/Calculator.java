package api;

import impl.Operation;

public interface Calculator {
    void calc(Integer a, Operation operation, Integer b);
    void calc(Double a,Operation operation,Double b);
    void calc(Integer a,Operation operation,Double b);
    void calc(Double a,Operation operation,Integer b);

}
