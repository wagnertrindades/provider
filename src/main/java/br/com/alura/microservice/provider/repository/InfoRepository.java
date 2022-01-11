package br.com.alura.microservice.provider.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.provider.model.InfoProvider;

@Repository
public interface InfoRepository extends CrudRepository<InfoProvider, Long> {
	
	InfoProvider findByState(String state);
}
