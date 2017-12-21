package impl;

import java.util.Objects;

public class Value {
    Object a;
    Object b;
    Operation operation;

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
