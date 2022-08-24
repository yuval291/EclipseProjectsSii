package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.ProductException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public List<Product> getProducts(){
		return productRepo.findAll();
	}
	
	@Transactional
	public Product addProduct(Product p) throws ProductException {
		
		if(productRepo.existsById(p.getProductCode())) {
			throw new ProductException("This product already exists");
		}
		
		return productRepo.save(p);
	}
	
	@Transactional
	public void updateProductAmount(Integer productCode, Integer productAmount) {
		
		Product p = productRepo.getReferenceById(productCode);
		p.setProductAmount(productAmount);
	}

	@Transactional
	public void cancelProduct(Product p) {
		productRepo.delete(p);
	}

	

}
