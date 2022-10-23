package com.ecomm.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomm.orderservice.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

}
