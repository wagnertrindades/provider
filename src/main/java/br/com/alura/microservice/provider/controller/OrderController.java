package br.com.alura.microservice.provider.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.provider.controller.dto.OrderItemDTO;
import br.com.alura.microservice.provider.model.Order;
import br.com.alura.microservice.provider.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {
	
	private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

	
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public Order createOrder(@RequestBody List<OrderItemDTO> products) {
		
		LOG.info("order received");
		return orderService.createOrder(products);
	}
	
	@RequestMapping("/{id}")
	public Order getOrderById(@PathVariable("id") Long id) {
		return orderService.getOrderById(id);
	}
}
