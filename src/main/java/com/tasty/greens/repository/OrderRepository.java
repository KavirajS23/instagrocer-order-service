package com.tasty.greens.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tasty.greens.model.Order;

public interface OrderRepository extends MongoRepository<Order, Long> {

}
