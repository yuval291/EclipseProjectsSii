package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Account;
import com.example.demo.models.Customer;
import com.example.demo.models.ForeignExchange;
import com.example.demo.service.AccountService;
import com.example.demo.service.ForeignExchangeService;

@RestController
public class ForeignExchangeController {
	
	@Autowired
	private ForeignExchangeService foreignExchangeService;
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping(value = "/deposit-foreign-currency/{from}/{to}/{sum}/{accountNumber}")
	public ResponseEntity<Account> depositForeignCurrency(@PathVariable String from, 
											   @PathVariable String to ,
											   @PathVariable double sum,
											   @PathVariable long accountNumber) {
		try {
			double convert = foreignExchangeService.convert(from,sum, to);
			Account a = accountService.depositToAccount(accountNumber, convert);
			return new ResponseEntity<Account>(a,HttpStatus.OK);	
		}
		catch(Exception e) {
			return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping(value = "/remove-foreign-currency/{to}/{sum}/{accountNumber}")
	public ResponseEntity<Account> removeForeignCurrency(@PathVariable String to ,
											   			 @PathVariable double sum,
											   			 @PathVariable long accountNumber) {
		try {
			double convert = foreignExchangeService.convert(to,sum, "ILS");
			System.out.println("CONVERT = "+convert);
			Account a = accountService.removeFromAccount(accountNumber, convert);
			return new ResponseEntity<Account>(a,HttpStatus.OK);	
		}
		catch(Exception e) {
			return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
		}
	}
	

}
