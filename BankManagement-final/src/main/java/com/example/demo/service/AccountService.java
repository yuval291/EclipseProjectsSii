package com.example.demo.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.models.Account;
import com.example.demo.models.Customer;
import com.example.demo.repository.AccountRepo;
import com.example.demo.repository.CustomerRepo;


import net.bytebuddy.asm.Advice.Return;


@Service
public class AccountService {

	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private EmailSenderService emailService;

	@Transactional
	public Account openAccount(Customer customer) {
		boolean flag = true;
		
		if(customerRepo.findById(customer.getCustomerId())==null) {
			return null;
		}
		
		while (flag) {
			int random = ThreadLocalRandom.current().nextInt(0, 1000000000 + 1);
			
			System.out.println(accountRepo.existsById((long)random));
			
			if(accountRepo.existsById((long)random) == false) {
				flag = false;
				Account account = new Account((long)random);
				account.setCustomer(customer);
				return accountRepo.save(account);
			}
		}
		return null;
	}


	public Account limitAccount(long accountNumber, double limit) {
		if(accountRepo.existsById(accountNumber)) {
			Account account = accountRepo.findById(accountNumber).get();
			account.setMinusLimit(limit);
			return accountRepo.save(account);
		}
		return null;
	}


	public Account holdAccount(long accountNumber) {
		if(accountRepo.existsById(accountNumber)) {
			Account account = accountRepo.findById(accountNumber).get();
			account.setActive(false);
			return accountRepo.save(account);
		}
		return null;
		
	}


	public Account depositToAccount(long accountNumber, double sum) {
		if(accountRepo.existsById(accountNumber)) {
			Account account = accountRepo.findById(accountNumber).get();
			double currSum = account.getCurrentBalance();
			account.setCurrentBalance(currSum+sum);
			return accountRepo.save(account);
		}
		return null;
	}


	public Account removeFromAccount(long accountNumber, double sum) {
		if(accountRepo.existsById(accountNumber)) {
			Account account = accountRepo.findById(accountNumber).get();
			
			double CurrentBalance = account.getCurrentBalance();
			double minusLimit = account.getMinusLimit();
			
			if((CurrentBalance-sum)<(0-minusLimit)){
				return null;
			}		
			account.setCurrentBalance(CurrentBalance-sum);
			return accountRepo.save(account);
		}
		return null;
	}
	
	public double balanceInquiry(long accountNumber) {
		if(accountRepo.existsById(accountNumber)) {
			Account account = accountRepo.findById(accountNumber).get();
			return account.getCurrentBalance();
		}
		return (Double) null;
	}

	@Transactional
	public boolean accountTransfer(long from, long to, double sum) {
		
		if(accountRepo.existsById(from) && accountRepo.existsById(to)) {
			Account fromAccount = accountRepo.findById(from).get();
			Account toAccount = accountRepo.findById(to).get();
			if(this.removeFromAccount(from , sum) != null) {
				depositToAccount(to, sum);
				return true;
			}
		}
		return false;
	}
	
	@Scheduled(cron = "35 * * * * ?")
	public void accountException() {
		List<Account> accounts = this.accountRepo.findAll();
		for (Account account : accounts) {
			if(account.getCurrentBalance() < (-1 * account.getMinusLimit())) {
				Customer customer = account.getCustomer();
				emailService.sendEmail("yuvaldemosii@gmail.com",
									   "Exception from the account",
									   "Dear customer, we are forced to inform you that you have exceeded the account,"
									   + " we ask you to settle the debt you have accumulated");
			}
		}
	}
}
