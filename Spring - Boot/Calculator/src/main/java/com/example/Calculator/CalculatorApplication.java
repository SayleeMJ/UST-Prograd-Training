package com.example.Calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class CalculatorApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(CalculatorApplication.class, args);
		Calculator calculator = applicationContext.getBean(Calculator.class);
		double addition = calculator.addition();
		System.out.println("Addition: " + addition);

		double subtraction = calculator.subtraction();
		System.out.println("Subtraction: " + subtraction);

		double multiplication = calculator.multiplication();
		System.out.println("Multiplication: " + multiplication);

		double division = calculator.division();
		System.out.println("Division: " + division);
	}
}
