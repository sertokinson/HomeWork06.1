package impl;

import java.io.Serializable;
import java.util.Objects;

public class Value implements Serializable {
    Object a;
    Object b;
    Operation operation;
    Object result;

    public Value(Object a, Object b, Operation operation, Object result) {
        this.a = a;
        this.b = b;
        this.operation = operation;
        this.result = result;
    }

    public Value(Object a, Object b, Operation operation) {
        this.a = a;
        this.b = b;
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value = (Value) o;
        return Objects.equals(a, value.a) &&
                Objects.equals(b, value.b) &&
                operation == value.operation;
    }

    @Override
    public int hashCode() {

        return Objects.hash(a, b, operation);
    }
}
