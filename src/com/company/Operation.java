package com.company;

import java.io.Serializable;
import java.util.Objects;

public class Operation implements Serializable {
    private final int firstOpernad;
    private final int secondOperand;
    private final String operation;

    public Operation(int firstOpernad, int secondOperand, String operation) {
        this.firstOpernad = firstOpernad;
        this.secondOperand = secondOperand;
        this.operation = operation;
    }

    public int getFirstOpernad() {
        return firstOpernad;
    }

    public int getSecondOperand() {
        return secondOperand;
    }

    public String getOperation() {
        return operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation1 = (Operation) o;
        return firstOpernad == operation1.firstOpernad && secondOperand == operation1.secondOperand && Objects.equals(operation, operation1.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstOpernad, secondOperand, operation);
    }

    @Override
    public String toString() {
        return "Operation{" +
                "firstOpernad=" + firstOpernad +
                ", secondOperand=" + secondOperand +
                ", operation='" + operation + '\'' +
                '}';
    }
}