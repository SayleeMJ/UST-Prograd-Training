package com.example.AOPDemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopDemoApplication {

	public static void main(String[] args) {
	ApplicationContext context = SpringApplication.run(AopDemoApplication.class, args);
		Student student = context.getBean(Student.class);
		student.show(2);
		student.notShown();
		student.shown();
	}

}
