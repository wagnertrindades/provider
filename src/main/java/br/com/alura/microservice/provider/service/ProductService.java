package br.com.alura.microservice.provider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.provider.repository.ProductRepository;
import br.com.alura.microservice.provider.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProductsByState(String state) {
		return productRepository.findByState(state);
	}
	
}
