package com.ecomm.orderservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.orderservice.dto.OrderRequestDto;
import com.ecomm.orderservice.service.impl.OrderServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {


	private final OrderServiceImpl orderService;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String placeOrder(@RequestBody OrderRequestDto orderRequestDto,@RequestParam String traceId) {
		
		orderService.placeOrder(orderRequestDto,traceId);
		
		return "Order placed succefully";
		
	}
	
}
