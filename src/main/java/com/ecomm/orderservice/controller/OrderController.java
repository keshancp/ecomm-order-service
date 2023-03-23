package com.ecomm.orderservice.controller;


import com.ecomm.orderservice.dto.ECommInventoryResponse;
import com.ecomm.orderservice.dto.OrderDto;
import com.ecomm.orderservice.exception.ECommOrderException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.orderservice.dto.OrderRequestDto;
import com.ecomm.orderservice.service.impl.OrderServiceImpl;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {


	private final OrderServiceImpl orderService;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> placeOrder(@Valid @RequestBody OrderRequestDto orderRequestDto, @RequestParam String traceId) throws ECommOrderException {
		
		OrderDto orderDto= orderService.placeOrder(orderRequestDto,traceId);
		
		return new ResponseEntity<>(new ECommInventoryResponse(HttpStatus.CREATED.value(),"Order Placed Successfully",orderDto),HttpStatus.CREATED);
		
	}
	
}
