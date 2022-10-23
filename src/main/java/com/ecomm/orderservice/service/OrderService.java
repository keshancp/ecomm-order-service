package com.ecomm.orderservice.service;

import com.ecomm.orderservice.dto.OrderRequestDto;

public interface OrderService {

	void placeOrder(OrderRequestDto orderRequestDto,String traceId);
}
