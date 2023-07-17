package com.tasty.greens.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasty.greens.controller.dto.OrderRequest;
import com.tasty.greens.controller.dto.OrderResponse;
import com.tasty.greens.model.Order;
import com.tasty.greens.mongo.util.OrderSequenceGenerator;
import com.tasty.greens.repository.OrderRepository;
import com.tasty.greens.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderSequenceGenerator orderSequenceGenerator;

	@Override
	public OrderResponse placeOrder(OrderRequest request) {
		Order order = Order.builder()
				.id(orderSequenceGenerator.generateSequence(Order.SEQUENCE_NAME))
				.amount(request.getAmount())
				.items(request.getItems())
				.orderDate(new Date().toGMTString())
				.deliveryStatus("InProgress")
				.build(); 
		order = orderRepository.save(order);
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderId(String.valueOf(order.getId()));
		return orderResponse;
	}

	@Override
	public OrderResponse fetchOrderById(long orderId) {
		Optional<Order> orderRes = orderRepository.findById(orderId);
		if(orderRes.isPresent()) {
			Order order = orderRes.get();
			OrderResponse orderResponse = new OrderResponse();
			orderResponse.setOrderId(String.valueOf(order.getId()));
			orderResponse.setAmount(order.getAmount());
			orderResponse.setItems(order.getItems());
			orderResponse.setOrderDate(order.getOrderDate());
			orderResponse.setDeliveryStatus(order.getDeliveryStatus());
			return orderResponse;
		}
		return null;
	}

}
