package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Account;
import com.example.demo.models.Loan;
import com.example.demo.service.LoanService;

@RestController
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	@PostMapping(value = "providing-loan-to-customer")
	public ResponseEntity<Loan> providingLoanToCustomer(@RequestHeader long customerId,
														   @RequestHeader long accountNumber,
														   @RequestHeader int sum,
														   @RequestHeader int months) {
		try {
			Loan loan = this.loanService.providingLoanToCustomer(accountNumber,
																 sum,
																 customerId,
																 months);
			return new ResponseEntity<Loan>(loan, HttpStatus.OK);	
		}
		catch(Exception e) {
			return new ResponseEntity<Loan>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "repayment-of-loan")
	public ResponseEntity<Loan> repaymentOfLoan(@RequestHeader int loanNumber, @RequestHeader Double amount) {
		try {
			Loan loan = this.loanService.repaymentOfLoan(loanNumber,amount);
			return new ResponseEntity<Loan>(loan, HttpStatus.OK);	
		}
		catch(Exception e) {
			return new ResponseEntity<Loan>(HttpStatus.BAD_REQUEST);
		}
	}

}
