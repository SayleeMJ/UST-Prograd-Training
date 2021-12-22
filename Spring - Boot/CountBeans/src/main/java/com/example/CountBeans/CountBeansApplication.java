package com.example.CountBeans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class CountBeansApplication {
		public static void main(String[] args) throws Exception {
		ApplicationContext appContext = SpringApplication.run(CountBeansApplication.class, args);
		AtomicInteger count = new AtomicInteger();
		String[] beans = appContext.getBeanDefinitionNames();
		for(String beanName : beans) {
			System.out.println(beanName);
			count.getAndIncrement();
		}
		System.out.println("\n\nCount Using automatic incrementing: " +count);

		int countofbeans = appContext.getBeanDefinitionCount();
		System.out.println("\n\nCount Using function getBeanDefinitionCount: " + countofbeans);
	}
}
