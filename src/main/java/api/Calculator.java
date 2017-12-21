package api;

import impl.Operation;

import java.util.List;

public interface Calculator {
    Integer calc(Integer a, Operation operation, Integer b);
    Double calc(Double a,Operation operation,Double b);
    Double calc(Integer a,Operation operation,Double b);
    Double calc(Double a,Operation operation,Integer b);

}
