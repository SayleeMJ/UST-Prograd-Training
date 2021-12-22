package com.example.Calculator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Calculator {

    double a;
    double b;
    public  Calculator(@Value("${cal.a}") double a, @Value("${cal.b}") double b){
        this.a = a;
        this.b = b;
    }

    public  void setA(double a){
        this.a =a;
    }
    public double getA(){
        return a;
    }

    public  void setB(double b){
        this.b = b;
    }
    public double getB(){
        return b;
    }

    public double addition(){
        return a + b;
    }

    public  double subtraction(){
        return a - b;
    }

    public double multiplication(){
        return a * b;
    }

    public double division(){
        return a / b;
    }
}
