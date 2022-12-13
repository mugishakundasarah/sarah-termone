package com.example.backend;

public interface MathOperator {
    public double doMath();

    double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}
