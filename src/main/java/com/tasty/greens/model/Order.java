package com.tasty.greens.model;

import java.util.List;

import javax.persistence.Transient;

import org.springframework.data.mongodb.core.mapping.Document;

import com.tasty.greens.controller.dto.Item;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "order")
public class Order {
	
	@Transient
	public static final String SEQUENCE_NAME = "order_sequence";

	private long id;
	private String user;
	private String amount;
	private List<Item> items;
	private String orderDate;
	private String deliveryStatus;
}
