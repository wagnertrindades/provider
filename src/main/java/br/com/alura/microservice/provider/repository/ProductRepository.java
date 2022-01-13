package br.com.alura.microservice.provider.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.provider.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findByState(String state);
	
	List<Product> findByIdIn(List<Long> ids);
}
