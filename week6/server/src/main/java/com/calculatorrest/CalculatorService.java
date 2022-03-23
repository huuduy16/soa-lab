package com.calculatorrest;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public String calculate(Expression expression) {
        Integer a = expression.getNum0();
        Integer b = expression.getNum1();
        String operator = expression.getOperator();
        switch (operator) {
            case "+": {
                return String.valueOf(a + b);
            }
            case "-": {
                return String.valueOf(a - b);
            }
            case "*": {
                return String.valueOf(a * b);
            }
            case "/": {
                return String.valueOf(a / b);
            }
            case "**": {
                return String.valueOf(Math.pow(a, b));
            }
        }
        return "not recognize input";
    }
}
