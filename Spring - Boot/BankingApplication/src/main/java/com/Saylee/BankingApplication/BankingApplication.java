package com.Saylee.BankingApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.lang.String;

@SpringBootApplication
public class BankingApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BankingApplication.class, args);
		Customer customer1 = context.getBean(Customer.class);
		Customer customer2 = context.getBean(Customer.class);

		customer1.setClientId(101);
		customer1.setName("Saylee");
		customer1.setContact(2901234);
		customer1.setAccountNo(12345);
		customer1.setBalance(20000);
	//	customer1.setBranch("Pune");
		customer1.clientDetails();

		customer2.setClientId(102);
		customer2.setName("Bhushan");
		customer2.setContact(2910293);
		customer2.setAccountNo(123456);
		customer2.setBalance(1000000);
	//	customer2.setBranch("Pune");
		customer2.clientDetails();

	}
}
