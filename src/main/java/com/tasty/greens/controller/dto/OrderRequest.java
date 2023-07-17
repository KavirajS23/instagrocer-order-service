package com.tasty.greens.controller.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderRequest {

	private String user;
	private String amount;
	private List<Item> items;
}
