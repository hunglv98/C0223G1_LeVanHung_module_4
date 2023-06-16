package com.example.ex_2.service.impl;

import com.example.ex_2.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {
    @Override
    public String getResult(double num1, double num2, String calculation) {
        String result = "";
        switch (calculation) {
            case "Addition":
                result = String.valueOf(num1 + num2);
                break;
            case "Subtraction":
                result = String.valueOf(num1 - num2);
                break;
            case "Multiplication":
                result = String.valueOf(num1 * num2);
                break;
            default:
                if (num2 == 0) {
                    result = "Don't permit to divide by 0";
                } else result = String.valueOf(num1 / num2);
        }
        return result;
    }
}
