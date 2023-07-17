package com.tasty.greens.controller.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse {

	private String orderId;
	private String user;
	private String amount;
	private List<Item> items;
	private String orderDate;
	private String deliveryStatus;
}
