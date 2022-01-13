package br.com.alura.microservice.provider.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.provider.controller.dto.OrderItemDTO;
import br.com.alura.microservice.provider.model.Order;
import br.com.alura.microservice.provider.model.OrderItem;
import br.com.alura.microservice.provider.model.Product;
import br.com.alura.microservice.provider.repository.OrderRepository;
import br.com.alura.microservice.provider.repository.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public Order createOrder(List<OrderItemDTO> itens) {
		
		if(itens == null) {
			return null;
		}
		
		List<OrderItem> orderItens = toOrderItem(itens);
		Order order = new Order(orderItens);
		order.setPreparationTime(itens.size());
		
		return orderRepository.save(order);
	}
	
	public Order getOrderById(Long id) {
		return this.orderRepository.findById(id).orElse(new Order());
	}

	private List<OrderItem> toOrderItem(List<OrderItemDTO> itens) {
		
		List<Long> productIds = itens
				.stream()
				.map(item -> item.getId())
				.collect(Collectors.toList());
		
		List<Product> orderProducts = productRepository.findByIdIn(productIds);
		
		List<OrderItem> orderItens = itens
				.stream()
				.map(item -> {
					Product product = orderProducts
							.stream()
							.filter(p -> p.getId() == item.getId())
							.findFirst().get();
					
					OrderItem orderItem = new OrderItem();
					orderItem.setProduct(product);
					orderItem.setAmount(item.getAmount());
					return orderItem;
				})
				.collect(Collectors.toList());
		
		return orderItens;
	}
}
