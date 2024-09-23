package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(TrafficFortuneService trafficFortuneService) {
		return runner -> {
			//demoTheBeforAdvice(accountDAO, membershipDAO);
			//demoTheAfterReturingAdvice(accountDAO);
			//demoTheAfterThrowingAdvice(accountDAO);
			//demoTheAfterAdvice(accountDAO);

			//demoTheAroundAdvice(trafficFortuneService);

			//demoTheAroundAdviceHandleException(trafficFortuneService);

			demoTheAroundAdviceReThrowException(trafficFortuneService);
		};
	}

	private void demoTheAroundAdviceReThrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceReThrowException");

		System.out.println("Calling getFortune");

		boolean tripWire = true;

		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is:" + data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");

		System.out.println("Calling getFortune");

		boolean tripWire = true;

		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is:" + data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdvice");

		System.out.println("Calling getFortune");

		String data = trafficFortuneService.getFortune();

		System.out.println("\nMy fortune is:" + data);
		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;

		try {
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(false);
		}
		catch (Exception e) {
			System.out.println("\n\nMain Program: ... caught an exception\n" + e);
		}
		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("----");

		System.out.println(accounts);

		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;

		try {
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		}
		catch (Exception e) {
			System.out.println("\n\nMain Program: ... caught an exception\n" + e);
		}
		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("----");

		System.out.println(accounts);

		System.out.println("\n");
	}

	private void demoTheAfterReturingAdvice(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterReturingAdvice");
		System.out.println("----");

		System.out.println(accounts);

		System.out.println("\n");


	}

	private void demoTheBeforAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// call the business method
		Account account = new Account();
		account.setName("John Doe");
		account.setLevel("Gold");
		accountDAO.addAccount(account, true);
		accountDAO.doWork();

		// call the accountdao getter/setter methods
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");

		String name = accountDAO.getName();
		System.out.println(name);

		String serviceCode = accountDAO.getServiceCode();
		System.out.println(serviceCode);

		membershipDAO.addSilliyMember();
		membershipDAO.goToSleep();
	}

}
