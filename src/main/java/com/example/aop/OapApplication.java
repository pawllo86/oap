package com.example.aop;

import com.example.aop.controller.AccountController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class OapApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OapApplication.class, args);

		AccountController controller = context.getBean(AccountController.class);
		controller.displayAccounts();
		controller.sumAccounts();
		controller.doRandomTransfer(1000);
		controller.displayAccounts();
		controller.sumAccounts();
	}
}
