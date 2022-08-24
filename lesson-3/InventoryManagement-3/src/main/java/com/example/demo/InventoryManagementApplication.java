package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.exception.ProductException;
import com.example.demo.model.Product;
import com.example.demo.model.Transaction;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ManagerService;

@SpringBootApplication
public class InventoryManagementApplication implements CommandLineRunner {

	@Autowired
	ManagerService manageService;
	
	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Product p1 = new Product("p1" , 1 , 10 , 10F);
		Product p2 = new Product("p2" , 2 , 10 , 20F);
		Product p3 = new Product("p3" , 3 , 10 , 30F);
		Product p4 = new Product("p4" , 4 , 10 , 40F);
		Product p5 = new Product("p5" , 5 , 10 , 50F);
		Product p6 = new Product("p6" , 6 , 10 , 60F);
		Product p7 = new Product("p7" , 7 , 10 , 70F);
		Product p8 = new Product("p8" , 8 , 10 , 80F);
		Product p9 = new Product("p9" , 9 , 10 , 90F);
		Product p10 = new Product("p10" , 10 , 10 , 100F);
		
		manageService.addProducts(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
		
		Transaction t1 = new Transaction(1, new Date().toString(), 1D);
		Transaction t2 = new Transaction(2,  new Date().toString(), 2D);
		
		manageService.addTransactions(t1, t2);
		
		List<Transaction> transactions = manageService.getTransactions();
		transactions.forEach(System.out::println);
		
		manageService.addProductToTransaction(t1.getTransactionId(), p1.getProductCode());
		manageService.addProductToTransaction(t1.getTransactionId(), p2.getProductCode());
		manageService.addProductToTransaction(t1.getTransactionId(), p3.getProductCode());
		manageService.addProductToTransaction(t1.getTransactionId(), p4.getProductCode());
		
		manageService.updateProductAmount(p2.getProductCode(), 0);
		manageService.updateProductAmount(p3.getProductCode(), 0);
		manageService.cancelProductFromTransaction(t1.getTransactionId(), p1.getProductCode());
	
		System.out.println("\n\n*******************************************");
		manageService.revenueReport();
		manageService.productInventory();
		manageService.missingProducts();
	}

}
