package com.ecomm.orderservice.service;


import com.ecomm.ecommlib.exception.ECommException;
import com.ecomm.orderservice.dto.OrderDto;
import com.ecomm.orderservice.dto.OrderRequestDto;

public interface OrderService {

	OrderDto placeOrder(OrderRequestDto orderRequestDto, String traceId) throws ECommException;
}
