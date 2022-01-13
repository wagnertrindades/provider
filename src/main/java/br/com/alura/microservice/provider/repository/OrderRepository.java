package br.com.alura.microservice.provider.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.provider.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

}
