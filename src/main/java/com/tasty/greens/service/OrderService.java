package com.tasty.greens.service;

import org.springframework.stereotype.Service;

import com.tasty.greens.controller.dto.OrderRequest;
import com.tasty.greens.controller.dto.OrderResponse;
import com.tasty.greens.model.Order;

@Service
public interface OrderService {

	public OrderResponse placeOrder(OrderRequest request);
	public OrderResponse fetchOrderById(long orderId);
}
