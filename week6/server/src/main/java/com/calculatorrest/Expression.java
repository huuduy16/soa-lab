package com.calculatorrest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Expression {

    private Integer num0;
    private Integer num1;
    private String operator;
}