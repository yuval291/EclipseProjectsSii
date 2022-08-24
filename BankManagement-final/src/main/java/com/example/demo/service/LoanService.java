package com.example.demo.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.models.Account;
import com.example.demo.models.Customer;
import com.example.demo.models.Loan;
import com.example.demo.repository.AccountRepo;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.repository.LoanRepository;


@Service
public class LoanService {
	
	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	private LoanRepository loanRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private AccountService accountService;

	public Loan providingLoanToCustomer(long accountNumber, int sum, long customerId, int months) {
		Account account = accountRepo.findById(accountNumber).get();
		boolean flag = true;
		if(account!=null) {
			Customer customer = customerRepo.findById(customerId).get();
			if(account.getCustomer().getCustomerId() == customer.getCustomerId()) {
				while(flag) {
					int randomLoanNum = ThreadLocalRandom.current().nextInt(0, 10000 + 1);
					if(loanRepo.existsById(randomLoanNum) == false) {
						flag = false;
						account.addCurrentBalance(sum);
						double monthlyRepayment = monthlyRepaymentCalculation(sum , months) ;
						Loan loan = new Loan(randomLoanNum,
											 sum,
											 true,
											 10,
											 monthlyRepayment,
											 accountNumber,
											 customer);
						return this.loanRepo.save(loan);
					}
				}
			}
		}
		return null;
	}
	
	public double monthlyRepaymentCalculation(int sum, int months) {
		double calculationAfterInterest = sum*1.1;
		double monthlyRepayment = calculationAfterInterest / months;
		return monthlyRepayment;
	}

	@Transactional
	public Loan repaymentOfLoan(Loan loan, Double amount) {
		if(loan != null)
		{
			if(loan.isStatus() == true) {
				if(amount > loan.getAmount()) {
					amount = amount - loan.getAmount();
				}
				this.accountService.removeFromAccount(loan.getAccountNumber(), amount);
				double currLoan = loan.getAmount();
				loan.setAmount((int) (currLoan-amount));
				if(loan.getAmount() <= 0) {
					loan.setStatus(false);
				}
				return loan;
			}
		}
		return null;
		
	}
	
	@Transactional
	public Loan repaymentOfLoan(int loanNumber, Double amount) {
		Loan loan = loanRepo.findById(loanNumber).get();
		return repaymentOfLoan(loan, amount);
	}

	@Scheduled(cron = "0 50 12 25 * ?")
	public void monthlyChargeOfLoan() {
		List<Loan> listOfLoans = loanRepo.findAll();
		for (Loan loan : listOfLoans) {
			Loan l = repaymentOfLoan(loan, loan.getMonthlyRepayment());
			loanRepo.save(l);
		}
		System.out.println("********************");
	}
}
