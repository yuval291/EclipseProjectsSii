package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ProductException;
import com.example.demo.model.Product;
import com.example.demo.model.Transaction;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.TransactionRepository;

@Service
public class ManagerService {
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private TransactionRepository transactionRepository;
	
	
	public List<Product> getProduct() {
		return productRepository.findAll();
	}

	@Transactional
	public Product addProduct(Product p) throws ProductException {
		
		if (productRepository.existsById(p.getProductCode()))
			throw new ProductException("Product already exsits");

		return productRepository.save(p);
	}

	@Transactional
	public List<Product> addProducts(Product... products) {
		
		List<Product> productsList = Arrays.asList(products);
		return productRepository.saveAll(productsList);
	}

	@Transactional
	public void updateProductAmount(Integer productCode, Integer productAmount) {
		
		Product p = productRepository.getReferenceById(productCode);
		p.setProductAmount(productAmount);
	}

	@Transactional
	public void cancelProductFromTransaction(Integer transactionId, Integer productCode) {
		
		Transaction transaction = transactionRepository.getReferenceById(transactionId);
		Product product = productRepository.getReferenceById(productCode);

		Set<Product> products = transaction.getProducts();
		products.remove(product);
	}

	public List<Transaction> getTransactions() {
		return transactionRepository.findAll();
	}

	@Transactional
	public Transaction addTransaction(Transaction t) {
		return transactionRepository.save(t);
	}

	@Transactional
	public List<Transaction> addTransactions(Transaction... transactions) {
		
		List<Transaction> transactionsList = Arrays.asList(transactions);
		return transactionRepository.saveAll(transactionsList);
	}

	@Transactional
	public void addProductToTransaction(Integer transactionId, Integer productCode) {
		
		Transaction transaction = transactionRepository.getReferenceById(transactionId);
		Product product = productRepository.getReferenceById(productCode);

		Set<Transaction> transactions = product.getTransaction();
		Set<Product> products = transaction.getProducts();

		transactions.add(transaction);
		products.add(product);

		transaction.setProducts(products);
		product.setTransaction(transactions);
	}

	public void revenueReport() {
		List<Transaction> transactions = transactionRepository.findAll();
		double costs = 0;

		for (Transaction t : transactions) {
			costs += t.getTransactionCost();
		}

		System.out.println("The revenue is " + costs);

	}

	public void productInventory() {
		
		List<Product> products = productRepository.findAll();
		products.forEach((Product p) -> {
			System.out.println("product code:" + p.getProductCode() + ", product inventory: " + p.getProductAmount());
		});
	}

	public void missingProducts() {
		List<Product> products = productRepository.findAll();
		List<Product> missingProducts = new ArrayList<>();
		products.forEach((Product p) -> {
			if (p.getProductAmount() == 0)
				missingProducts.add(p);
		});

		System.out.println("Missing products: " + Arrays.toString(missingProducts.toArray()));
	}


}
