package com.ecomm.orderservice.service;


import com.ecomm.orderservice.dto.OrderDto;
import com.ecomm.orderservice.dto.OrderRequestDto;
import com.ecomm.orderservice.exception.ECommOrderException;

public interface OrderService {

	OrderDto placeOrder(OrderRequestDto orderRequestDto, String traceId) throws ECommOrderException;
}
