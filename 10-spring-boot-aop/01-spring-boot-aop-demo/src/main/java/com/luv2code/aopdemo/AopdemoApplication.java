package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountDAO accountDAO , MembershipDAO membershipDAO) {
		return runner -> {
			demoTheBeforAdvice(accountDAO, membershipDAO);
		};
	}

	private void demoTheBeforAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// call the business method
		Account account = new Account();
		accountDAO.addAccount(account, true);
		accountDAO.doWork();

		membershipDAO.addSilliyMember();
		membershipDAO.goToSleep();
	}

}