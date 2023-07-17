package com.tasty.greens.controller.dto;

import lombok.Data;

@Data
public class Item {

	private String title;
	private long quantity;
	private String description;
	private double price;
}
