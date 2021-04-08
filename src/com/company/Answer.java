package com.company;
import java.io.Serializable;
import java.util.Objects;

public class Answer implements Serializable {
    private int result;

    public Answer(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return result == answer.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "result=" + result +
                '}';
    }
}