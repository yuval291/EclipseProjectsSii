package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Account;
import com.example.demo.models.Customer;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping(value = "/open-account")
	public ResponseEntity<Account> openAccount(@RequestBody Customer newCustomer) {
		try {
			Account a=accountService.openAccount(newCustomer);
			return new ResponseEntity<Account>(a, HttpStatus.OK);	
		}
		catch(Exception e) {
			return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/limit-account/{accountNumber}/{limit}")
	public ResponseEntity<Account> limitAccount(@PathVariable long accountNumber ,@PathVariable double limit) {
		try {
			Account a=accountService.limitAccount(accountNumber,limit);
			return new ResponseEntity<Account>(a, HttpStatus.OK);	
		}
		catch(Exception e) {
			return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/hold-account/{accountNumber}")
	public ResponseEntity<Account> holdAccount(@PathVariable long accountNumber) {
		try {
			Account a=accountService.holdAccount(accountNumber);
			return new ResponseEntity<Account>(a, HttpStatus.OK);	
		}
		catch(Exception e) {
			return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "deposit-to-account/{accountNumber}/{sum}")
	public ResponseEntity<Account> depositToAccount(@PathVariable long accountNumber , @PathVariable double sum){
		try {
			Account a=accountService.depositToAccount(accountNumber,sum);
			return new ResponseEntity<Account>(a, HttpStatus.OK);	
		}
		catch(Exception e) {
			return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "remove-from-account/{accountNumber}/{sum}")
	public ResponseEntity<Account> removeFromAccount(@PathVariable long accountNumber , @PathVariable double sum){
		try {
			Account a=accountService.removeFromAccount(accountNumber,sum);
			return new ResponseEntity<Account>(a, HttpStatus.OK);	
		}
		catch(Exception e) {
			return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "balance-inquiry/{accountNumber}")
	public ResponseEntity<Double> balanceInquiry(@PathVariable long accountNumber){
		try {
			Double balance=accountService.balanceInquiry(accountNumber);
			return new ResponseEntity<Double>(balance, HttpStatus.OK);	
		}
		catch(Exception e) {
			return new ResponseEntity<Double>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "account-transfer/{from}/{to}/{sum}")
	public ResponseEntity<Boolean> accountTransfer(@PathVariable long from,
												  @PathVariable long to,
												  @PathVariable double sum){
		try {
			Boolean ifTransferMoney=accountService.accountTransfer(from,to,sum);
			return new ResponseEntity<Boolean>(ifTransferMoney, HttpStatus.OK);	
		}
		catch(Exception e) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
	}
}
