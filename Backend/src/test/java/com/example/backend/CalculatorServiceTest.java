package com.example.backend;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

@Test
public class CalculatorServiceTest {
    private MathOperatorImpl calculatorService;
    @Test(expectedExceptions = InvalidOperationException.class)
    public void shouldThrowExceptionOnDivideByZero() throws InvalidOperationException{
        calculatorService.doMath(1,0, "/");
    }

    public void shouldDisplayCorrectAnswerAfterDivision() throws InvalidOperationException{
        assertEquals(calculatorService.doMath(2, 2, "/"), 1, "Division not working");
    }

    public void shouldDisplayCorrectAnswerAfterMultiplication() throws InvalidOperationException{
        assertEquals(calculatorService.doMath(2, 2, "*"), 4, "Multiplication not working");
    }

    public void shouldDisplayCorrectAnswerAfterSubtraction() throws InvalidOperationException{
        assertEquals(calculatorService.doMath(2, 2, "-"), 0, "Subtraction not working");
    }

    public void shouldDisplayCorrectAnswerAfterAddition() throws InvalidOperationException{
        assertEquals(calculatorService.doMath(2, 2, "+"), 4, "Addition not working");
    }
}
